/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.social.Login;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.Utilisateur;
import gui.terrain.ListeTerrains;

/**
 *
 * @author sahar
 */
public class HomeForm extends Form {
    public Utilisateur utilisateur=new Utilisateur();
    Form current;
    public HomeForm(Resources res ){
      current = this;
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
        
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {new ListeTerrains(current, utilisateur).show();}); 
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

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
          setTitle(" Welcome, "+utilisateur.getNom()); 
        setLayout(BoxLayout.y());
    }
    
}
