/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.categorie;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import entities.Categorie;
import entities.Utilisateur;
import services.ServiceCategorie;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class AjouterCategorie extends Form{
    
    
     public AjouterCategorie(){
         setTitle("Ajouter un arbitre");          
         TextField designation=new TextField("","La designation");
         add(designation);
         
         Button ajouter=new Button("Ajouter");
         Button annuler=new Button("Annuler");
          addAll(ajouter,annuler);
          ajouter.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
                 
                 if(designation.getText().length()==0){
                   Dialog.show("Alert", "please fill all the fields", new Command("ok"));

                 } else
                
                 {
                     try
                     {Categorie e=new Categorie(designation.getText());
                     
                      if (new ServiceCategorie().addCategorie(e)){
                            Dialog.show("Success","Categorie Added", new Command("OK"));
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

}
}