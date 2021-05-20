/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author bezin
 */
public class PenaliteJoueur {
    private int id ;
    private Date heure ;
    private Utilisateur arbitre ;
    private Utilisateur joueur ;
    private Matche matche;
    private Penalite penalite ;

    public PenaliteJoueur() {
    }

    public PenaliteJoueur(int id, Date heure, Utilisateur arbitre, Utilisateur joueur, Matche matche, Penalite penalite) {
        this.id = id;
        this.heure = heure;
        this.arbitre = arbitre;
        this.joueur = joueur;
        this.matche = matche;
        this.penalite = penalite;
    }

    public PenaliteJoueur(Date heure, Utilisateur joueur, Penalite penalite) {
        this.heure = heure;
        this.joueur = joueur;
        this.penalite = penalite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHeure() {
        return heure;
    }

    public void setHeure(Date heure) {
        this.heure = heure;
    }

    public Utilisateur getArbitre() {
        return arbitre;
    }

    public void setArbitre(Utilisateur arbitre) {
        this.arbitre = arbitre;
    }

    public Utilisateur getJoueur() {
        return joueur;
    }

    public void setJoueur(Utilisateur joueur) {
        this.joueur = joueur;
    }

    public Matche getMatche() {
        return matche;
    }

    public void setMatche(Matche matche) {
        this.matche = matche;
    }

    public Penalite getPenalite() {
        return penalite;
    }

    public void setPenalite(Penalite penalite) {
        this.penalite = penalite;
    }
    
    
    
    
    
   
    
}
