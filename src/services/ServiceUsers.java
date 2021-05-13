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
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import entities.Equipe;
import entities.Utilisateur;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import utils.Statics;


/**
 *
 * @author sahar
 */
public class ServiceUsers {
    public Utilisateur utilisateur;
    public static ServiceUsers instance;
    public boolean resultOK;
    private ConnectionRequest req;
      public ArrayList<Utilisateur> Utilisateurs;
    public ServiceUsers(){
         req=new ConnectionRequest();
    }
    public static ServiceUsers getInstance(){
        if(instance==null){
            instance =new ServiceUsers();
        }return instance;
    }
       public boolean Login(String email,String mdp){
       String url =Statics.BASE_URL+"/Login/"+email;
           req.setUrl(url);
           req.setReadResponseForErrors(false);
           req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
               if(req.getResponseData().length>10)
              resultOK=req.getResponseCode()==200;
              try {
          
            JSONParser j=new JSONParser();
            Map<String,Object> UtilisateurListJson=j.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                List<Map<String,Object>> list = (List<Map<String,Object>>)UtilisateurListJson.get("root");
               for(Map<String,Object> obj : list){
                   String pass=obj.get("password").toString();
                     Argon2 argon2;
        argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
                    boolean success = argon2.verify(pass, mdp);
                    if(!success){
                        resultOK=false;
                    }
                Utilisateur e=new Utilisateur();
                float id =Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
               e.setEmail(obj.get("email").toString());
                e.setNom(obj.get("nom").toString());
                  e.setPrenom(obj.get("prenom").toString());
           setUtilisateur(e);
              
                
            }
           
        } catch (IOException ex) {
            
        }
              req.removeResponseListener(this);
           }
        
        });
         
         NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    public boolean addUsers(Utilisateur u){
       String url =Statics.BASE_URL+"/AddUsers/"+u.getEmail()+"/"+u.getPwd()+"/"+u.getNom()+"/"+u.getPrenom()+"/"+u.getTel()+"/"+u.getPosition()+"/"+u.getRoles();
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
      public ArrayList<Utilisateur> parseUsers(String jsonText){
        try {
            Utilisateurs=new ArrayList<>();
            JSONParser j=new JSONParser();
            Map<String,Object> UtilisateurListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
                List<Map<String,Object>> list = (List<Map<String,Object>>)UtilisateurListJson.get("root");
               for(Map<String,Object> obj : list){
                Utilisateur e=new Utilisateur();
                float id =Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
               e.setEmail(obj.get("email").toString());
                e.setNom(obj.get("nom").toString());
                  e.setPrenom(obj.get("prenom").toString());
  
                Utilisateurs.add(e);
                
            }
           
        } catch (IOException ex) {
            
        }
         return Utilisateurs;
    }

       public ArrayList<Utilisateur> getAllUsers(){
        String url = Statics.BASE_URL+"/allUsers";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Utilisateurs = parseUsers(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Utilisateurs;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

    
    }
    
    
    
}
