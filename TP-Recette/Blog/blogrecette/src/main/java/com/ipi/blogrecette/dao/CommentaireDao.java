package com.ipi.blogrecette.dao;

import com.ipi.blogrecette.pojos.Commentaire;
import com.ipi.blogrecette.pojos.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentaireDao extends JpaRepository<Commentaire, Long> {
    List<Commentaire> findByRecette(Recette recette);
}