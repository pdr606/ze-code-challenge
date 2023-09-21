package pdr606.zecodechallengetest.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.adapters.persistence.MongoPartnerRepository;
import pdr606.zecodechallengetest.core.domain.Partner;
import pdr606.zecodechallengetest.core.usecases.PartnerUseCase;

import java.util.List;

@Service
public class PartnerService implements PartnerUseCase {
    private final MongoPartnerRepository mongoPartnerRepository;
    public PartnerService(MongoPartnerRepository mongoPartnerRepository) {
        this.mongoPartnerRepository = mongoPartnerRepository;
    }


    @Override
    public void registerPartner(List<Partner> partners) {
        List<PartnerData> partnerDataList = PartnerData.generatePartnerDataFromPartner(partners);
        mongoPartnerRepository.saveAll(partnerDataList);
    }

    @Override
    public Partner seachPartnerById(String id) {
        return null;
    }
}
