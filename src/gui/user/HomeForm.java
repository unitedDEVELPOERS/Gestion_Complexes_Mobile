/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import entities.Utilisateur;

/**
 *
 * @author fachr
 */
public class HomeForm extends Form {
    public Utilisateur utilisateur=new Utilisateur();
    public HomeForm(){
      
        
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
          setTitle(" Welcome, "+utilisateur.getNom()); 
        setLayout(BoxLayout.y());
    }
    
}
