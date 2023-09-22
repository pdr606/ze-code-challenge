package pdr606.zecodechallengetest.application;

import org.locationtech.jts.geom.*;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;
import org.springframework.stereotype.Service;
import pdr606.zecodechallengetest.adapters.dto.RequestLongLatDTO;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.adapters.persistence.PartnerRepository;
import pdr606.zecodechallengetest.core.domain.Partner;
import pdr606.zecodechallengetest.adapters.gateway.PartnerGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PartnerService implements PartnerGateway {
    private final PartnerRepository partnerRepository;

    public PartnerService(PartnerRepository partnerRepository) {
        this.partnerRepository = partnerRepository;
    }

    @Override
    public void register(List<Partner> partners) {
        List<PartnerData> partnerDataList = PartnerData.toDomainObj(partners);
        partnerRepository.saveAll(partnerDataList);
    }

    @Override
    public List<PartnerData> findAll() {
        return partnerRepository.findAll();
    }

    @Override
    public PartnerData findProximPartner(RequestLongLatDTO data) {
        try {
            Geometry referencePoint = createPointFromCoordinates(data.Lat(), data.Lat());

            List<PartnerData> allPartners = findAll();
            PartnerData nearestPartner = null;
            double nearestDistance = Double.MAX_VALUE;
            GeometryFactory factory = new GeometryFactory();

            for (PartnerData partner : allPartners) {
                MultiPolygon multiPolygon = convertToMultiPolygon(partner.getCoverageArea().getCoordinates(), factory);

                // Verifique se o ponto de referência está contido na área de cobertura
                if (multiPolygon.contains(referencePoint)) {
                    // Calcule a distância entre o ponto de referência e o endereço do parceiro
                    Point partnerPoint = (Point) createPointFromCoordinates(partner.getAddress().getCoordinates()[1], partner.getAddress().getCoordinates()[0]);
                    double distance = referencePoint.distance(partnerPoint);

                    // Se for a distância mais próxima até agora, atualize o parceiro mais próximo
                    if (distance < nearestDistance) {
                        nearestDistance = distance;
                        nearestPartner = partner;
                    }
                }
            }

            return nearestPartner;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }





    @Override
    public Optional<PartnerData> findById(String id) {
        return partnerRepository.findById(id);
    }

    private Geometry createPointFromCoordinates(double lat, double lon) throws ParseException {
        return new WKTReader().read("POINT (" + lon + " " + lat + ")");
    }


    private MultiPolygon convertToMultiPolygon(double[][][][] coordinates, GeometryFactory factory) {
        List<Polygon> polygons = new ArrayList<>();

        for (double[][][] polygonCoordinates : coordinates) {
            Polygon polygon = createPolygonFromCoordinates(polygonCoordinates, factory);
            polygons.add(polygon);
        }

        return new MultiPolygon(polygons.toArray(new Polygon[0]), factory);
    }

    private Polygon createPolygonFromCoordinates(double[][][] polygonCoordinates, GeometryFactory factory) {
        Coordinate[] coordinates = new Coordinate[polygonCoordinates[0].length];

        for (int i = 0; i < polygonCoordinates[0].length; i++) {
            coordinates[i] = new Coordinate(polygonCoordinates[0][i][0], polygonCoordinates[0][i][1]);
        }

        LinearRing linearRing = factory.createLinearRing(coordinates);
        return factory.createPolygon(linearRing);
    }

    private boolean isWithinCoverageArea(Geometry referencePoint, MultiPolygon coverageArea) {
        return referencePoint.within(coverageArea);
    }
}
