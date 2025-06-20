package com.ipi.blogrecette.services.impl;

import com.ipi.blogrecette.services.RecetteService;
import com.ipi.blogrecette.dao.RecetteDao;
import com.ipi.blogrecette.dao.IngredientDao;
import com.ipi.blogrecette.dao.CommentaireDao;
import com.ipi.blogrecette.pojos.Recette;
import com.ipi.blogrecette.pojos.Ingredient;
import com.ipi.blogrecette.pojos.Commentaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteServiceImpl implements RecetteService {

    @Autowired
    private RecetteDao recetteDao;

    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private CommentaireDao commentaireDao;

    @Override
    public Recette ajouterRecette(Recette recette) {
        return recetteDao.save(recette);
    }

    @Override
    public Recette recupererRecette(Long idRecette) {
        return recetteDao.findById(idRecette).orElse(null);
    }

    @Override
    public List<Recette> recupererRecettes() {
        return recetteDao.findAll();
    }

    @Override
    public List<Ingredient> recupererIngredients(Recette recette) {
        return ingredientDao.findByRecette(recette);
    }

    @Override
    public List<Commentaire> recupererCommentaires(Recette recette) {
        return commentaireDao.findByRecette(recette);
    }
}