package com.ipi.blogrecette.controllers;

import com.ipi.blogrecette.pojos.Recette;
import com.ipi.blogrecette.services.RecetteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AccueilController {

    private final RecetteService recetteService;

    public AccueilController(RecetteService recetteService) {
        this.recetteService = recetteService;
    }

    @GetMapping("/")
    public String accueil(Model model) {
        List<Recette> recettes = recetteService.recupererRecettes();
        model.addAttribute("recettes", recettes);
        return "accueil";
    }
}