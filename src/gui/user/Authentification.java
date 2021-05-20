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
import com.codename1.ui.util.Resources;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import com.codename1.ui.Image;
import entities.Utilisateur;
import gui.categorie.GestionCategorie;
import gui.terrain.Accueil;
import java.util.ArrayList;
import javafx.scene.layout.BackgroundImage;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class Authentification extends Form {
    
   Form current;
   
   public Authentification(Resources res){
       current=this;
      
       setLayout(BoxLayout.y());
        
       current.setUIID("WithBackground");
     current.getUnselectedStyle().setBgImage(res.getImage("background.jpg"));

       
      add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
        
       
       
       
       
       
       add(new Label("Email"));
         TextField email=new TextField("","Votre email",20, TextField.EMAILADDR);
         email.setSingleLineTextArea(false);
          add(email);
          
         add(new Label("Mot de passe"));
         TextField mdp=new TextField("","Votre mot de passe",20,TextField.PASSWORD);
          add(mdp);
        Button login=new Button("Login");
        Button inscrit=new Button("Inscrivez-vous");
         Button mdpO=new Button("Mot de passe oublié?");
        addAll(login,inscrit);
        add(mdpO);
        
         mdpO.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                 
                 MotDePasse u=new MotDePasse(res);
                 u.show();
                 
             }
         });
        
              login.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
         if((email.getText().length()==0)||(mdp.getText().length()==0)){
           
             Dialog.show("Alert", "please fill all the fields", new Command("ok"));

         } else{
             try{
                    ServiceUsers s=new ServiceUsers();
                      if (s.Login(email.getText(),mdp.getText())){
                      
                      if( "[ROLE_USER]".equals(s.getUtilisateur().getRoles())){
                       HomeForm h=  new HomeForm(res);
                       h.setUtilisateur(s.getUtilisateur());
                        h.show();
                      }else
                      if( "[ROLE_PROP]".equals(s.getUtilisateur().getRoles())){
                       HomeProp h=  new HomeProp(res);
                       //Accueil h = new Accueil(s.getUtilisateur());
                       h.setUtilisateur(s.getUtilisateur());
                        h.show();
                      } else
                      if( "[ROLE_ARBITRE]".equals(s.getUtilisateur().getRoles())){
                       HomeArbitre h=  new HomeArbitre(res);
                       h.setUtilisateur(s.getUtilisateur());
                        h.show();
                      }
                      else
                      if( "[ROLE_ADMIN]".equals(s.getUtilisateur().getRoles())){
                       HomeAdmin h=  new HomeAdmin(res);
                       h.setUtilisateur(s.getUtilisateur());
                        h.show();
                      }
                      
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
    
        inscrit.addActionListener(e->new Inscription(current,res).show());

   }
    
    
    
}
