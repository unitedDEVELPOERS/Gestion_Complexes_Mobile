/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

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
import entities.Terrain;
import entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import services.ServiceCategorie;
import services.ServiceTerrain;

/**
 *
 * @author ahmed
 */
public class ModifierTerrain extends Form{
    private Resources theme;
    Image imag ;
    int index =1;
    public ModifierTerrain(Form previous, Terrain t){
         theme = UIManager.initFirstTheme("/theme");
        setTitle("Nouveau terrain");   
        setLayout(BoxLayout.y());
        
        TextField tfDesignation = new TextField(t.getDesignation(), "Désignation");
        TextField tfDescription = new TextField(t.getDescription(), "Description");
   
        Picker villePicker = new Picker();
        villePicker.setStrings("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa",
            "Jendouba", "Kairouan", "Kasserine", "Kebili", "Kef", "Mahdia", "Manouba",
            "Medenine", "Manastir", "Nabeul" ,"Sfax", "Sidi Bouzid", "Siliana", "Sousse",
            "Tataouine", "Tozeur", "Tunis", "Zaghouan");
        villePicker.setSelectedString(t.getVille());
        //villePicker.setText("Ville");
        TextField tfLocalite = new TextField(t.getAdresse(), "Localité");
        Label im = new Label();
        //Label lbImage = new Label();
        ImageViewer lbImage = new ImageViewer(theme.getImage(t.getImage()));
        Button btnImage = new Button("Selectionner une image");
               
        //Picker p = new Picker();
        TextField tfPrix = new TextField(Double. toString(t.getPrix_location()), "Prix de location");
        Picker categoriePicker = new Picker();
        ArrayList<Categorie> cat = new ArrayList<>();
        ArrayList<String> l = new ArrayList<>();
        if(ServiceCategorie.getInstance().getAllCategorie().size()>0)
        {   
        cat = ServiceCategorie.getInstance().getAllCategorie();
        
        for ( Categorie c : cat)
            l.add(c.getDesignation());
        }
        categoriePicker.setStrings("Football", "Handball", "Basket-ball"); 
        categoriePicker.setSelectedString(t.getCategorie().getDesignation());
       
    

     
        
        categoriePicker.addActionListener((eee)->{
             index+=categoriePicker.getSelectedStringIndex();
             System.out.println(ServiceCategorie.getInstance().AfficheCat(index));
        });
        
        CheckBox chbDispo = new CheckBox("Disponible");
        if(t.isDisponible())
            chbDispo.isSelected();
        
                
        //Label l1 = new Label("Heure d'ouverture");
//        Picker timeOuverture = new Picker();               
//        timeOuverture.setType(Display.PICKER_TYPE_TIME);
      
//        Label l2 = new Label("Heure de fermeture");
//        Picker timeFermeture = new Picker();
//        timeFermeture.setType(Display.PICKER_TYPE_TIME);
        boolean disp;
        if(chbDispo.isSelected())
    {
        disp = true;
    }else disp = false;
        Button btnEnregistrer = new Button("Enregistrer");
        btnEnregistrer.addActionListener((e)->{
           // try {
                Categorie c = ServiceCategorie.getInstance().AfficheCat(2);
                //Utilisateur u = new Utilisateur(1, "Ahmed");
                      // Terrain t = new Terrain(tfDesignation.getText(), tfDescription.getText(), tfLocalite.getText(), lbImage.getText(), Double.parseDouble(tfPrix.getText()),u,c, timeOuverture.getValue().toString(), timeFermeture.getValue().toString() );
                      //(String designation, String description, String adresse, String image, double prix_location, Utilisateur complexe, Categorie categorie, String heure_ouverture, String heure_fermeture, String ville) {
    
                      //Terrain t = new Terrain (tfDesignation.getText(), tfDescription.getText(), tfLocalite.getText(), "t1.png", Double.parseDouble(tfPrix.getText()), "12:00:00","14:00:00", villePicker.getSelectedString(), disp);
                      Terrain tr = new Terrain (t.getId(),tfDesignation.getText(), tfDescription.getText(), tfLocalite.getText(), "t1.png", Double.parseDouble(tfPrix.getText()), villePicker.getSelectedString(), disp, t.getComplexe(), c);
                      //Terrain t = new Terrain ("kkk", "lll", "mmmm", "t1.png", 100, "hhhh");
                      System.out.println(t);
                      System.out.println(t.getVille());
                      if( ServiceTerrain.getInstance().updateTerrain(t))
                            Dialog.show("Succes","Terrain modifié avec succes",new Command("OK"));
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                  //  } catch (NumberFormatException ex) {
                     //   Dialog.show("ERROR", "erreur", new Command("OK"));
                   // }
            
        });
       
       
        btnImage.addActionListener((e)->{
            String path = Capture.capturePhoto(Display.getInstance().getDisplayWidth(), -1);
            if(path!=null)
                try{
                    System.out.println(Image.createImage(path).rotate(80));
                    imag = Image.createImage(path);
                    lbImage.setImage(imag);
                    im.setText(path);
                    this.revalidate();
                    
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            

        });
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
        addAll(tfDesignation, tfDescription, villePicker, tfLocalite, lbImage, btnImage, tfPrix, categoriePicker, chbDispo, btnEnregistrer);
        
        

            
    }


}
