package com.ipi.blogrecette.dao;

import com.ipi.blogrecette.pojos.Ingredient;
import com.ipi.blogrecette.pojos.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {
    List<Ingredient> findByRecette(Recette recette);
}