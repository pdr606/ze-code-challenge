package pdr606.zecodechallengetest.application.usecases;

import pdr606.zecodechallengetest.application.gateways.PartnerGetaway;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

public class FindByIdPartnerUseCase {

    private final PartnerGetaway partnerGetaway;

    public FindByIdPartnerUseCase(PartnerGetaway partnerGetaway) {
        this.partnerGetaway = partnerGetaway;
    }

    public Partner findById(String id){
        return partnerGetaway.findById(id);
    }
}
