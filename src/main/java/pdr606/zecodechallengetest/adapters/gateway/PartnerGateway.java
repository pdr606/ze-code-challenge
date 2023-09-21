package pdr606.zecodechallengetest.adapters.gateway;

import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;

public interface PartnerGateway {
    void registerPartner(List<Partner> partners);

    Partner seachPartnerById(String id);
}
