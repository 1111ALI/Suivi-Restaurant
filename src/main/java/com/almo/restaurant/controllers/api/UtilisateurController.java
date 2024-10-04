package com.almo.restaurant.controllers.api;

import com.almo.restaurant.entity.Utilisateur;
import com.almo.restaurant.service.serviceInterf.UtilisateurServiceInterf;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/utilisateurs")
public class UtilisateurController {
    private final UtilisateurServiceInterf utilisateurServiceInterf;

    @GetMapping("/all")
    public List<Utilisateur> getAllUtilisateur(){
        return utilisateurServiceInterf.getAllUtilisateur();
    }
    @PostMapping("/create")
    public Utilisateur createUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurServiceInterf.createUtilisateur(utilisateur);
    }

}
