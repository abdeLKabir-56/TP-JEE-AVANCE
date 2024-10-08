package com.abdel;

public class Livre {
    private String titre;
    private String auteur;

    public Livre() {
    }
    public Livre(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
