/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Equipe;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.Equipe;
import services.ServicesEquipe;

/**
 *
 * @author fachr
 */
public class AddEquipeForm extends Form {
    public AddEquipeForm(Form previous){
        setTitle("Add Equipe");
        setLayout(BoxLayout.y());
        
        TextField nom =new TextField("","NOM Equipe :");
        TextField nbr=new TextField("","Nombre Joueur :");
        Button valider=new Button("Valider");
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              if (nom.getText().length()==0||nbr.getText().length()==0){
                  Dialog.show("Alert","Please fill all fields", new Command("OK"));
              }else{
                  try{
                      Equipe e=new Equipe( nom.getText(),Integer.parseInt(nbr.getText()));
                      if (new ServicesEquipe().addEquipe(e)){
                            Dialog.show("Success","Equipe Added", new Command("OK"));
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
        
        addAll(nom,nbr,valider);
        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
    }
}
