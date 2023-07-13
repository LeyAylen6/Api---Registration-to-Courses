package com.example.Project.UNRN.controllers;

import com.example.Project.UNRN.domain.Inscription;
import com.example.Project.UNRN.dto.InscriptionData;
import com.example.Project.UNRN.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inscription")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @PostMapping
    public String saveInscription(@RequestBody InscriptionData inscriptionData) {
        return inscriptionService.newInscription(inscriptionData);
    }
}
