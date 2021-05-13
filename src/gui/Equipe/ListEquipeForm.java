/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Equipe;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import services.ServicesEquipe;

/**
 *
 * @author fachr
 */
public class ListEquipeForm extends Form{
     public ListEquipeForm(Form previous){
        setTitle("List Equipe");
       
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServicesEquipe.getInstance().getAllEquips().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack()); 
       
    }
    
}
