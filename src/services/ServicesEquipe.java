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
import entities.Equipe;

import com.codename1.io.CharArrayReader;
import java.io.IOException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.Statics;


/**
 *
 * @author fachr
 */
public class ServicesEquipe {
    public ArrayList<Equipe> Equips;
    public static ServicesEquipe instance;
    public boolean resultOK;
    private ConnectionRequest req;
    
    
    public ServicesEquipe(){
         req=new ConnectionRequest();
    }
    public static ServicesEquipe getInstance(){
        if(instance==null){
            instance =new ServicesEquipe();
        }return instance;
    }
    public boolean addEquipe(Equipe e){
       String url =Statics.BASE_URL+"/AddEquipe/"+e.getNom()+"/"+e.getNbre_joueur();
         
       
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
    
    public ArrayList<Equipe> parseEquips(String jsonText){
        try {
            Equips=new ArrayList<>();
            JSONParser j=new JSONParser();
            Map<String,Object> EquipeListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                List<Map<String,Object>> list = (List<Map<String,Object>>)EquipeListJson.get("root");
               for(Map<String,Object> obj : list){
                Equipe e=new Equipe();
                float id =Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                e.setNbre_joueur((int)Float.parseFloat(obj.get("nbreJoueur").toString()));
                e.setNom(obj.get("nom").toString());
  
                Equips.add(e);
                
            }
           
        } catch (IOException ex) {
            
        }
         return Equips;
    }

       public ArrayList<Equipe> getAllEquips(){
        String url = Statics.BASE_URL+"/AllEquipe";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Equips = parseEquips(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Equips;
    }
    
}
