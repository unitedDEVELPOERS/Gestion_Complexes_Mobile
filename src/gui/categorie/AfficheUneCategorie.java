/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.categorie;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Form;
import entities.Categorie;
import services.ServiceCategorie;

/**
 *
 * @author sahar
 */
public class AfficheUneCategorie  extends Form{
    Categorie categorie=new Categorie(1,"Football");
    public AfficheUneCategorie(){
    setTitle("Gestion Categorie");
         SpanLabel sp = new SpanLabel();
        sp.setText(ServiceCategorie.getInstance().AfficheCat(1).toString());
        add(sp);
    
}
}
