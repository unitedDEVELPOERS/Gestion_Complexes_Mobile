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
public class ServicePenalite {
    
   public ArrayList<Penalite> Penalites;
  
    public static ServicePenalite instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServicePenalite() {
         req = new ConnectionRequest();
    }

    public static ServicePenalite getInstance() {
        if (instance == null) {
            instance = new ServicePenalite();
        }
        return instance;
    }
    
    
        public boolean addPenalite(Penalite p) {
        String url =Statics.BASE_URL+"/AddPenalite/"+p.getDesignation()+"/"+p.getNbrePointsRetires();

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
        
        
            public boolean updatePenalite(Penalite p) {
     
        String url =Statics.BASE_URL+"/modifierPenaliteJson/"+p.getId()+"/"+p.getDesignation()+"/"+p.getNbrePointsRetires();
        
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
    
    
    
    
       public boolean removePenalite(Penalite p) {
        String url =Statics.BASE_URL+"/deletePenalite/"+p.getId();
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
//        public ArrayList<Penalite> parsePenalite(String jsonText){
//        try {
//            Penalites=new ArrayList<>();
//            JSONParser j = new JSONParser();
//            
//            Map<String,Object> PenaliteListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)PenaliteListJson.get("root");
//            
//    
//            for(Map<String,Object> obj : list){
//           
//                Penalite p = new Penalite();
//                float id = Float.parseFloat(obj.get("id").toString());
//                p.setId((int)id);
//                 
////                p.setDesignation((int)designation);
////                p.setNbrePointsRetires(obj.get("name").toString());
////               
////                 float price = Float.parseFloat(obj.get("price").toString());
////                p.setNbrePointsRetires((float)nbrePointsRetires);
//                   p.setDesignation(obj.get("designation").toString());
//             
//                  p.setNbrePointsRetires((int)Float.parseFloat(obj.get("NbrePointsRetires").toString()));
//           
//               // p.setComplexe(obj.get("complexe").toString());
//                Penalites.add(p);
//            }
//            
//            
//        } catch (IOException ex) {
//            
//        }
//       
//        return Penalites;
//    }
//        
       
        public ArrayList<Penalite> parsePenalite(String jsonText){
        try {
            Penalites=new ArrayList<>();
            JSONParser j = new JSONParser();
            
            Map<String,Object> ProduitsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)ProduitsListJson.get("root");
            
    
            for(Map<String,Object> obj : list){
           
                Penalite p = new Penalite();
                float id = Float.parseFloat(obj.get("id").toString());
                p.setDesignation(obj.get("designation").toString());
                float nbrePointsRetire = Float.parseFloat(obj.get("nbrePointsRetires").toString());
                p.setId((int)id);
              
                
             
                Penalites.add(p);
            }
            
            
        } catch (IOException ex) {
            
        }
       
        return Penalites;
    }
        
       
       
       
       
       
       
       
       
       
       
            public ArrayList<Penalite> getAllPenalite(){
        String url = Statics.BASE_URL+"/allPenalites";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                Penalites = parsePenalite(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Penalites;
    }
            
       public ArrayList<Penalite> AllPenalite(){
        String url = Statics.BASE_URL+"/ltp";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
               Penalites = parsePenalite(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return Penalites;
        
    }
        
    

    
//    public ArrayList<Penalite> Penalite;
//    
//    public static ServicePenalite instance=null;
//    public boolean resultOK;
//    private ConnectionRequest req;
//
//    public ServicePenalite() {
//         req = new ConnectionRequest();
//    }
//
//    public static ServicePenalite getInstance() {
//        if (instance == null) {
//            instance = new ServicePenalite();
//        }
//        return instance;
//    }
//    
//    
//   public boolean addPenalite(Penalite p) {
//        String url =Statics.BASE_URL+"/AddPenalite/"+p.getDesignation()+"/"+p.getNbrePointsRetires();
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
//    
//    
//  
//     public boolean deletePenalite(Penalite t) {
//        String url =Statics.BASE_URL+"/deletePenalite/"+t.getId();
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
//    
//    public Penalite AffichePenalite(int id){
//      Penalite penalite = new Penalite();
//    String url = Statics.BASE_URL+"/PenaliteId/"+id;
//     req.setUrl(url);
//        req.setPost(false);
//         req.addResponseListener(new ActionListener<NetworkEvent>(){
//        @Override
//        public void actionPerformed(NetworkEvent evt) {
//            try {
//                JSONParser j=new JSONParser();
//                Map<String,Object> penaliteJson=j.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
//             float id =Float.parseFloat(penaliteJson.get("id").toString());
//                penalite.setId((int)id);
//               penalite.setDesignation(penaliteJson.get("designation").toString());
//                req.removeResponseListener(this);
//            } catch (IOException ex) {
//                
//             }
//            System.out.println("data==="+req.getResponseData());
//        }   });
//          
//         NetworkManager.getInstance().addToQueueAndWait(req);
//      return penalite;
//  }
//  
//  
//   
//    
//    public boolean updatePenalite(Penalite t) {
//        String url =Statics.BASE_URL+"/UpdatePenalite/"+t.getId()+"/"+t.getDesignation()+"/"+t.getNbrePointsRetires();
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
//    
//    
//    
//    public ArrayList<Penalite> parsePenalite(String jsonText){
//        try {
//            Penalite =new ArrayList<>();
//            JSONParser j = new JSONParser();
//            
//            Map<String,Object> PenaliteListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)PenaliteListJson.get("root");
//            
//    
//            for(Map<String,Object> obj : list){
//           
//                Penalite p = new Penalite();
//                float id = Float.parseFloat(obj.get("id").toString());
//                p.setId((int)id);
//                p.setDesignation(obj.get("designation").toString());
//             
//              p.setNbrePointsRetires((int)Float.parseFloat(obj.get("NbrePointsRetires").toString()));
//                
//                Penalite.add(p);
//            }
//            
//            
//        } catch (IOException ex) {
//            
//        }
//       
//        return Penalite;
//    }
//    
//    
//    
//    public ArrayList<Penalite> getAllPenalite(){
//        String url = Statics.BASE_URL+"/AllPenalite";
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//               Penalite = parsePenalite(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return Penalite;
//    }
//
//}
//    
////     public ArrayList<Penalite> Penalite;
////    
////    public static ServicePenalite instance=null;
////    public boolean resultOK;
////    private ConnectionRequest req;
////
////    private ServicePenalite() {
////         req = new ConnectionRequest();
////    }
////
////    public static ServicePenalite getInstance() {
////        if (instance == null) {
////            instance = new ServicePenalite();
////        }
////        return instance;
////    }
////    
////    
////    public boolean addPenalite(Penalite t) {
////        String url =Statics.BASE_URL+"/AddPenalite/"+t.getDesignation()+"/"+t.getNbrePointsRetires();
////
////        req.setUrl(url);
////        req.addResponseListener(new ActionListener<NetworkEvent>(){
////            @Override
////            public void actionPerformed(NetworkEvent evt) {
////              resultOK=req.getResponseCode()==200;
////              req.removeResponseListener(this);
////            }
////        
////        });
////         
////         NetworkManager.getInstance().addToQueueAndWait(req);
////        return resultOK;
////    }
////    
////    
////    public boolean updatePenalite(Penalite t) {
////        String url =Statics.BASE_URL+"/UpdatePenalite/"+t.getId()+"/"+t.getDesignation()+"/"+t.getNbrePointsRetires();
////        
////        req.setUrl(url);
////        req.addResponseListener(new ActionListener<NetworkEvent>(){
////            @Override
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
//    
//    
//    public boolean deletePenalite(Penalite t) {
//        String url =Statics.BASE_URL+"/deletePenalite/"+t.getId();
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
//    
//    
//    
//    
//    public ArrayList<Penalite> parsePenalite(String jsonText){
//        try {
//            Penalite =new ArrayList<>();
//            JSONParser j = new JSONParser();
//            
//            Map<String,Object> PenaliteListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//            
//            List<Map<String,Object>> list = (List<Map<String,Object>>)PenaliteListJson.get("root");
//            
//    
//            for(Map<String,Object> obj : list){
//           
//                Penalite p = new Penalite();
//                float id = Float.parseFloat(obj.get("id").toString());
//                p.setId((int)id);
//                p.setDesignation(obj.get("designation").toString());
//             
//              p.setNbrePointsRetires((int)Float.parseFloat(obj.get("NbrePointsRetires").toString()));
//                
//                Penalite.add(p);
//            }
//            
//            
//        } catch (IOException ex) {
//            
//        }
//       
//        return Penalite;
//    }
//    
//    
//    public ArrayList<Penalite> getAllPenalite(){
//        String url = Statics.BASE_URL+"/AllPenalite";
//        req.setUrl(url);
//        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//               Penalite = parsePenalite(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//        NetworkManager.getInstance().addToQueueAndWait(req);
//        return Penalite;
//    }
//
//}
//
//    
////     public ArrayList<Penalite> Penalite;
////    public static ServicePenalite instance;
////    public boolean resultOK;
////    private ConnectionRequest req;
////    
////    
////    public ServicePenalite(){
////         req=new ConnectionRequest();
////    }
////    public static ServicePenalite getInstance(){
////        if(instance==null){
////            instance =new ServicePenalite();
////        }return instance;
////    }
////    public boolean addPenalite(Penalite p){
////       String url =Statics.BASE_URL+"/AddPenalite/"+p.getDesignation()+"/"+p.getNbrePointsRetires();
////         
////       
////         req.setUrl(url);
////        req.addResponseListener(new ActionListener<NetworkEvent>(){
////           @Override
////           public void actionPerformed(NetworkEvent evt) {
////              resultOK=req.getResponseCode()==200;
////              req.removeResponseListener(this);
////           }
////        
////        });
////         
////         NetworkManager.getInstance().addToQueueAndWait(req);
////        return resultOK;
////    }
////    
////    public ArrayList<Penalite> parsePenalite(String jsonText){
////        try {
////            Penalite=new ArrayList<>();
////            JSONParser j=new JSONParser();
////            Map<String,Object> PenaliteListJson=j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
////                List<Map<String,Object>> list = (List<Map<String,Object>>)PenaliteListJson.get("root");
////               for(Map<String,Object> obj : list){
////                Penalite p=new Penalite();
////                float id =Float.parseFloat(obj.get("id").toString());
////                p.setId((int)id);
////                p.setDesignation((obj.get("Designation").toString()));
////                p.setNbrePointsRetires((int)Float.parseFloat(obj.get("NbrePointsRetires").toString()));
////  
////               Penalite.add(p);
////                
////            }
////           
////        } catch (IOException ex) {
////            
////        }
////         return Penalite;
////    }
////
////       public ArrayList<Penalite> getAllPenalite(){
////        String url = Statics.BASE_URL+"/AllPenalite";
////        req.setUrl(url);
////        req.setPost(false);
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                Penalite = parsePenalite(new String(req.getResponseData()));
//                req.removeResponseListener(this);
//            }
//        });
//       NetworkManager.getInstance().addToQueueAndWait(req);
//        return Penalite;
//    }
//    

}