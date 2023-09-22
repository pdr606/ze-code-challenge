package pdr606.zecodechallengetest.core.usecases;

import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;
import java.util.Optional;

public interface PartnerUseCase {
    void register(List<Partner> partners);

    List<PartnerData> findAll();

    PartnerData findProximPartner(double lat, double lon);

    Optional<PartnerData> findById(String id);
}
