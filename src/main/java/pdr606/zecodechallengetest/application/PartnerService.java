package pdr606.zecodechallengetest.application;

import org.springframework.stereotype.Service;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.adapters.persistence.MongoPartnerRepository;
import pdr606.zecodechallengetest.core.domain.Partner;
import pdr606.zecodechallengetest.adapters.gateway.PartnerGateway;

import java.util.List;

@Service
public class PartnerService implements PartnerGateway {
    private final MongoPartnerRepository mongoPartnerRepository;
    public PartnerService(MongoPartnerRepository mongoPartnerRepository) {
        this.mongoPartnerRepository = mongoPartnerRepository;
    }
    @Override
    public void registerPartner(List<Partner> partners) {
        List<PartnerData> partnerDataList = PartnerData.toDomainObj(partners);
        mongoPartnerRepository.saveAll(partnerDataList);
    }
    @Override
    public Partner seachPartnerById(String id) {
        return null;
    }
}
