/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import java.util.ArrayList;
import services.ServiceCategorie;
import services.ServicesEquipe;

/**
 *
 * @author sahar
 */
public class ListCategorie extends Form{
     public ListCategorie(){
        setTitle("List Categorie");
       
        
        SpanLabel sp = new SpanLabel();
        ArrayList array=ServiceCategorie.getInstance().getAllCategorie();
        sp.setText(array.toString());
        add(sp);
       
    }
}
