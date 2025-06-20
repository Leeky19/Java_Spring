package com.ipi.blogrecette.services;

import com.ipi.blogrecette.pojos.Membre;
import com.ipi.blogrecette.pojos.Recette;

import java.util.List;

public interface MembreService {

    Membre ajouterMembre(Membre membre);

    Membre recupererMembre(Long idMembre);

    List<Membre> recupererMembres();

    List<Recette> recupererRecettes(Membre membre);
}