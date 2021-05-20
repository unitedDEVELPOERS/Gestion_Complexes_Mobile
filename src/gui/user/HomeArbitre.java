/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import entities.Penalite;
import entities.Utilisateur;
import gui.Penalite.AjouterPenalite;
import gui.Penalite.ListePenalite;
import gui.Penalite.ModifierPenalite;
/**
 *
 * @author sahar
 */
public class HomeArbitre extends Form{
     public Utilisateur utilisateur=new Utilisateur();
    
    public HomeArbitre(Resources res ){
      
      Toolbar tb =new Toolbar(true);
        setToolbar(tb);
        setTitle("Acceuil");
      
      
        Image icon = res.getImage("arbitre.png");
      Container topBar = BorderLayout.centerCenter(new Label(icon));
Label l= new Label("Bonjour mr l'arbitre");
      
      topBar.add(BorderLayout.SOUTH,l);
      tb.addComponentToSideMenu(topBar);
        
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {}); 
        tb.addMaterialCommandToSideMenu("ListePénalités", FontImage.MATERIAL_HOW_TO_VOTE, e -> {new ListePenalite().show();});//new ListePenalite().show(); new ListePenalite().show();
         tb.addMaterialCommandToSideMenu("Ajouter Penalite", FontImage.MATERIAL_HOW_TO_VOTE, e -> {new AjouterPenalite().show();});//new AjouterPenalite().show();
       
        tb.addMaterialCommandToSideMenu("Planning", FontImage.MATERIAL_CALENDAR_TODAY, e -> {});
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

    public void set(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
