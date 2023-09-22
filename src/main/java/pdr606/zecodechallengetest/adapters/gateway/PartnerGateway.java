package pdr606.zecodechallengetest.adapters.gateway;

import pdr606.zecodechallengetest.adapters.dto.RequestLongLatDTO;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;
import java.util.Optional;

public interface PartnerGateway {
    void register(List<Partner> partners);

    List<PartnerData> findAll();

    PartnerData findProximPartner(double lat, double lon);

    Optional<PartnerData> findById(String id);
}
