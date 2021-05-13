/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import entities.Utilisateur;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class Inscription extends Form{
    Form current;
    public Inscription(Form previous){
        
         setTitle("Inscrivez-vous");   
         
          
         add(new Label("Email"));
         TextField email=new TextField("","Votre email");
          add(email);
          
         add(new Label("Mot de passe"));
         TextField mdp=new TextField("","Votre mot de passe");
          add(mdp);
          
         add(new Label("Confirmer mot de passe"));
         TextField mdp1=new TextField("","Confirmer votre mot de passe");
          add(mdp1);
          
          add(new Label("Nom"));
         TextField nom=new TextField("","Votre nom");
          add(nom);
         
         add(new Label("Prenom"));
         TextField prenom=new TextField("","Votre prénom");
          add(prenom);
         
       add(new Label("Telephone"));
         TextField telephone=new TextField("","Votre telephone");
          add(telephone);
         
        add(new Label("Position"));
         TextField position=new TextField("","Votre position");
          add(position);
         

         Button ajouter=new Button("Ajouter");
         Button annuler=new Button("Annuler");
         addAll(ajouter,annuler);
         
         ajouter.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
         if((nom.getText().length()==0)||(prenom.getText().length()==0)||(email.getText().length()==0)||(mdp.getText().length()==0)||(telephone.getText().length()==0)||(position.getText().length()==0)){
           
             Dialog.show("Alert", "please fill all the fields", new Command("ok"));

         } else{
             try{  
                   Argon2 argon2;
                 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        String hash = argon2.hash(4, 1024 * 1024, 8, mdp.getText());

        
                      Utilisateur e=new Utilisateur(email.getText(),hash,nom.getText(),prenom.getText(),position.getText(),telephone.getText());
                      e.setRoles("[\"ROLE_USER\"]");
                      if (new ServiceUsers().addUsers(e)){
                            Dialog.show("Success","User Added", new Command("OK"));
                      }else{
                            Dialog.show("ERROR","Server Error", new Command("OK"));
                      }
                      
                  }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
         }

             }
             
         });
           getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());

    }
}
