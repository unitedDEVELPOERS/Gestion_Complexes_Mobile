package entities;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sahar
 */
public class Equipe {
    public int id,nbre_joueur;
    public String nom,logo;
    public Utilisateur capitain;
    public Equipe(){
        
    }
    public Equipe(int id ,String nom,int nbre_joueur ,String logo,Utilisateur capitain){
        this.id=id;
        this.nom=nom;
        this.nbre_joueur=nbre_joueur;
        this.logo=logo;
        this.capitain=capitain;
    }
 public Equipe(String nom,int nbre_joueur ,String logo,Utilisateur capitain){
        
        this.nom=nom;
        this.nbre_joueur=nbre_joueur;
        this.logo=logo;
        this.capitain=capitain;
    }
 public Equipe(String nom,int nbre_joueur ){
        
        this.nom=nom;
        this.nbre_joueur=nbre_joueur;
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbre_joueur() {
        return nbre_joueur;
    }

    public void setNbre_joueur(int nbre_joueur) {
        this.nbre_joueur = nbre_joueur;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Equipe{" + "nbre_joueur=" + nbre_joueur + ", nom=" + nom + '}';
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Utilisateur getCapitain() {
        return capitain;
    }

    public void setCapitain(Utilisateur capitain) {
        this.capitain = capitain;
    }
 
           
    
}
