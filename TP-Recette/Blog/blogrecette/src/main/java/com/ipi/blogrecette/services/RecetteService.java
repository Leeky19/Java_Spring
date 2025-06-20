package com.ipi.blogrecette.services;

import com.ipi.blogrecette.pojos.Recette;
import com.ipi.blogrecette.pojos.Ingredient;
import com.ipi.blogrecette.pojos.Commentaire;

import java.util.List;

public interface RecetteService {

    Recette ajouterRecette(Recette recette);

    Recette recupererRecette(Long idRecette);

    List<Recette> recupererRecettes();

    List<Ingredient> recupererIngredients(Recette recette);

    List<Commentaire> recupererCommentaires(Recette recette);
}