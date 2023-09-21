package pdr606.zecodechallengetest.application;

import org.springframework.stereotype.Service;
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
    public Optional<PartnerData> findById(String id) {
        return partnerRepository.findById(id);
    }
}
