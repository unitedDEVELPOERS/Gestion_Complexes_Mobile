/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Categorie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author sahar
 */
public class ServiceCategorie {
 public Categorie categorie;    
 private ConnectionRequest req;
      public ArrayList<Categorie> Categorie;
 public static ServiceCategorie instance;
 public boolean resultOK=true;
 
 
 
 public ServiceCategorie(){
         req=new ConnectionRequest();
    }
 
  public static ServiceCategorie getInstance(){
        if(instance==null){
            instance =new ServiceCategorie();
        }return instance;
    }
  
 public boolean addCategorie(Categorie u){
       String url =Statics.BASE_URL+"/AddCategorie/"+u.getDesignation();
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
 
  public ArrayList<Categorie> parseCategorie(String jsonText){
        try {
            Categorie=new ArrayList<>();
            JSONParser j=new JSONParser();
            Map<String,Object> CategorieListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                List<Map<String,Object>> list = (List<Map<String,Object>>)CategorieListJson.get("root");
               for(Map<String,Object> obj : list){
                Categorie e=new Categorie();
                float id =Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
               e.setDesignation(obj.get("designation").toString());
           
                Categorie.add(e);
                
            }
           
        } catch (IOException ex) {
            
        }
         return Categorie;
    }

  public ArrayList<Categorie> getAllCategorie(){
        String url = Statics.BASE_URL+"/allCategorie";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Categorie = parseCategorie(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Categorie;
    }
  
  
  public Categorie AfficheCat(int id){
      Categorie categorie = new Categorie();
    String url = Statics.BASE_URL+"/Categorie/"+id;
     req.setUrl(url);
        req.setPost(false);
         req.addResponseListener(new ActionListener<NetworkEvent>(){
        @Override
        public void actionPerformed(NetworkEvent evt) {
            try {
                JSONParser j=new JSONParser();
                Map<String,Object> CategorieJson=j.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
             float id =Float.parseFloat(CategorieJson.get("id").toString());
                categorie.setId((int)id);
               categorie.setDesignation(CategorieJson.get("designation").toString());
                req.removeResponseListener(this);
            } catch (IOException ex) {
                
             }
            System.out.println("data==="+req.getResponseData());
        }   });
          
         NetworkManager.getInstance().addToQueueAndWait(req);
      return categorie;
  }
  
  
  
  
  
  public boolean SuppCategorie(int id){
       String url = Statics.BASE_URL+"/SuppCategorie/"+id;
        req.setUrl(url);
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
              req.removeResponseListener(this);
           } });
           NetworkManager.getInstance().addToQueueAndWait(req);
       return resultOK;
  }
  
  public boolean UpdateCategorie(Categorie categorie){
             String url = Statics.BASE_URL+"/UpCategorie/"+categorie.getId();
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
  
  
  
  
  
  
  
  
  
  
  
  
  
  
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }
 
 
 
 
 
 
 
 
}
