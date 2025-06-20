package com.ipi.blogrecette.pojos;

import jakarta.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private int quantite;
    private String unit;

    @ManyToOne
    private Recette recette;

    public Ingredient(Long id, String nom, int quantite, String unit, Recette recette) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.unit = unit;
        this.recette = recette;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }

    public Recette getRecette() { return recette; }
    public void setRecette(Recette recette) { this.recette = recette; }
}