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
import entities.Competition;
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
public class ServiceCompetition {
    public Competition competition;
    public static ServiceCompetition instance;
    public boolean resultOK;
    private ConnectionRequest req;             //pour la connexion
    public ArrayList<Competition> comps;
    
    
    public ServiceCompetition(){
         req=new ConnectionRequest();
    }
    
    
    public static ServiceCompetition getInstance(){
        if(instance==null){
            instance =new ServiceCompetition();
        }return instance;
    }
    
    
       
    public boolean addCompetition(Competition c){
       String url =Statics.BASE_URL+"/AddCompetition/"+c.getDesignation()+"/"+c.getDate_debut()+"/"+c.getNbre_equipes()+"/"+c.getPrix_participation();
        
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
              resultOK=req.getResponseCode()==200;
              req.removeResponseListener(this);
           }
        
        });
         
         NetworkManager.getInstance().addToQueueAndWait(req);   //exuction du requet
        return resultOK;
    }
    
//      public ArrayList<Competition> parseUsers(String jsonText){
//        try {
//            comps=new ArrayList<>();
//            JSONParser j=new JSONParser();
//            
//            
//            Map<String,Object> CompetitionListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            List<Map<String,Object>> list = (List<Map<String,Object>>)CompetitionListJson.get("root");
//              
//            for(Map<String,Object> obj : list){
//                Competition e=new Competition();
//               
//                e.setDesignation(obj.get("desgniation").toString());
//                e.setDate_debut(obj.get("date_debut").toString());
//                e.setNbre_equipes(obj.get("nbre_equipes").toString());
//
//                comps.add(e);
//                
//            }
//           
//        } catch (IOException ex) {
//            
//        }
//         return comps;
//    }

       public ArrayList<Competition> getAllCompetition(){
       
           ArrayList<Competition> result=new ArrayList<>();
           String url = Statics.BASE_URL+"/liste";
           req.setUrl(url);
           req.setPost(false);
           
           req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
              
                 JSONParser j;
                 j=new JSONParser();
                try{
                    
                Map<String,Object> CompetitionListJson=j.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                List<Map<String,Object>> list = (List<Map<String,Object>>)CompetitionListJson.get("root");
              
                for(Map<String,Object> obj : list){
                Competition e=new Competition();
               
                e.setDesignation(obj.get("desgniation").toString());
                e.setDate_debut(obj.get("dateDebut").toString());
                e.setNbre_equipes(obj.get("nbreEquipes").toString());
                e.setPrix_participation(obj.get("prixParticipation").toString());
                comps.add(e);
                
            }
           
            } catch (IOException ex) {
            
            }
                
//                comps = parseUsers(new String(req.getResponseData()));
//                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return comps;
    }

    
      public Competition Detailreclamation(int id,Competition competition){
      
       String url =Statics.BASE_URL+"/CompetitionId/id";
       req.setUrl(url);
       
       
       String str=new String(req.getResponseData());
       req.addResponseListener(new ActionListener<NetworkEvent>(){
           @Override
           public void actionPerformed(NetworkEvent evt) {
               
               JSONParser  j=new JSONParser();
               try{
               
       Map<String,Object>obj=j.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                  
                competition.setDesignation(obj.get("desgniation").toString());
                competition.setDate_debut(obj.get("dateDebut").toString());
                competition.setNbre_equipes(obj.get("nbreEquipes").toString());
                competition.setPrix_participation(obj.get("prixParticipation").toString());
               
               }catch(IOException ex){
                
               System.out.println("error sql"+ex.getMessage());
                }
               System.out.println("data ===="+str);
           }
        
        });
         
      NetworkManager.getInstance().addToQueueAndWait(req);
        return competition;
      
      }
       
       
       
       
       
       
       
       
       
    public Competition getUtilisateur() {
        return competition;
    }

    public void setUtilisateur(Competition competition) {
        this.competition = competition;

    
    }
    
    
    
}
