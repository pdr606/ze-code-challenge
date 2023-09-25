package pdr606.zecodechallengetest.application.gateways;

import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;

public interface PartnerGetaway {
    void createPartner(List<Partner> partner);

    Partner findProximPartner(double lat, double lon);

    Partner findById(String id);

    double calculateDistance(double lat1, double lon1, double lat2, double lon2);
}
