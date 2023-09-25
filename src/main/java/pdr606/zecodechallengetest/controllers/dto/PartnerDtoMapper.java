package pdr606.zecodechallengetest.controllers.dto;

import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;
import java.util.stream.Collectors;

public class PartnerDtoMapper {

    public static PartnerResponseDto toResponse(Partner partner){
        return new PartnerResponseDto(
                partner.getId(),
                partner.getTradingName(),
                partner.getOwnerName(),
                partner.getDocument(),
                partner.getAddress(),
                partner.getCoverageArea()
        );
    }

    public static Partner toPartner(PartnerRequestDto request){
        return new Partner(
                request.id(),
                request.tradingName(),
                request.ownerName(),
                request.document(),
                request.address(),
                request.coverageArea()
        );
    }

     public static List<PartnerResponseDto> toResponse(List<Partner> partners){
        return partners.stream().map(
                partner ->
                    new PartnerResponseDto(
                            partner.getId(),
                            partner.getTradingName(),
                            partner.getOwnerName(),
                            partner.getDocument(),
                            partner.getAddress(),
                            partner.getCoverageArea()
                    )

        ).collect(Collectors.toList());
    }
    
    public static List<Partner> toPartner(List<PartnerRequestDto> request){
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
