package com.almo.restaurant.service.serviceInterf;

import com.almo.restaurant.entity.Utilisateur;

import java.util.List;

public interface UtilisateurServiceInterf {
    List<Utilisateur> getAllUtilisateur();

    Utilisateur createUtilisateur(Utilisateur utilisateur);
}
