package com.ipi.blogrecette.dao;

import com.ipi.blogrecette.pojos.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembreDao extends JpaRepository<Membre, Long> {
    // Méthode par dérivation
    Membre findByPseudo(String pseudo);
}