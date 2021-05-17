/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.codename1.capture.Capture;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import entities.Categorie;
import entities.Terrain;
import entities.Utilisateur;
import gui.Equipe.ListEquipeForm;
import gui.user.Authentification;
import gui.user.CompteClient;
import java.io.IOException;
import java.util.ArrayList;
import services.ServiceCategorie;
import services.ServiceTerrain;

/**
 *
 * @author ahmed
 */
public class AjouterTerrain extends Form{
    private Resources theme;
    Utilisateur utilisateur ;
    
    Categorie c=null;
    int index = 0;
    public AjouterTerrain(Form previous, Utilisateur u){
        theme = UIManager.initFirstTheme("/theme");
        setTitle("Nouveau terrain");   
        setLayout(BoxLayout.y());
        utilisateur = u;
        
       
        
        TextField tfDesignation = new TextField("", "Désignation");
        TextField tfDescription = new TextField("", "Description");
   
        Picker villePicker = new Picker();
        villePicker.setStrings("Ariana", "Béja", "Ben Arous", "Bizerte", "Gabes", "Gafsa",
            "Jendouba", "Kairouan", "Kasserine", "Kebili", "Kef", "Mahdia", "Manouba",
            "Medenine", "Manastir", "Nabeul" ,"Sfax", "Sidi Bouzid", "Siliana", "Sousse",
            "Tataouine", "Tozeur", "Tunis", "Zaghouan");  
        villePicker.setText("Ville");
        TextField tfLocalite = new TextField("", "Localité");
        Label im = new Label();
        Label lbImage = new Label();
        Button btnImage = new Button("Selectionner une image");
       
        TextField tfPrix = new TextField("", "Prix de location");
        Picker categoriePicker = new Picker();
        ArrayList<Categorie> cat = new ArrayList<>();
        ArrayList<String> list = new ArrayList<>();
//        if(ServiceCategorie.getInstance().getAllCategorie().size()>0)
//        {   
//        cat = ServiceCategorie.getInstance().getAllCategorie();
//        
//        for ( Categorie c : cat)
//            l.add(c.getDesignation());
//        }
        categoriePicker.setStrings("Football", "Handball", "Basket-ball"); 
       
    

     
        categoriePicker.setText("Catégorie");
        categoriePicker.addActionListener((eee)->{
             index= 1+categoriePicker.getSelectedStringIndex();
             if(index==1)
                 c=new Categorie(1, "Football");
             else if(index==2)
                 c=new Categorie(2, "Handball");
             else if(index==3)
                 c=new Categorie(3, "Basket-ball");
             //System.out.println(ServiceCategorie.getInstance().AfficheCat(index));
        });
        
        CheckBox chbDispo = new CheckBox("Disponible");
                
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
           
            if(tfDesignation.getText().length()>0 && tfDescription.getText().length()>0 && tfLocalite.getText().length()>0
                    && tfPrix.getText().length()>0 && villePicker.getSelectedStringIndex()!=-1 && c!=null)
            {   
              Terrain t = new Terrain (tfDesignation.getText(), tfDescription.getText(), tfLocalite.getText(), "t1.png", Double.parseDouble(tfPrix.getText()), villePicker.getSelectedString(), disp, u, c);
                      //Terrain t = new Terrain ("kkk", "lll", "mmmm", "t1.png", 100, "hhhh");
                      System.out.println(t);
                      System.out.println(t.getVille());
                      if( ServiceTerrain.getInstance().addTerrain(t)){
                            Dialog.show("Success","Terrain ajouté avec succes",new Command("OK"));

                    AjouterTerrain ff = new AjouterTerrain(previous,u);
                    ff.show();

                      }
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
            }    
            else Dialog.show("ERROR","Tous les champs sont obligatoires",new Command("OK"));

        });
       
       
        btnImage.addActionListener((e)->{
            String path = Capture.capturePhoto(1080, 650);
     
            if(path!=null)
                try{
                     
                    Image imag = Image.createImage(path);
                    lbImage.setIcon(imag);
                    im.setText(path);
                    this.revalidate();
                    
                }catch(IOException ex){
                    ex.printStackTrace();
                }
            

        });
         Accueil accueil = new Accueil(u);
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_HOME,e->previous.showBack());
        
        addAll(tfDesignation, tfDescription, villePicker, tfLocalite, lbImage, btnImage, tfPrix, categoriePicker, chbDispo, btnEnregistrer);
        
        

            
    }
    
    
    
}
