/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Competition;

import gui.user.*;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import entities.Competition;
import entities.Utilisateur;
import services.ServiceCompetition;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class CompetitionAJOUT extends Form{
    Form current;
    public CompetitionAJOUT(){
         current=this;
         setTitle("COMPETITION");   
         
          
         add(new Label("Desgniation"));
         TextField des=new TextField("","Entrer desgniation ");
          add(des);
          
         add(new Label("Date debut"));
         TextField dd=new TextField("","Entrer date");
          add(dd);
          
         add(new Label("Nombre des Equipes"));
         TextField neq=new TextField("","Entrer nombre des equipes");
          add(neq);
          
          add(new Label("Categorie"));
         TextField cat=new TextField("","choisi Categeorie");
          add(cat);
         
         add(new Label("Prix du Participation"));
         TextField pp=new TextField("","PRIX");
          add(pp);
         
       
         
        
         Button ajouter=new Button("Ajouter");
         Button annuler=new Button("Annuler");
         addAll(ajouter,annuler);
         
         ajouter.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
         if((des.getText().length()==0)||(dd.getText().length()==0)||(neq.getText().length()==0)||(cat.getText().length()==0)||(pp.getText().length()==0)){
           
             Dialog.show("Alert", "please fill all the fields", new Command("ok"));

         } else{
             try{  
                  

        
                      Competition e=new Competition(des.getText(),dd.getText(),neq.getText(),pp.getText());
              
                      if (new ServiceCompetition().addCompetition(e)){
                            Dialog.show("Success","User Added", new Command("OK"));
                      }else{
                            Dialog.show("ERROR","Server Error", new Command("OK"));
                      }
                      
                  }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
         }

             }
             
         });
           getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->current.showBack());

    }

    public CompetitionAJOUT(Resources theme1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
