/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import entities.Reservation;
import java.util.ArrayList;
import services.ServiceReservation;

/**
 *
 * @author ahmed
 */
public class ListeReservations extends Form{
private Resources theme;
    public ListeReservations(Form previous){
        
        theme = UIManager.initFirstTheme("/theme");
         setTitle("Liste des terrains"); 
         setLayout(BoxLayout.y());
         
        ArrayList<Reservation> res = new ArrayList<>();
        res=ServiceReservation.getInstance().getAllReservations();
        for (Reservation r : res)
        {          
            add(addItemReservation(r));
        }
    }
    
    public Container addItemReservation(Reservation r){
        Container cnt = new Container(BoxLayout.y());
        //ImageViewer lbImage = new ImageViewer(theme.getImage("image.png"));
        
        Label lbClient = new Label(r.getClient().getNom());
        Label lbTerrain = new Label(r.getTerrain().getDesignation());
        cnt.addAll(lbClient, lbTerrain);
        cnt.addPointerPressedListener((e)->{
           
        Form formDetails = new Form("Details", BoxLayout.y());
        Container cntDetails = new Container(BoxLayout.y());
        
            EncodedImage enc = EncodedImage.createFromImage(theme.getImage("image.png"), true);
            
        String textURL = "http://127.0.0.1:8000/findReservation/"+r.getId();
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
            cntDetails.addAll(ds);
            formDetails.add(cntDetails);
           formDetails.show();
        
        
        });
        return cnt;
    }
    
}
