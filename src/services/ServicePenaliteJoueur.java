/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;

import com.codename1.ui.events.ActionListener;
import entities.Penalite;
import entities.PenaliteJoueur;
import com.codename1.io.CharArrayReader;
import java.io.IOException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.Statics;

/**
 *
 * @author bezin
 */
public class ServicePenaliteJoueur {
    public ArrayList<PenaliteJoueur> PenaliteJoueurs;
    
    public static ServicePenaliteJoueur instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServicePenaliteJoueur() {
         req = new ConnectionRequest();
    }

    public static ServicePenaliteJoueur getInstance() {
        if (instance == null) {
            instance = new ServicePenaliteJoueur();
        }
        return instance;
    }
    
    
        public boolean addPenaliteJoueur(PenaliteJoueur pj) {
        String url =Statics.BASE_URL+"/AddPenaliteJoueur/"+pj.getJoueur()+"/"+pj.getPenalite()+"/"+pj.getHeure();

//
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode()==200;
              req.removeResponseListener(this);
            }
        
        });
         
         NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
        
        
//            public boolean updatePenaliteJoueur(PenaliteJoueur pj) {
//     
//        String url =Statics.BASE_URL+"/UpdatePenalite/"+pj.getId()+"/"+pj.getJoueur()+"/"+pj.getPenalite();
//        
//        req.setUrl(url);
//        req.addResponseListener(new ActionListener<NetworkEvent>(){
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//              resultOK=req.getResponseCode()==200;
//              req.removeResponseListener(this);
//            }
//        
//        });
//         
//         NetworkManager.getInstance().addToQueueAndWait(req);
//        return resultOK;
//    }
    
    
    
    
       public boolean removePenaliteJoueur(PenaliteJoueur pj) {
        String url =Statics.BASE_URL+"/deletePenalitePenaliteJoueur/"+pj.getId();
//        
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode()==200;
              req.removeResponseListener(this);
            }
        
        });
         
         NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
        public ArrayList<PenaliteJoueur> parsePenaliteJoueur(String jsonText){
        try {
            PenaliteJoueurs=new ArrayList<>();
            JSONParser j = new JSONParser();
            
            Map<String,Object> PenaliteJoueurListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)PenaliteJoueurListJson.get("root");
            
    
            for(Map<String,Object> obj : list){
           
                PenaliteJoueur pj = new PenaliteJoueur ();
                float id = Float.parseFloat(obj.get("id").toString());
                pj.setId((int)id);
//                  pj.setHeure(obj.get("heure").toString());
//              
//                   pj.setJoueur(obj.get("joueur").toString());
//             
//                  pj.setPenalite((int)Float.parseFloat(obj.get("penalite").toString()));
//           
//                
                PenaliteJoueurs.add(pj);
            }
            
            
        } catch (IOException ex) {
            
        }
       
        return PenaliteJoueurs;
    }
        
            public ArrayList<PenaliteJoueur> getAllPenaliteJoueur(){
        String url = Statics.BASE_URL+"/AllPenaliteJoueur/";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
//                PenaliteJoueurs = parsePenaliteJoueur(new String(req.getResponseData()));
//                req.removeResponseListener(this);
            }
       
            
            
        });
        
          
      
  NetworkManager.getInstance().addToQueueAndWait(req);
     return PenaliteJoueurs;
    
            }
}
