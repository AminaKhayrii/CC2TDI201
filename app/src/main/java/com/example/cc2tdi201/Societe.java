package com.example.cc2tdi201;

import java.io.Serializable;

public class Societe implements Serializable {
    private  int id;
    private String nom;
    private String secteur;
    private int nbEmploye;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public int getNbEmploye() {
        return nbEmploye;
    }

    public void setNbEmploye(int nbEmploye) {
        this.nbEmploye = nbEmploye;
    }

    public Societe(){}

    public Societe(int id, String nom, String secteur, int nbEmploye) {
        this.id = id;
        this.nom = nom;
        this.secteur = secteur;
        this.nbEmploye = nbEmploye;
    }
}
