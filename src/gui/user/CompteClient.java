/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.components.FloatingHint;
import static com.codename1.push.PushContent.get;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.MyApplication;
import entities.Utilisateur;
import gui.Equipe.AddEquipeForm;

/**
 *
 * @author sahar
 */
public class CompteClient extends Form{
    Utilisateur utilisateur=new Utilisateur();
    
 
    public CompteClient(Resources res){
        
        Toolbar tb =new Toolbar(true);
        setToolbar(tb);
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
        setTitle("Acceuil");
        Image icon = res.getImage("joueur.png");
      Container topBar = BorderLayout.centerCenter(new Label(icon));
       Label l= new Label("Bonjour mr le joueur");
      
      topBar.add(BorderLayout.SOUTH,l);
      tb.addComponentToSideMenu(topBar);
        
       tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
             HomeForm h=  new HomeForm(res);

        h.setUtilisateur(getUtilisateur());
                        h.show();
        }); 
        tb.addMaterialCommandToSideMenu("Equipe", FontImage.MATERIAL_GROUP, e -> {
        AddEquipeForm h=  new AddEquipeForm(res);

        h.setUser(getUtilisateur());
                        h.show();});
        tb.addMaterialCommandToSideMenu("Réservations", FontImage.MATERIAL_BOOKMARK_OUTLINE, e -> {});
        tb.addMaterialCommandToSideMenu("Competition", FontImage.MATERIAL_EMOJI_EVENTS, e -> {});
        tb.addMaterialCommandToSideMenu("Store", FontImage.MATERIAL_ADD_SHOPPING_CART, e -> {});
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_ACCOUNT_CIRCLE, e -> {CompteClient h=  new CompteClient(res);
                       h.setUtilisateur(getUtilisateur(),res);
                        h.show();});

        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOGOUT, e -> {
            Authentification h=  new Authentification(res);
             
            
            
            h.show();});

        
        
       
        
    }

   
    
    
    public void addButton(Utilisateur user,Resources res){
        

         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
       
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));
         add (new Label(""));


       
         GridBagLayout gb = new GridBagLayout();

      GridBagConstraints gbc = new GridBagConstraints();
    
         
        
     TextField email =new TextField(user.getEmail(),"",20,TextField.EMAILADDR);
     email.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(email);
        
        
     TextField pwd =new TextField(user.getPwd(),"",20,TextField.PASSWORD);
     pwd.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(pwd);
        
      Button b1=new Button("Modifier mot de passe");
        add(b1);
         b1.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                
               ModifMdp h=  new ModifMdp(res);
                       h.setUser(getUtilisateur(),res);
                        h.show();



             }
            
        });
        
        
        
        
        
     TextField nom =new TextField(user.getNom(),"");
     nom.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(nom);
     
    
     
     
   
     TextField prenom =new TextField(user.getPrenom(),"");
     prenom.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(prenom);
        
        
          TextField tel =new TextField(user.getTel(),"",20,TextField.PHONENUMBER);
     tel.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(tel);
        
        /*String des=user.getCategorie().getDesignation();
        
        TextField cat =new TextField("",des,20,TextField.ANY);
     tel.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(des);
         */
        
        
         TextField position =new TextField(user.getPosition(),"");
     position.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(position);
        
        
         /* TextField categorie =new TextField("",user.getCategorie().getDesignation());
     categorie.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(categorie);
        
        
          TextField equipe =new TextField("",user.getEquipe().getNom());
     equipe.setEditable(false);
     
        //add(new  FloatingHint(nom));
        add(equipe);
        */
        
        
      
        Button b2=new Button("Modifier information");
        add(b2);
        b2.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                
               ModifierInfo h=  new ModifierInfo(res);
                       h.setUtilisateur(getUtilisateur(),res);
                        h.show();



             }
            
        });
        
        
        
        Button b3=new Button("Retour");
        add(b3);
        
        
     b3.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                
               HomeForm h=  new HomeForm(res);
                       h.setUtilisateur(getUtilisateur());
                        h.show();



             }
            
        });
     
      
     
     
     
     
     
     
     

     
    }
    

    public void setUtilisateur(Utilisateur utilisateur ,Resources res) {
        this.utilisateur = utilisateur;
        setTitle(" Welcome, "+utilisateur.getNom()); 
        setLayout(BoxLayout.y());
        addButton(utilisateur,res);

    }
    
     public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

  
    
}
