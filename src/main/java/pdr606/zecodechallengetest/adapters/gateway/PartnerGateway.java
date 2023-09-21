package pdr606.zecodechallengetest.adapters.gateway;

import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;
import java.util.Optional;

public interface PartnerGateway {
    void register(List<Partner> partners);

    List<PartnerData> findAll();

    Optional<PartnerData> findById(String id);
}
