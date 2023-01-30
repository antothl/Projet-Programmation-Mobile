package com.example.projet.model;

/*classe pour représenter les équipes*/
public class Team {
    private String nom;
    private int image;

    public Team(String nom, int image) {
        this.nom = nom;
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
