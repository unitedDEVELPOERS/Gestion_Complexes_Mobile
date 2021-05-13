/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author fachr
 */
public class Invitation {
    public int id,valide;
     public String type;
     public Equipe equipe;
     public Utilisateur utilisateur;
     public Invitation(){
         
     }
     public Invitation(int id,String type,Equipe equipe,Utilisateur utilisateur ,int valide){
         this.id=id;
         this.type=type;
         this.equipe=equipe;
         this.utilisateur=utilisateur;
         this.valide=valide;
     }
       public Invitation(String type,Equipe equipe,Utilisateur utilisateur ,int valide){
       
         this.type=type;
         this.equipe=equipe;
         this.utilisateur=utilisateur;
         this.valide=valide;
     }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
     
    
}
