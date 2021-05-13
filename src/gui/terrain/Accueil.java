/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import entities.Utilisateur;
import gui.Equipe.AddEquipeForm;
import gui.reservation.ListeReservations;
import gui.reservation.Reserver;

/**
 *
 * @author ahmed
 */
public class Accueil extends Form {
    
    Form current;
    public Utilisateur utilisateur=new Utilisateur();
    public Accueil(){
       current=this;
       setTitle("Accueil");
       setLayout(BoxLayout.y());
       Button btnNouveauTerrain = new Button("Nouveau terrain");
        Button btnListeTerrains = new Button("Liste des terrains");
        //Button btnNouveauTerrain = new Button("Nouveau terrain");
        Button btnReserver = new Button("Nouvelle réservation");
        Button btnListeReservations = new Button("Liste des réservations");
        Button btnAddEquipe = new Button("Ajouter equipe");
        
        btnNouveauTerrain.addActionListener(e->new AjouterTerrain(current, utilisateur).show()
        
                     );
        btnReserver.addActionListener(e->new Reserver(current).show());
      
        btnListeTerrains.addActionListener(e->new ListeTerrains(current, utilisateur).show());
        btnListeReservations.addActionListener(e->new ListeReservations(current).show());
        //btnAddEquipe.addActionListener(e->new AddEquipeForm(current).show());
        addAll(btnNouveauTerrain, btnListeTerrains, btnReserver, btnListeReservations, btnAddEquipe);  
        
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