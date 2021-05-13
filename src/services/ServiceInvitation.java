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
import com.codename1.ui.layouts.GroupLayout.Group;
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import entities.Equipe;
import entities.Invitation;
import entities.Utilisateur;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import utils.Statics;
/**
 *
 * @author fachr
 */
public class ServiceInvitation {
       public Utilisateur utilisateur;
    public static ServiceInvitation instance;
    public boolean resultOK;
    private ConnectionRequest req;
        public ArrayList<Invitation> Invitations;
    public ServiceInvitation(){
         req=new ConnectionRequest();
    }
    public static ServiceInvitation getInstance(){
        if(instance==null){
            instance =new ServiceInvitation();
        }return instance;
    }
     
    public boolean addInvitation(Invitation i){
       String url =Statics.BASE_URL+"/AddInvitation/"+i.getType()+"/"+i.getEquipe().getId()+"/"+i.getUtilisateur().getId()+"/"+i.getValide();
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
      public ArrayList<Invitation> parseInvitation(String jsonText){
        try {
            Invitations=new ArrayList<>();
            JSONParser j=new JSONParser();
            Map<String,Object> UtilisateurListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                List<Map<String,Object>> list = (List<Map<String,Object>>)UtilisateurListJson.get("root");
               for(Map<String,Object> obj : list){
                Invitation e=new Invitation();
             
   
                float id =Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                     e.setType(obj.get("type").toString());
               
                  LinkedHashMap<String,Object> a=new LinkedHashMap<String,Object>();  
                  a=(LinkedHashMap<String, Object>) obj.get("equipe");
    
     System.out.println(a);
                Invitations.add(e);
                
            }
           
        } catch (IOException ex) {
            
        }
         return Invitations;
    }

       public ArrayList<Invitation> getAllInvitation(){
        String url = Statics.BASE_URL+"/AllInvitation";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Invitations = parseInvitation(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Invitations;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

    
    }
    
    
    
    
}
