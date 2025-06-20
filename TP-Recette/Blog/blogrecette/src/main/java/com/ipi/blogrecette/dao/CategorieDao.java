package com.ipi.blogrecette.dao;

import com.ipi.blogrecette.pojos.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<Categorie, Long> {
}