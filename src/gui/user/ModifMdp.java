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
public class ModifMdp extends Form{
    Utilisateur user=new Utilisateur();
    
    public ModifMdp(Resources res){
        
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
                       h.setUtilisateur(getUser(),res);
                        h.show();});

        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOGOUT, e -> {
            Authentification h=  new Authentification(res);
             
            
            
            h.show();});

        
       
        
        
        
        
    }
    
    public void ModMdp(Utilisateur user,Resources res){
        
         GridBagLayout gb = new GridBagLayout();

      GridBagConstraints gbc = new GridBagConstraints();
    
        TextField mdp1 =new TextField("","Votre ancien mot de passe",20,TextField.PASSWORD);
     
        //add(new  FloatingHint(nom));
        add(mdp1);
        
     TextField mdp2 =new TextField("","Votre nouveau mot de passe",20,TextField.PASSWORD);
     
        //add(new  FloatingHint(nom));
        add(mdp2);
        
            
     TextField mdp3 =new TextField("","Confirmer votre nouveau mot de passe",20,TextField.PASSWORD);
     
        //add(new  FloatingHint(nom));
        add(mdp3);
        
    Button b1=new Button("Modifier");
    add(b1);
    
    Button b2=new Button("Retour");
    add(b2);
    
    
    
     b1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {

                 if(mdp1.getText() == null ? user.getPwd() == null : mdp1.getText().equals(user.getPwd())){
                     if(mdp2.getText().equals(mdp3.getText())){
                         
                     try{
                        Argon2 argon2;
                 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        
        String hash = argon2.hash(4, 1024 * 1024, 8, mdp2.getText());
        
                     Utilisateur e=new Utilisateur(user.getEmail(),hash);
                     
                      if (new ServiceUsers().UpdateMdp(e)){
                            Dialog.show("Success","User Modified", new Command("OK"));
                      }else{
                            Dialog.show("ERROR","Server Error", new Command("OK"));
                      }
                      
                  }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
         }
                 }
             }
        
});
    
          b2.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                
              CompteClient h=  new CompteClient(res);
                       h.setUtilisateur(getUser(),res);
                        h.show();



             }
            
        });
        
        
    }
    
    

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user,Resources res) {
        this.user = user;
        ModMdp(user,res);
    }
    
    
    
    
    
    
    
    
}
