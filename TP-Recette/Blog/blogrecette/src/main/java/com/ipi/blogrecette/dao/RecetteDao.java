package com.ipi.blogrecette.dao;

import com.ipi.blogrecette.pojos.Recette;
import com.ipi.blogrecette.pojos.Membre;
import com.ipi.blogrecette.pojos.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetteDao extends JpaRepository<Recette, Long> {
    // Par dérivation
    List<Recette> findByMembre(Membre membre);
    List<Recette> findByCategorie(Categorie categorie);
    List<Recette> findByCategorieId(Long idcategorie);
}