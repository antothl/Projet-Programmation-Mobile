package com.example.projet.model;

/*classe pour représenter les joueurs*/
public class listejoueurs {

    private String nomJoueur;
    private String photoJoueur;
    private String prenomJoueur;
    private int numeroJoueur;

    public listejoueurs(String nomJoueur, String photoJoueur, int numeroJoueur,String prenomJoueur) {
        this.nomJoueur= nomJoueur;
        this.photoJoueur= photoJoueur;
        this.numeroJoueur= numeroJoueur;
        this.prenomJoueur=prenomJoueur;
    }

    public int getNumeroJoueur() {
        return numeroJoueur;
    }

    public void setNumeroJoueur(int numeroJoueur) {
        this.numeroJoueur = numeroJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    public String getPhotoJoueur() {
        return photoJoueur;
    }

    public void setPhotoJoueur(String photoJoueur) {
        this.photoJoueur = photoJoueur;
    }
    public String getPrenomJoueur(){
        return prenomJoueur;
    }

    @Override
    public String toString()  {
        return this.nomJoueur+" (Numero: "+ this.numeroJoueur+")";
    }
}