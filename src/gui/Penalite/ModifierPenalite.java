/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Penalite;

import com.codename1.ui.Form;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import entities.Categorie;
import entities.Penalite;
import entities.Terrain;
import entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import services.ServiceCategorie;
import services.ServicePenalite;
import services.ServiceTerrain;

/**
 *
 * @author bezin
 */
public class ModifierPenalite extends Form {
//     private Resources theme;
//    Image imag ;
    int index =1;
    public ModifierPenalite(Penalite p){
        //Form previous , Penalite p
                
        setTitle("Modifier Penalite");   
        setLayout(BoxLayout.y());
   //TextField tfID = new TextField("", "id");
    TextField tfDesignation = new TextField("", "designation");
        TextField tfNbrePointsRetires = new TextField("", "nbrePointsRetires");
         //TextField tfComplexe = new TextField("", "Complexe");
       
 
        Button btnEnregistrer = new Button("Enregistrer");
         btnEnregistrer.addActionListener((e)->{
     //Penalite p = new Penalite ( tfDesignation.getText(), Integer.parseInt(tfNbrePointsRetires.getText())) ;  Integer.parseInt(tfNbrePointsRetires.getText())                
                  Penalite pr = new Penalite ( p.getId(), tfDesignation.getText(),Integer.parseInt(tfNbrePointsRetires.getText()) );
                 
           // Integer.parseInt(tfID.getText())p.getId()Integer.parseInt(tfID.getText()
                      System.out.println(pr);
                    
                      if( ServicePenalite.getInstance().updatePenalite(pr))
                            Dialog.show("Success","Penalite Modifier avec succes",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                
            
        });
       
   
             addAll(tfDesignation, tfNbrePointsRetires, btnEnregistrer );
        
         

            
    
    
}
}