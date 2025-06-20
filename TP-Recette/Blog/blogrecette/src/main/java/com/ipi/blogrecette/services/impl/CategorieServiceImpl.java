package com.ipi.blogrecette.services.impl;

import com.ipi.blogrecette.dao.CategorieDao;
import com.ipi.blogrecette.services.CategorieService;
import com.ipi.blogrecette.dao.RecetteDao;
import com.ipi.blogrecette.pojos.Categorie;
import com.ipi.blogrecette.pojos.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieServiceImpl implements CategorieService {

    @Autowired
    private CategorieDao categorieDao;

    @Autowired
    private RecetteDao recetteDao;

    @Override
    public Categorie ajouterCategorie(Categorie categorie) {
        return categorieDao.save(categorie);
    }

    @Override
    public Categorie recupererCategorie(Long idCategorie) {
        return categorieDao.findById(idCategorie).orElse(null);
    }

    @Override
    public List<Categorie> recupererCategories() {
        return categorieDao.findAll();
    }

    @Override
    public List<Recette> recupererRecettes(Categorie categorie) {
        return recetteDao.findByCategorie(categorie);
    }
}