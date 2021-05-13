/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Equipe;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

/**
 *
 * @author fachr
 */
public class ListRequestForm extends Form{
    
    public ListRequestForm(Form previous){
         setTitle("Demande Equipe");
       
        
      
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack()); 
    }
    
    
}
