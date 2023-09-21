package pdr606.zecodechallengetest.core.usecases;

import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;

public interface PartnerUseCase {
    void registerPartner(List<Partner> partners);

    Partner seachPartnerById(String id);
}
