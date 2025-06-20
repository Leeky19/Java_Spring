package com.ipi.blogrecette.services;

import com.ipi.blogrecette.pojos.Categorie;
import com.ipi.blogrecette.pojos.Recette;

import java.util.List;

public interface CategorieService {

    Categorie ajouterCategorie(Categorie categorie);

    Categorie recupererCategorie(Long idCategorie);

    List<Categorie> recupererCategories();

    List<Recette> recupererRecettes(Categorie categorie);
}