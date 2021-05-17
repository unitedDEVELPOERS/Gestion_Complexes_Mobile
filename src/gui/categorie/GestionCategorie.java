/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.categorie;

import com.codename1.components.SpanLabel;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import entities.Categorie;
import gui.user.AddArbitre;
import services.ServiceCategorie;
import services.ServiceUsers;

/**
 *
 * @author sahar
 */
public class GestionCategorie extends Form {
    
    Form current;
   
    public GestionCategorie(){
        setTitle("Gestion Categorie");
         SpanLabel sp = new SpanLabel();
        sp.setText(ServiceCategorie.getInstance().AfficheCat(3).toString());
        add(sp);
        Button add=new Button("Ajouter une categorie");
         Button supp=new Button("Supprimer une categorie");
           Button upd=new Button("Modifier une categorie");
        add.addActionListener(e->new AddArbitre(current).show());
addAll(add,supp,upd);
   supp.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
          ServiceCategorie s=new ServiceCategorie();
          s.SuppCategorie(8);
            }
       
   });
    upd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
 ServiceCategorie s=new ServiceCategorie();
          //s.UpdateCategorie(categorie);
            }
        
        
    });
}
   
}
