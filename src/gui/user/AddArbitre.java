/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

/**
 *
 * @author sahar
 */
public class AddArbitre extends Form {
    public AddArbitre(Form previous){
         setTitle("Ajouter un arbitre");          
         TextField email=new TextField("","Votre email");
         TextField mdp=new TextField("","Votre mot de passe");
         TextField nom=new TextField("","Votre nom");
         TextField prenom=new TextField("","Votre prénom");
         TextField telephone=new TextField("","Votre telephone");
         Button ajouter=new Button("Ajouter");
         Button annuler=new Button("Annuler");
         addAll(ajouter,annuler);
         addAll(email,mdp,nom,prenom,telephone);

         ajouter.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
         if((nom.getText().length()==0)||(prenom.getText().length()==0)||(email.getText().length()==0)||(mdp.getText().length()==0)||(telephone.getText().length()==0)){
           
             Dialog.show("Alert", "please fill all the fields", new Command("ok"));

         } else
                 Dialog.show("Alert", "Voulez-vous vraiment ajouter cet arbitre?", new Command("Ajouter"),new Command("Annuler"));

             }
             
         });
         getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());

      
    }
}
