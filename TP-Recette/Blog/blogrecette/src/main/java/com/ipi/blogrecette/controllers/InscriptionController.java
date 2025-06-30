package com.ipi.blogrecette.controllers;

import com.ipi.blogrecette.pojos.Membre;
import com.ipi.blogrecette.dao.MembreDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class InscriptionController {

    private final MembreDao membreDao;

    public InscriptionController(MembreDao membreDao) {
        this.membreDao = membreDao;
    }

    @GetMapping("/inscription")
    public String afficherFormulaireInscription(Model model) {
        model.addAttribute("membre", new Membre());
        return "inscription";
    }

    @PostMapping("/inscription")
    public String enregistrerMembre(@ModelAttribute Membre membre) {
        membre.setDateInscription(new Date());
        membreDao.save(membre);
        return "redirect:/"; // Redirection vers l’accueil après inscription
    }
}