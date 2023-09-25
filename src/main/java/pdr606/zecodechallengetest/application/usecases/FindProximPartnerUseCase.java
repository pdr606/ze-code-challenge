package pdr606.zecodechallengetest.application.usecases;

import pdr606.zecodechallengetest.application.gateways.PartnerGetaway;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

public class FindProximPartnerUseCase {

    private final PartnerGetaway partnerGetaway;

    public FindProximPartnerUseCase(PartnerGetaway partnerGetaway) {
        this.partnerGetaway = partnerGetaway;
    }

    public Partner findProximPartner(double lat, double lon){
        return partnerGetaway.findProximPartner(lat, lon);
    }
}
