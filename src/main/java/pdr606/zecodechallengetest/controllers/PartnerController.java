package pdr606.zecodechallengetest.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdr606.zecodechallengetest.application.PartnerService;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerService;

    public PartnerController(PartnerService partnerRepositoryImp) {
        this.partnerService = partnerRepositoryImp;
    }

    @PostMapping
    public ResponseEntity<String> sendNewPartners(@RequestBody List<Partner> partners){
        partnerService.registerPartner(partners);
        return ResponseEntity.ok("success");
    }
}
