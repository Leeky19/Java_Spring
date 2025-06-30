package com.ipi.blogrecette.pojos;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String description;
    private String author;
    private String photo;
    private Date dateCreation;

    @ManyToOne
    private Membre membre;

    @ManyToOne
    private Categorie categorie;

    @OneToMany(mappedBy = "recette")
    private List<Ingredient> ingredients;

    @OneToMany(mappedBy = "recette")
    private List<Commentaire> commentaires;

    public Recette() {
    }

    public Recette(Long id, String titre, String description, String author, String photo, Date dateCreation,
                   Membre membre, Categorie categorie, List<Ingredient> ingredients, List<Commentaire> commentaires) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.author = author;
        this.photo = photo;
        this.dateCreation = dateCreation;
        this.membre = membre;
        this.categorie = categorie;
        this.ingredients = ingredients;
        this.commentaires = commentaires;
    }
public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPhoto() { return photo; }
    public void setPhoto(String photo) { this.photo = photo; }

    public Date getDateCreation() { return dateCreation; }
    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public Membre getMembre() { return membre; }
    public void setMembre(Membre membre) { this.membre = membre; }

    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }

    public List<Ingredient> getIngredients() { return ingredients; }
    public void setIngredients(List<Ingredient> ingredients) { this.ingredients = ingredients; }

    public List<Commentaire> getCommentaires() { return commentaires; }
    public void setCommentaires(List<Commentaire> commentaires) { this.commentaires = commentaires; }
}