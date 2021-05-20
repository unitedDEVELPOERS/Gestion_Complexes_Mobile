/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.ConnectionRequest;
import static com.codename1.io.Log.p;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import entities.Reservation;
import entities.Terrain;
import entities.Utilisateur;
import gui.reservation.Reserver;
import java.util.ArrayList;
import java.util.Date;
import services.ServiceReservation;
import services.ServiceTerrain;

/**
 *
 * @author ahmed
 */
public class ListeTerrains extends Form{
private Resources theme;
Utilisateur user ;
Reservation r;
String h="";
String d="";
Form current;
ArrayList<Terrain> tr = new ArrayList<>();
    public ListeTerrains(Form previous, Utilisateur u){
        user = u;
        current = this;
        theme = UIManager.initFirstTheme("/theme");
        setTitle("Liste des terrains"); 
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        getToolbar().addMaterialCommandToRightBar("",FontImage.MATERIAL_HOME,e->previous.showBack());
        
        tr.clear();
        if( "[ROLE_PROP]".equals(user.getRoles())){
            tr=ServiceTerrain.getInstance().getAllTerrains(user);
        }
        else tr=ServiceTerrain.getInstance().AllTerrains();
            
        for (Terrain t : tr)
        {       
            add(addItemTerrain(t));
          
        }
         
         
    }
    
    
    
    public Container addItemTerrain(Terrain t){
         Container cnt = new Container(BoxLayout.y());
       
        Label lbDesignation = new Label(t.getDesignation());
        lbDesignation.getAllStyles().setFgColor(CENTER);
        Label lbAdresse = new Label(t.getAdresse());
        lbAdresse.getAllStyles().setFgColor(CENTER);
        Label lbVille = new Label(t.getVille());
        lbVille.getAllStyles().setFgColor(CENTER);
        
        ImageViewer lbimg = new ImageViewer(theme.getImage(t.getImage()));
        
        //cnt.addAll(image, lbDesignation, lbAdresse);
        cnt.addAll(lbimg,lbDesignation,lbVille, lbAdresse);
        lbDesignation.addPointerPressedListener((e)->{
           
        Form formDetails = new Form("Details", BoxLayout.y());
        //Container cntDetails = new Container(BoxLayout.y());
            //*System.out.println(t.getCategorie());
        formDetails.getToolbar().addCommandToLeftBar("back", null, ett->{this.show();});
        ImageViewer imageD = new ImageViewer(theme.getImage(t.getImage()));
            
            Label lbDesig = new Label(t.getDesignation());
            lbDesig.getAllStyles().setFgColor(CENTER);
            Label lbDescription = new Label(t.getDescription());
            lbDescription.getAllStyles().setFgColor(CENTER);
if( "[ROLE_PROP]".equals(user.getRoles())){
                Button btnEdit = new Button("Editer");
                Button btnSupp = new Button("Supprimer");
                

                btnEdit.addActionListener((ebtnEdit)->{
                    ModifierTerrain h = new ModifierTerrain(formDetails, t);
                    h.show();
                });

                
                btnSupp.addActionListener((ebtnSupp)->{
                    if (Dialog.show("Confirmation", "Voulez vous supprimer ce terrain?", "OK", "Cancel")) 
                    {
                        if( ServiceTerrain.getInstance().removeTerrain(t))
                        {
                            Dialog.show("Success","Terrain supprimé avec succes",new Command("OK"));
                            new ListeTerrains(formDetails, user).show();
                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    }
                });
                
       
      
                formDetails.addAll(imageD, lbDesig, lbDescription, btnEdit, btnSupp);
}   
  
else  if( "[ROLE_USER]".equals(user.getRoles())){
                Picker date = new Picker();
        date.setType(Display.PICKER_TYPE_CALENDAR);
        Picker heure = new Picker();               
        heure.setStrings("08:00","10:00","12:00","14:00","16:00","18:00","20:00","22:00");
        heure.addActionListener((her)->{
            if(heure.getSelectedString()=="08:00")
                h="08";
            if(heure.getSelectedString()=="10:00")
                h="10";
            if(heure.getSelectedString()=="12:00")
                h="12";
            if(heure.getSelectedString()=="14:00")
                h="14";
            if(heure.getSelectedString()=="16:00")
                h="16";
            if(heure.getSelectedString()=="18:00")
                h="18";
            if(heure.getSelectedString()=="20:00")
                h="20";
            if(heure.getSelectedString()=="22:00")
                h="22";
        });
        Button btnReserv = new Button("Réserver");
        
        date.addActionListener((d)->{
          
        });
            
        btnReserv.addActionListener((btnRes)->{
            if(heure.getSelectedStringIndex()!=-1)
            {
            ArrayList<Reservation> lr = new ArrayList<>();
            lr= ServiceReservation.getInstance().getAllReservations();
                System.out.println(lr);
            d+="20"+date.getText().substring(6, 8)+date.getText().substring(3, 5)+date.getText().substring(0, 2);
            
            r = new Reservation(d, h, user, t, t.getPrix_location());
                System.out.println(r);
            if(lr.contains(r))System.out.println("existe");
            d="";

            if(ServiceReservation.getInstance().addReservation(r))
                Dialog.show("Success","Connection accepted",new Command("OK"));
                        else
                            Dialog.show("ERREUR", "Server error", new Command("OK"));
            }
            else Dialog.show("Erreur","Vous devez indiquez une date et une heure valide",new Command("OK"));
        });
        
             
                formDetails.addAll(imageD, lbDesig, lbDescription, date, heure, btnReserv);
}

//                formDetails.addAll(imageD, lbDesig, lbDescription);
        String textURL = "http://127.0.0.1:8000/findTerrain/"+t.getId();
        Label ds = new Label();
            ConnectionRequest con = new ConnectionRequest();
        
        con.setUrl(textURL);
        con.setPost(false);
        
        con.addResponseListener((ee)->{
            String response = new String(con.getResponseData());
            System.out.println(response);
            ds.setText("Received text : " + response);
        });
        
            NetworkManager.getInstance().addToQueueAndWait(con);
            //cntDetails.addAll(imgViewer, ds);
//            cntDetails.add(ds);
//            formDetails.add(cntDetails);
            formDetails.show();
        
        
        });
        return cnt;
    }

    
}
