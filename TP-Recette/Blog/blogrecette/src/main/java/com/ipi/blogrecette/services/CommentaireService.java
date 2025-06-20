package com.ipi.blogrecette.services;

import com.ipi.blogrecette.pojos.Commentaire;

import java.util.List;

public interface CommentaireService {

    Commentaire ajouterCommentaire(Commentaire commentaire);

    Commentaire recupererCommentaire(Long idCommentaire);

    List<Commentaire> recupererCommentaires();
}