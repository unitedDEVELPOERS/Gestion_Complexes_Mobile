/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import entities.Utilisateur;
import gui.terrain.Accueil;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class Authentification extends Form {
    
    Form current;
    
    public Authentification(){
        current=this;
        setTitle("Authentification");
        setLayout(BoxLayout.y());


        add(new Label("Email"));
        TextField email=new TextField("","Votre email");
        add(email);
        add(new Label("Mot de passe"));
        TextField mdp=new TextField("","Votre mot de passe");
        add(mdp);
        Button login=new Button("Login");
        Button inscrit=new Button("Inscrivez-vous");
        addAll(login,inscrit);
              login.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
         if((email.getText().length()==0)||(mdp.getText().length()==0)){
           
             Dialog.show("Alert", "please fill all the fields", new Command("ok"));

         } else{
             try{
                    ServiceUsers s=new ServiceUsers();
                      if (s.Login(email.getText(),mdp.getText())){
                       
//                       HomeForm h = new HomeForm();
//                       h.setUtilisateur(s.getUtilisateur());
                       Accueil h = new Accueil();
                       h.setUtilisateur(s.getUtilisateur());
                    
                       h.show();
                      }else{
                            Dialog.show("ERROR","Email or MDP Incorrect", new Command("OK"));
                      }
                      
                    }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
         }

             }
             
         });
    
        inscrit.addActionListener(e->new Inscription(current).show());

   }
    
    
    
}
