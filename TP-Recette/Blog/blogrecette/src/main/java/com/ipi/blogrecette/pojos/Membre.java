package com.ipi.blogrecette.pojos;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String pseudo;
    private String mdp;
    private String email;
    private Date dateInscription;

    @OneToMany(mappedBy = "membre")
    private List<Recette> recettes;

    public Membre(Long id, String nom, String pseudo, String mdp, String email, Date dateInscription, List<Recette> recettes) {
        this.id = id;
        this.nom = nom;
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.email = email;
        this.dateInscription = dateInscription;
        this.recettes = recettes;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPseudo() { return pseudo; }
    public void setPseudo(String pseudo) { this.pseudo = pseudo; }

    public String getMdp() { return mdp; }
    public void setMdp(String mdp) { this.mdp = mdp; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Date getDateInscription() { return dateInscription; }
    public void setDateInscription(Date dateInscription) { this.dateInscription = dateInscription; }

    public List<Recette> getRecettes() { return recettes; }
    public void setRecettes(List<Recette> recettes) { this.recettes = recettes; }
}