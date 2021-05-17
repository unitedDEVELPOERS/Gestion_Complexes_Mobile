/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.util.Resources;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import entities.Utilisateur;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class ModifierInfo extends Form {
    Utilisateur utilisateur=new Utilisateur();
    
    public ModifierInfo(Resources res){
         

        Toolbar tb =new Toolbar(true);
        setToolbar(tb);
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
        setTitle("Acceuil");
        Image icon = res.getImage("joueur.png");
      Container topBar = BorderLayout.centerCenter(new Label(icon));
       Label l= new Label("Bonjour mr le joueur");
      
      topBar.add(BorderLayout.SOUTH,l);
      tb.addComponentToSideMenu(topBar);
        
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {}); 
        tb.addMaterialCommandToSideMenu("Equipe", FontImage.MATERIAL_GROUP, e -> {});
        tb.addMaterialCommandToSideMenu("Réservations", FontImage.MATERIAL_BOOKMARK_OUTLINE, e -> {});
        tb.addMaterialCommandToSideMenu("Competition", FontImage.MATERIAL_EMOJI_EVENTS, e -> {});
        tb.addMaterialCommandToSideMenu("Store", FontImage.MATERIAL_ADD_SHOPPING_CART, e -> {});
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_ACCOUNT_CIRCLE, e -> {CompteClient h=  new CompteClient(res);
                       h.setUtilisateur(getUtilisateur(),res);
                        h.show();});

        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOGOUT, e -> {
            Authentification h=  new Authentification(res);
             
            
            
            h.show();});

        
        
       
        
    }
    
    
    public void mod(Utilisateur user,Resources res){
       
       GridBagLayout gb = new GridBagLayout();

      GridBagConstraints gbc = new GridBagConstraints();
    
        TextField email =new TextField(user.getEmail(),user.getEmail(),20,TextField.EMAILADDR);
     
        //add(new  FloatingHint(nom));
        add(email);
        
     
        
    
        
     TextField nom =new TextField(user.getNom(),user.getNom());
     
        //add(new  FloatingHint(nom));
        add(nom);
     
    
     
     
   
     TextField prenom =new TextField(user.getPrenom(),user.getPrenom());
     
        //add(new  FloatingHint(nom));
        add(prenom);
        
        
          TextField tel =new TextField(user.getTel(),user.getTel(),20,TextField.PHONENUMBER);
     
        //add(new  FloatingHint(nom));
        add(tel);
        
         
        
        
         TextField position =new TextField(user.getPosition(),user.getPosition());
    
        //add(new  FloatingHint(nom));
        add(position);
        
         Button b3=new Button("Modifier");
        add(b3);
        
        Button b4=new Button("Retour");
        add(b4);
        
        b3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent evt) {
         
               
           
           
             try{  
                 

        
                      Utilisateur e=new Utilisateur(email.getText(),nom.getText(),prenom.getText(),position.getText(),tel.getText());
                     
                      if (new ServiceUsers().UpdateUser(e)){
                            Dialog.show("Success","User Modified", new Command("OK"));
                      }else{
                            Dialog.show("ERROR","Server Error", new Command("OK"));
                      }
                      
                  }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
         }

             
             
         });
                b4.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                
              CompteClient h=  new CompteClient(res);
                       h.setUtilisateur(getUtilisateur(),res);
                        h.show();



             }
            
        });
        
    }
    
    
    

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur,Resources res) {
        this.utilisateur = utilisateur;
        mod(utilisateur,res);
    }

    
}
