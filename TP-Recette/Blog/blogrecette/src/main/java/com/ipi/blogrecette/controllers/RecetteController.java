package com.ipi.blogrecette.controllers;

import com.ipi.blogrecette.pojos.*;
import com.ipi.blogrecette.dao.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class RecetteController {

    private final RecetteDao recetteDao;
    private final IngredientDao ingredientDao;
    private final CommentaireDao commentaireDao;

    public RecetteController(RecetteDao recetteDao, IngredientDao ingredientDao, CommentaireDao commentaireDao) {
        this.recetteDao = recetteDao;
        this.ingredientDao = ingredientDao;
        this.commentaireDao = commentaireDao;
    }

    @GetMapping("/recette")
    public String afficherRecette(@RequestParam("id") Long id, Model model) {
        Recette recette = recetteDao.findById(id).orElse(null);
        if (recette == null) return "redirect:/"; // sécurité

        model.addAttribute("recette", recette);
        model.addAttribute("ingredients", ingredientDao.findByRecetteId(id));
        model.addAttribute("commentaires", commentaireDao.findByRecetteId(id));
        model.addAttribute("erreur", null);

        return "recette";
    }

    @PostMapping("/recette")
    public String ajouterCommentaire(
        @RequestParam("id") Long id,
        @RequestParam("auteur") String auteur,
        @RequestParam("contenu") String contenu,
        @RequestParam("note") int note,
        Model model
    ) {
        Recette recette = recetteDao.findById(id).orElse(null);
        List<Ingredient> ingredients = ingredientDao.findByRecetteId(id);
        List<Commentaire> commentaires = commentaireDao.findByRecetteId(id);

        if (auteur == null || auteur.trim().isEmpty() || contenu == null || contenu.trim().isEmpty()) {
            model.addAttribute("recette", recette);
            model.addAttribute("ingredients", ingredients);
            model.addAttribute("commentaires", commentaires);
            model.addAttribute("erreur", "Auteur et contenu obligatoires");
            return "recette";
        }

        Commentaire commentaire = new Commentaire(auteur, contenu, note, new Date(), recette);
        commentaireDao.save(commentaire);

        return "redirect:/recette?id=" + id;
    }
}