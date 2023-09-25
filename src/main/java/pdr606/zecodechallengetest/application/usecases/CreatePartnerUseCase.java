package pdr606.zecodechallengetest.application.usecases;

import pdr606.zecodechallengetest.application.gateways.PartnerGetaway;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;

public class CreatePartnerUseCase {
    private final PartnerGetaway partnerGetaway;
    public CreatePartnerUseCase(PartnerGetaway partnerGetaway) {
        this.partnerGetaway = partnerGetaway;
    }
    public void createPartner(List<Partner> partner){
        partnerGetaway.createPartner(partner);
    }
}
