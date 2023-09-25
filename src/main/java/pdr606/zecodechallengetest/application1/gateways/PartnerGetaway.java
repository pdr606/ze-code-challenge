package pdr606.zecodechallengetest.application1.gateways;

import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;

public interface PartnerGetaway {
    void createPartner(List<Partner> partner);

    Partner findProximPartner(double lat, double lon);

    Partner findById(String id);

}
