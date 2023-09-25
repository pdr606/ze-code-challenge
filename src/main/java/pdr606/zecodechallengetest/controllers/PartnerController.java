package pdr606.zecodechallengetest.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdr606.zecodechallengetest.application1.usecases.CreatePartnerUseCase;
import pdr606.zecodechallengetest.application1.usecases.FindByIdPartnerUseCase;
import pdr606.zecodechallengetest.application1.usecases.FindProximPartnerUseCase;
import pdr606.zecodechallengetest.controllers.dto.CreatePartnerRequestDto;
import pdr606.zecodechallengetest.controllers.dto.FindProximPartnerRequestDto;
import pdr606.zecodechallengetest.controllers.dto.PartnerDtoMapper;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    private final CreatePartnerUseCase createPartnerUseCase;
    private final FindByIdPartnerUseCase findByIdPartnerUseCase;
    private final FindProximPartnerUseCase findProximPartnerUseCase;
    private final PartnerDtoMapper partnerDtoMapper;

    public PartnerController(CreatePartnerUseCase createPartnerUseCase, FindByIdPartnerUseCase findByIdPartnerUseCase, FindProximPartnerUseCase findProximPartnerUseCase, PartnerDtoMapper partnerDtoMapper) {
        this.createPartnerUseCase = createPartnerUseCase;
        this.findByIdPartnerUseCase = findByIdPartnerUseCase;
        this.findProximPartnerUseCase = findProximPartnerUseCase;
        this.partnerDtoMapper = partnerDtoMapper;
    }

    @PostMapping
    public ResponseEntity<String> createPartners(@RequestBody List<CreatePartnerRequestDto> partners){
        List<Partner> partnerBusinessObj = PartnerDtoMapper.toPartner(partners);
        createPartnerUseCase.createPartner(partnerBusinessObj);
        return ResponseEntity.ok("success");
    }

    @GetMapping(value = "/proxim")
    public ResponseEntity<Partner> findProximPartner(@RequestBody FindProximPartnerRequestDto request){
        Partner partner = findProximPartnerUseCase.findProximPartner(request.lat(), request.lon());
        return ResponseEntity.ok().body(partner);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Partner> findById(@PathVariable String id){
        Partner partner = findByIdPartnerUseCase.findById(id);
        return ResponseEntity.ok().body(partner);
    }
}
