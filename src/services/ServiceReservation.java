/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Reservation;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Terrain;
import entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author ahmed
 */
public class ServiceReservation {
  public ArrayList<Reservation> reservations;
    
    public static ServiceReservation instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceReservation() {
         req = new ConnectionRequest();
    }

    public static ServiceReservation getInstance() {
        if (instance == null) {
            instance = new ServiceReservation();
        }
        return instance;
    }
    
    
    public boolean addReservation(Reservation r) {
       
        String url = Statics.BASE_URL + "/addReservationJson/" +r.getDate_reservation()+"/"+r.getHeure()+"/"+ r.getClient().getId()+ "/" + r.getTerrain().getId()+"/"+r.getMontant(); //création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener
                /* une fois que nous avons terminé de l'utiliser.
                La ConnectionRequest req est unique pour tous les appels de 
                n'importe quelle méthode du Service task, donc si on ne supprime
                pas l'ActionListener il sera enregistré et donc éxécuté même si 
                la réponse reçue correspond à une autre URL(get par exemple)*/
                
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
    
    
    public ArrayList<Reservation> parseReservation(String jsonText){
        try {
            reservations=new ArrayList<>();
            JSONParser j = new JSONParser();
            
            Map<String,Object> ReservationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)ReservationsListJson.get("root");
            
    
            for(Map<String,Object> obj : list){
           
                Reservation r = new Reservation();
                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int)id);
                Utilisateur u = new Utilisateur();
                
                r.setClient((Utilisateur)obj.get("client"));
                r.setTerrain((Terrain)obj.get("terrain"));
                r.setDate_reservation(obj.get("dateReservation").toString());
                r.setHeure(obj.get("heure").toString());
       
                reservations.add(r);
            }
            
            
        } catch (IOException ex) {
            
        }
       
        return reservations;
    }
    
    
    public ArrayList<Reservation> getAllReservations(){
        String url = Statics.BASE_URL+"/allReservations";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reservations = parseReservation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reservations;
    }
    
   

}
