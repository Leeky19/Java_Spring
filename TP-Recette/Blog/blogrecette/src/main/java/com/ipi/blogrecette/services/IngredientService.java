package com.ipi.blogrecette.services;

import com.ipi.blogrecette.pojos.Ingredient;

import java.util.List;

public interface IngredientService {

    Ingredient ajouterIngredient(Ingredient ingredient);

    Ingredient recupererIngredient(Long idIngredient);

    List<Ingredient> recupererIngredients();
}