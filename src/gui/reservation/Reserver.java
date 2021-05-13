/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

/**
 *
 * @author ahmed
 */
public class Reserver extends Form {
    public Reserver(Form previous){
        setTitle("Réserver un terrain"); 
        setLayout(BoxLayout.y());
        Picker date = new Picker();
        date.setType(Display.PICKER_TYPE_CALENDAR);
        Picker heure = new Picker();               
        heure.setType(Display.PICKER_TYPE_TIME);
        
        Button btnReserv = new Button("Réserver");
        
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
               
        addAll(date, heure, btnReserv);
    }
    
}
