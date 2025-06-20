package com.ipi.blogrecette.pojos;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String auteur;
    private String contenu;
    private int note;
    private Date dateCreation;

    @ManyToOne
    private Recette recette;

    public Commentaire(Long id, String auteur, String contenu, int note, Date dateCreation, Recette recette) {
        this.id = id;
        this.auteur = auteur;
        this.contenu = contenu;
        this.note = note;
        this.dateCreation = dateCreation;
        this.recette = recette;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public int getNote() { return note; }
    public void setNote(int note) { this.note = note; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Recette getRecette() { return recette; }
    public void setRecette(Recette recette) { this.recette = recette; }
}