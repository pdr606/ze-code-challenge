package pdr606.zecodechallengetest.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdr606.zecodechallengetest.application.usecases.CreatePartnerUseCase;
import pdr606.zecodechallengetest.application.usecases.FindByIdPartnerUseCase;
import pdr606.zecodechallengetest.application.usecases.FindProximPartnerUseCase;
import pdr606.zecodechallengetest.controllers.dto.*;
import pdr606.zecodechallengetest.core.domain.partner.Partner;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public ResponseEntity<Void> createPartners(@RequestBody @Valid  List<PartnerRequestDto> partners) {
        List<Partner> partnerBusinessObj = PartnerDtoMapper.toPartner(partners);
        createPartnerUseCase.createPartner(partnerBusinessObj);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/proxim")
    public ResponseEntity<PartnerResponseDto> findProximPartner(@RequestBody @Valid  FindProximPartnerRequestDto request){
        Partner partner = findProximPartnerUseCase.findProximPartner(request.lat(), request.lon());
        return ResponseEntity.ok().body(PartnerDtoMapper.toResponse(partner));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PartnerResponseDto> findById(@PathVariable @Valid String id){
        Partner partner = findByIdPartnerUseCase.findById(id);
        return ResponseEntity.ok().body(PartnerDtoMapper.toResponse(partner));
    }
}
