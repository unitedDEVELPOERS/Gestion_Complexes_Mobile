/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import entities.Utilisateur;
import gui.Equipe.AddEquipeForm;
import gui.reservation.ListeReservations;
import gui.reservation.Reserver;
import com.codename1.ui.Container;

/**
 *
 * @author ahmed
 */
public class Accueil extends Form {
    Resources theme;
    Form current;
    public Utilisateur utilisateur=new Utilisateur();
    public Accueil(Utilisateur user){
       current=this;
       theme = UIManager.initFirstTheme("/theme");
       setTitle("Accueil");
       setLayout(BoxLayout.yCenter());
       
      
       
       Label lbcomp = new Label(theme.getImage("comp.png"));
       Container cnt0 = new Container(BoxLayout.xCenter());
       cnt0.addAll(lbcomp);
       
       Label lbt = new Label(theme.getImage("terrain.png"));
       Label lbtrs = new Label(theme.getImage("trs.png"));
       Container cnt1 = new Container(BoxLayout.xCenter());
       cnt1.addAll(lbt,lbtrs);
       
       
       Label lbeq = new Label(theme.getImage("eq.png"));      
       Label lbcompetition = new Label(theme.getImage("competition.png"));
       Container cnt2 = new Container(BoxLayout.xCenter());
       cnt2.addAll(lbeq, lbcompetition);
       
       
       
       
       
        Button btnNouveauTerrain = new Button("Nouveau terrain");
       btnNouveauTerrain.setIcon(theme.getImage("terrain.png"));
       Label lbres = new Label(theme.getImage("res.png"));
       Container cnt3 = new Container(BoxLayout.xCenter());
       cnt3.addAll(lbres);
       
       
       Button btnListeTerrains = new Button("Liste des terrains");
       
       addAll(cnt0,cnt1,cnt2, cnt3);  
       
       
       lbt.addPointerReleasedListener(e->new AjouterTerrain(current, utilisateur).show());
       lbtrs.addPointerReleasedListener(e->new ListeTerrains(current, utilisateur).show());
       
       
       
       
       
       
       
       
       
       

        //Button btnNouveauTerrain = new Button("Nouveau terrain");
        Button btnReserver = new Button("Nouvelle réservation");
        Button btnListeReservations = new Button("Liste des réservations");
        Button btnAddEquipe = new Button("Ajouter equipe");
       // lbt.addActionListener(e->new AjouterTerrain(current, utilisateur).show());
        // btnNouveauTerrain.addActionListener(e->new AjouterTerrain(current, utilisateur).show()
        
               //      );
        btnReserver.addActionListener(e->new Reserver(current).show());
      
       // btnListeTerrains.addActionListener(e->new ListeTerrains(current, utilisateur).show());
        btnListeReservations.addActionListener(e->new ListeReservations(current).show());
        //btnAddEquipe.addActionListener(e->new AddEquipeForm(current).show());
        //addAll(cnt1,btnNouveauTerrain, btnListeTerrains, btnReserver, btnListeReservations, btnAddEquipe);  
        
        
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