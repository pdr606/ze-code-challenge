package pdr606.zecodechallengetest.application;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.MultiPolygon;
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
import java.util.Map;
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
    public List<PartnerData> findProximPartner(RequestLongLatDTO data) {
        try{
            Geometry referencePoint = createPointFromCoordinates(data.Lat(), data.Long());
            

            List<PartnerData> allPartners = findAll();

            List<PartnerData> nearbyPartners = new ArrayList<>();

            for(PartnerData partner : allPartners){
                boolean isWithinCoverageArea = isWithinCoverageArea(referencePoint, );

                if(isWithinCoverageArea){
                    nearbyPartners.add(partner);
                }
            }


        }
        catch (){

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<PartnerData> findById(String id) {
        return partnerRepository.findById(id);
    }


    private Geometry createPointFromCoordinates(double lon, double lat) throws ParseException {
        return new WKTReader().read("POINT (" +
                lon + " " + lat + ")");
    }

    private boolean isWithinCoverageArea(Geometry referencePoint, MultiPolygon coverageArea){
        return referencePoint.within(coverageArea);
    }
}
