package com.ipi.blogrecette.controllers;

import com.ipi.blogrecette.pojos.Categorie;
import com.ipi.blogrecette.pojos.Recette;
import com.ipi.blogrecette.dao.CategorieDao;
import com.ipi.blogrecette.dao.RecetteDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategorieController {

    private final CategorieDao categorieDao;
    private final RecetteDao recetteDao;

    public CategorieController(CategorieDao categorieDao, RecetteDao recetteDao) {
        this.categorieDao = categorieDao;
        this.recetteDao = recetteDao;
    }

    @GetMapping("/categorie")
    public String recettesParCategorie(@RequestParam("idCategorie") Long idCategorie, Model model) {
        Categorie categorie = categorieDao.findById(idCategorie).orElse(null);
        List<Recette> recettes = recetteDao.findByCategorieId(idCategorie);

        model.addAttribute("categorie", categorie);
        model.addAttribute("recettes", recettes);
        return "categorie";
    }
}