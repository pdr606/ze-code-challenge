package pdr606.zecodechallengetest.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdr606.zecodechallengetest.adapters.dto.RequestLongLatDTO;
import pdr606.zecodechallengetest.adapters.entities.PartnerData;
import pdr606.zecodechallengetest.application.PartnerService;
import pdr606.zecodechallengetest.core.domain.Partner;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService partnerService;

<<<<<<< HEAD
=======

>>>>>>> f0c0bb1f1af33109d0bb8443bbd00fc9ca0373f6
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @PostMapping
    public ResponseEntity<String> sendNewPartners(@RequestBody List<Partner> partners){
        partnerService.register(partners);
        return ResponseEntity.ok("success");
    }

    @GetMapping ResponseEntity<List<PartnerData>> findAll(){
        return ResponseEntity.ok().body(partnerService.findAll());
    }

<<<<<<< HEAD

    @GetMapping(value = "/search")
    public ResponseEntity<PartnerData> teste(@RequestBody RequestLongLatDTO data){
        PartnerData partner = partnerService.findProximPartner(data.Lat(), data.Long());
        return ResponseEntity.ok().body(partner);
=======
    @PostMapping(value = "/search")
    public ResponseEntity<PartnerData> teste(@RequestBody RequestLongLatDTO data){
        PartnerData list = partnerService.findProximPartner(data);
        return  ResponseEntity.ok().body(list);
>>>>>>> f0c0bb1f1af33109d0bb8443bbd00fc9ca0373f6
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PartnerData> findById(@PathVariable String id){
        PartnerData partner = partnerService.findById(id).get();
        return ResponseEntity.ok().body(partner);
    }
}
