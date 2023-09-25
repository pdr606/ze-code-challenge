package pdr606.zecodechallengetest.application1.gateways;

import pdr606.zecodechallengetest.core.domain.partner.Partner;
import pdr606.zecodechallengetest.infra.persistence.PartnerEntity;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerEntityMapper {

    public PartnerEntity toEntity(Partner partner) {
        return new PartnerEntity(
                partner.getId(),
                partner.getTradingName(),
                partner.getOwnerName(),
                partner.getDocument(),
                partner.getAddress(),
                partner.getCoverageArea()
        );
    }
    public List<PartnerEntity> toEntity(List<Partner> partnerDomainObj) {
        return partnerDomainObj.stream()
                .map(partner -> new PartnerEntity(
                        partner.getId(),
                        partner.getTradingName(),
                        partner.getOwnerName(),
                        partner.getDocument(),
                        partner.getAddress(),
                        partner.getCoverageArea()
                ))
                .collect(Collectors.toList());
    }

    public Partner toDomainObj(PartnerEntity partnerEntity) {
        return new Partner(
                partnerEntity.getId(),
                partnerEntity.getTradingName(),
                partnerEntity.getOwnerName(),
                partnerEntity.getDocument(),
                partnerEntity.getAddress(),
                partnerEntity.getCoverageArea()
        );
    }


     public List<Partner> toDomainObj(List<PartnerEntity> partnerEntities) {
        return partnerEntities.stream()
                .map(partnerEntity ->
                        new Partner(
                                partnerEntity.getId(),
                                partnerEntity.getTradingName(),
                                partnerEntity.getOwnerName(),
                                partnerEntity.getDocument(),
                                partnerEntity.getAddress(),
                                partnerEntity.getCoverageArea()
                        ))
                .collect(Collectors.toList());
    }
}
