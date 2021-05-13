/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import entities.*;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author ahmed
 */
public class ServiceTerrain {
    public ArrayList<Terrain> terrains;
    
    public static ServiceTerrain instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceTerrain() {
         req = new ConnectionRequest();
    }

    public static ServiceTerrain getInstance() {
        if (instance == null) {
            instance = new ServiceTerrain();
        }
        return instance;
    }
    
    
    public boolean addTerrain(Terrain t) {
        String url =Statics.BASE_URL+"/addTerrainJson/"+t.getDesignation()+"/"+t.getDescription()+"/"+t.getAdresse()+"/"+t.getImage()+"/"+t.getPrix_location()+"/"+t.getVille()+"/"+t.getComplexe().getId()+"/"+t.getComplexe().getId();

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
    
    
    public boolean updateTerrain(Terrain t) {
        String url =Statics.BASE_URL+"/modifierTerrainJson/"+t.getId()+"/"+t.getDesignation()+"/"+t.getDescription()+"/"+t.getAdresse()+"/"+t.getImage()+"/"+t.getPrix_location()+"/"+t.getVille()+"/"+t.getComplexe().getId()+"/"+t.getComplexe().getId();
        
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
    
    
    public boolean removeTerrain(Terrain t) {
        String url =Statics.BASE_URL+"/supprimerTerrainJson/"+t.getId();
        
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
    
    
    
    
    public ArrayList<Terrain> parseTerrain(String jsonText){
        try {
            terrains=new ArrayList<>();
            JSONParser j = new JSONParser();
            
            Map<String,Object> TerrainsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)TerrainsListJson.get("root");
            
    
            for(Map<String,Object> obj : list){
           
                Terrain t = new Terrain();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setDesignation(obj.get("designation").toString());
                t.setDescription(obj.get("description").toString());
                t.setAdresse(obj.get("adresse").toString());
                t.setImage(obj.get("image").toString());
       
                terrains.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
       
        return terrains;
    }
    
    
    public ArrayList<Terrain> getAllTerrains(){
        String url = Statics.BASE_URL+"/allTerrains";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                terrains = parseTerrain(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return terrains;
    }

}
