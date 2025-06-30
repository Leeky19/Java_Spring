package com.ipi.blogrecette.pojos;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @OneToMany(mappedBy = "categorie")
    private List<Recette> recettes;

    public Categorie() {

    }

    public Categorie(Long id, String nom, List<Recette> recettes) {
        this.id = id;
        this.nom = nom;
        this.recettes = recettes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public List<Recette> getRecettes() { return recettes; }
    public void setRecettes(List<Recette> recettes) { this.recettes = recettes; }
}