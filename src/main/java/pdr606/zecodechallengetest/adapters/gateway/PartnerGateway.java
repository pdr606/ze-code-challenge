package pdr606.zecodechallengetest.adapters.gateway;

import pdr606.zecodechallengetest.adapters.dto.RequestLongLatDTO;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;
import java.util.Optional;

public interface PartnerGateway {
    void register(List<Partner> partners);

    List<PartnerData> findAll();

<<<<<<< HEAD
    PartnerData findProximPartner(double lat, double lon);
=======
    PartnerData findProximPartner(RequestLongLatDTO data);
>>>>>>> f0c0bb1f1af33109d0bb8443bbd00fc9ca0373f6

    Optional<PartnerData> findById(String id);
}
