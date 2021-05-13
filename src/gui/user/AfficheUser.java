/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import entities.Categorie;
import entities.Utilisateur;
import services.ServiceCategorie;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class AfficheUser extends Form {
     Utilisateur user=new Utilisateur();
    public AfficheUser(){
    setTitle("Gestion Categorie");
         SpanLabel sp = new SpanLabel();
        sp.setText(ServiceUsers.getInstance().AfficheUser(user).toString());
        add(sp);
    
}
}
