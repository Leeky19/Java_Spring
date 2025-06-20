package com.ipi.blogrecette.controllers;

import com.ipi.blogrecette.pojos.Categorie;
import com.ipi.blogrecette.pojos.Commentaire;
import com.ipi.blogrecette.pojos.Ingredient;
import com.ipi.blogrecette.pojos.Membre;
import com.ipi.blogrecette.pojos.Recette;
import com.ipi.blogrecette.services.*;
import jakarta.annotation.PostConstruct;

import java.util.Date;

import org.springframework.stereotype.Controller;

@Controller
public class InitDataController {

    // Le contrôleur a besoin des services
    private final MembreService membreService;
    private final CategorieService categorieService;
    private final RecetteService recetteService;
    private final IngredientService ingredientService;
    private final CommentaireService commentaireService;

    // Constructeur pour injection de dépendances
    public InitDataController(MembreService membreService,
                              CategorieService categorieService,
                              RecetteService recetteService,
                              IngredientService ingredientService,
                              CommentaireService commentaireService) {
        this.membreService = membreService;
        this.categorieService = categorieService;
        this.recetteService = recetteService;
        this.ingredientService = ingredientService;
        this.commentaireService = commentaireService;
    }

    // Cette méthode est appelée automatiquement au lancement
@PostConstruct
private void init() {
    // 1. Créer 2 membres
    var membre1 = membreService.ajouterMembre(new Membre(null, "Durand", "du77", "azerty", "du77@mail.com", new Date(), null));
    var membre2 = membreService.ajouterMembre(new Membre(null, "Martin", "mart1", "azerty", "martin@mail.com", new Date(), null));

    // 2. Créer 2 catégories
    var cat1 = categorieService.ajouterCategorie(new Categorie(null, "Plat Savoyard", null));
    var cat2 = categorieService.ajouterCategorie(new Categorie(null, "Soupe", null));

    // 3. Créer 2 recettes
    var recette1 = recetteService.ajouterRecette(new Recette(null, "Tartiflette", "Une vraie recette savoyarde", "du77", "tartiflette.jpg", new Date(), membre1, cat1, null, null));
    var recette2 = recetteService.ajouterRecette(new Recette(null, "Velouté de carotte", "Soupe onctueuse au cumin", "mart1", "veloute.jpg", new Date(), membre2, cat2, null, null));

    // 4. Ingrédients de la Tartiflette (recette_id = 1)
    ingredientService.ajouterIngredient(new Ingredient(null, "Pommes de terre", 750, "g", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Reblochon", 1, "u", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Lardons", 200, "g", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Crème fraîche épaisse", 3, "cs", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Oignons", 2, "u", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Beurre", 20, "g", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Sel", 1, "cc", recette1));
    ingredientService.ajouterIngredient(new Ingredient(null, "Poivre", 1, "p", recette1));

    // 5. Ingrédients du Velouté de carottes (recette_id = 2)
    ingredientService.ajouterIngredient(new Ingredient(null, "Carottes", 800, "g", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Oignon", 1, "u", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Bouillon de volaille", 1, "l", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Cumin", 1, "cs", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Crème fraîche épaisse", 2, "cs", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Huile d’olive", 2, "cs", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Sel", 1, "cc", recette2));
    ingredientService.ajouterIngredient(new Ingredient(null, "Poivre", 1, "p", recette2));

    // 6. Commentaires
    commentaireService.ajouterCommentaire(new Commentaire(null, "Julie", "Excellent plat montagnard 😋", 5, new Date(), recette1));
    commentaireService.ajouterCommentaire(new Commentaire(null, "Nico", "Bonne soupe d’hiver, parfumée", 4, new Date(), recette2));
}
}