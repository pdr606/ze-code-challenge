package pdr606.zecodechallengetest.controllers.dto;

import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerDtoMapper {

     public static List<CreatePartnerResponseDto> toResponse(List<Partner> partners){
        return partners.stream().map(
                partner ->
                    new CreatePartnerResponseDto(
                            partner.getId(),
                            partner.getTradingName(),
                            partner.getOwnerName(),
                            partner.getDocument(),
                            partner.getAddress(),
                            partner.getCoverageArea()
                    )

        ).collect(Collectors.toList());
    }
    
    public static List<Partner> toPartner(List<CreatePartnerRequestDto> request){
        return request.stream().map(partner -> 
                new Partner(
                  partner.id(),
                        partner.tradingName(),
                        partner.ownerName(),
                        partner.document(), 
                        partner.address(),
                        partner.coverageArea()
                )
                ).collect(Collectors.toList());
    }
}
