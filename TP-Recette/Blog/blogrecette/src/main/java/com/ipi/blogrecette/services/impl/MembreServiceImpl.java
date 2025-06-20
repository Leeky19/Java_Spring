package com.ipi.blogrecette.services.impl;

import com.ipi.blogrecette.services.MembreService;
import com.ipi.blogrecette.dao.MembreDao;
import com.ipi.blogrecette.dao.RecetteDao;
import com.ipi.blogrecette.pojos.Membre;
import com.ipi.blogrecette.pojos.Recette;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreServiceImpl implements MembreService {

    @Autowired
    private MembreDao membreDao;

    @Autowired
    private RecetteDao recetteDao;

    @Override
    public Membre ajouterMembre(Membre membre) {
        return membreDao.save(membre);
    }

    @Override
    public Membre recupererMembre(Long idMembre) {
        return membreDao.findById(idMembre).orElse(null);
    }

    @Override
    public List<Membre> recupererMembres() {
        return membreDao.findAll();
    }

    @Override
    public List<Recette> recupererRecettes(Membre membre) {
        return recetteDao.findByMembre(membre);
    }
}