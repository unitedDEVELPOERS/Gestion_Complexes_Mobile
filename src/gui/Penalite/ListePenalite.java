/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Penalite;
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
import entities.Penalite;
import services.ServicePenalite;
import entities.Reservation;
import entities.Terrain;
import entities.Utilisateur;
import gui.reservation.Reserver;
import java.util.ArrayList;
import java.util.Date;
import gui.Penalite.ModifierPenalite;


/**
 *
 * @author bezin
 */
public class ListePenalite extends Form{
private Resources theme;
Utilisateur user ;
Reservation r;
String h="";
String d="";
Form current;
ArrayList<Penalite> pr = new ArrayList<>();
    public ListePenalite(){

        current = this;
        theme = UIManager.initFirstTheme("/theme");
        setTitle("Liste des Penalite"); 
        setLayout(BoxLayout.y());

        
        pr.clear();
        pr=ServicePenalite.getInstance().AllPenalite();
            
        for (Penalite p : pr)
        {       
            add(addItemPenalite(p));
          
        }
         
         
    }
    
    
    public Container addItemPenalite(Penalite p){
        Container cnt = new Container(BoxLayout.y());
       
        Label lbDesignation = new Label(p.getDesignation());
        lbDesignation.getAllStyles().setFgColor(CENTER);
        

        cnt.addAll(lbDesignation );
        lbDesignation.addPointerPressedListener((e)->{
           
        Form formDetails = new Form();
        //Container cntDetails = new Container(BoxLayout.y());
            //*System.out.println(t.getCategorie());
        formDetails.getToolbar().addCommandToLeftBar("back", null, ett->{this.show();});
        //ImageViewer imageD = new ImageViewer(theme.getImage(p.getImage()));
            
            Label lbDesi = new Label(p.getDesignation());
            lbDesi.getAllStyles().setFgColor(CENTER);
            

                Button btnEdit = new Button("Editer");
                Button btnSupp = new Button("Supprimer");
                

                btnEdit.addActionListener((ebtnEdit)->{
                    ModifierPenalite h = new ModifierPenalite(p);
                    h.show();
                });

                
                btnSupp.addActionListener((ebtnSupp)->{
                    if (Dialog.show("Confirmation", "Voulez vous supprimer ce produit?", "OK", "Cancel")) 
                    {
                        if( ServicePenalite.getInstance().removePenalite(p))
                        {
                            Dialog.show("Success","Produit supprimé avec succes",new Command("OK"));
                            new ListePenalite().show();
                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    }
                });
                
       
      
                formDetails.addAll(lbDesi, btnEdit, btnSupp);
  
  

            


//                formDetails.addAll(imageD, lbDesig, lbDescription);
        String textURL = "http://127.0.0.1:8000/findPenalite/"+p.getId();
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
