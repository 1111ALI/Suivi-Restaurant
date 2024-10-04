package com.almo.restaurant.service.serviceImpl;

import com.almo.restaurant.entity.Utilisateur;
import com.almo.restaurant.repository.UtilisateurRepository;
import com.almo.restaurant.service.serviceInterf.UtilisateurServiceInterf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurServiceInterf {
    private final UtilisateurRepository utilisateurRepository;

    @Override
    public List<Utilisateur> getAllUtilisateur() {
        List<Utilisateur> utilisateurList = utilisateurRepository.findAll();
        return utilisateurList;
    }

    @Override
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }


}
