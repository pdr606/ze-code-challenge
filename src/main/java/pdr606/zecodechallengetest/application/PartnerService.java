package pdr606.zecodechallengetest.application;

import com.mongodb.client.model.geojson.MultiPolygon;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.stereotype.Service;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.adapters.persistence.PartnerRepository;
import pdr606.zecodechallengetest.core.domain.Partner;
import pdr606.zecodechallengetest.adapters.gateway.PartnerGateway;

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

    public PartnerData findProximPartner(double lat, double lon) {
        List<PartnerData> partners = partnerRepository.findNearestPartners(lat, lon, 1);
        if(partners.isEmpty()){
            return null;
        }
        return partners.get(0);
    }


    @Override
    public Optional<PartnerData> findById(String id) {
        return partnerRepository.findById(id);
    }
}






