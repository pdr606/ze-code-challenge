package pdr606.zecodechallengetest.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdr606.zecodechallengetest.application.PartnerService;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerRepositoryImp;

    public PartnerController(PartnerService partnerRepositoryImp) {
        this.partnerRepositoryImp = partnerRepositoryImp;
    }

    @PostMapping
    public ResponseEntity<String> sendNewPartners(@RequestBody List<Partner> partners){
        partnerRepositoryImp.registerPartner(partners);
        return ResponseEntity.ok("success");
    }
}
