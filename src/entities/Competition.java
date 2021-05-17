/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author user
 */
public class Competition {
    public int id;
    

    public String designation;
    private String date_creation;    //pour change
    private String date_debut;
    private String nbre_equipes;
    private Categorie categorie;
    
    private String categ;
    private String complexe;
    private String prix_participation;
    
    
    public Competition() {
    }

    public Competition(String designation) {
        this.designation = designation;
    }

    public Competition(String designation, String date_debut, String nbre_equipes, Categorie categorie, String prix_participation) {
        this.designation = designation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.prix_participation = prix_participation;
    }
    
    

    public Competition(int id, String designation, String date_creation, String date_debut, String nbre_equipes, Categorie categorie, String complexe, String prix_participation) {
        this.id = id;
        this.designation = designation;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.categorie = categorie;
        this.complexe = complexe;
        this.prix_participation = prix_participation;
    }

    public Competition(String designation, String date_debut, String nbre_equipes, String prix_participation) {
        this.designation = designation;
        this.date_debut = date_debut;
        this.nbre_equipes = nbre_equipes;
        this.prix_participation = prix_participation;
    }

    public String getCateg() {
        return categ;
    }

    public void setCateg(String categ) {
        this.categ = categ;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getNbre_equipes() {
        return nbre_equipes;
    }

    public void setNbre_equipes(String nbre_equipes) {
        this.nbre_equipes = nbre_equipes;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String getComplexe() {
        return complexe;
    }

    public void setComplexe(String complexe) {
        this.complexe = complexe;
    }

    public String getPrix_participation() {
        return prix_participation;
    }

    public void setPrix_participation(String prix_participation) {
        this.prix_participation = prix_participation;
    }
    
}
