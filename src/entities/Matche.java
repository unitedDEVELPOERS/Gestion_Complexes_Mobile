/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author fachr
 */
public class Matche {
    
    public int id;
   public Date date_creation, date_match;
     public Equipe equipe1,equipe2;
     public int resulat_eq1,resulat_eq2,valide;
     public Terrain terrain ;
     public Utilisateur arbitre;
     public Niveau_competition niveau_competition;
     
     public Matche(){
         
     }
     public Matche(int id ,Date date_creation,Date date_match,Equipe equipe1,Equipe equipe2, int resultat_eq1,int resultat_eq2, int valide,Terrain terrain,Utilisateur arbitre,Niveau_competition niveau_competition ){
         this.id=id;
         this.date_creation=date_creation;
         this.date_match=date_match;
         this.equipe1=equipe1;
         this.equipe2=equipe2;
         this.resulat_eq1=resultat_eq1;
         this.resulat_eq2=resultat_eq2;
         this.valide=valide;
         this.terrain=terrain;
         this.arbitre=arbitre;
         this.niveau_competition=niveau_competition;
         
         
     }
      public Matche(Date date_creation,Date date_match,Equipe equipe1,Equipe equipe2, int resultat_eq1,int resultat_eq2, int valide,Terrain terrain,Utilisateur arbitre,Niveau_competition niveau_competition ){
      
         this.date_creation=date_creation;
         this.date_match=date_match;
         this.equipe1=equipe1;
         this.equipe2=equipe2;
         this.resulat_eq1=resultat_eq1;
         this.resulat_eq2=resultat_eq2;
         this.valide=valide;
         this.terrain=terrain;
         this.arbitre=arbitre;
         this.niveau_competition=niveau_competition;
         
         
     }
       public Matche(int id ,Date date_creation,Date date_match,Equipe equipe1,Equipe equipe2){
         this.id=id;
         this.date_creation=date_creation;
         this.date_match=date_match;
         this.equipe1=equipe1;
         this.equipe2=equipe2;
        
         
         
     }
        public Matche(Date date_creation,Date date_match,Equipe equipe1,Equipe equipe2){
         this.id=id;
         this.date_creation=date_creation;
         this.date_match=date_match;
         this.equipe1=equipe1;
         this.equipe2=equipe2;
        
         
         
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public Date getDate_match() {
        return date_match;
    }

    public void setDate_match(Date date_match) {
        this.date_match = date_match;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

   
    public Equipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(Equipe equipe1) {
        this.equipe1 = equipe1;
    }

    public Equipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(Equipe equipe2) {
        this.equipe2 = equipe2;
    }

    public int getResulat_eq1() {
        return resulat_eq1;
    }

    public void setResulat_eq1(int resulat_eq1) {
        this.resulat_eq1 = resulat_eq1;
    }

    public int getResulat_eq2() {
        return resulat_eq2;
    }

    public void setResulat_eq2(int resulat_eq2) {
        this.resulat_eq2 = resulat_eq2;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public Utilisateur getArbitre() {
        return arbitre;
    }

    public void setArbitre(Utilisateur arbitre) {
        this.arbitre = arbitre;
    }

    public Niveau_competition getNiveau_competition() {
        return niveau_competition;
    }

    public void setNiveau_competition(Niveau_competition niveau_competition) {
        this.niveau_competition = niveau_competition;
    }
        
}
