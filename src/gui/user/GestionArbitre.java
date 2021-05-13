/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.user;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import static java.util.concurrent.ThreadLocalRandom.current;
import services.ServiceUsers;
import services.ServicesEquipe;

/**
 *
 * @author sahar
 */
public class GestionArbitre extends Form {
 Form current;
    public GestionArbitre(Form previous){
        setTitle("Gestion Arbitre");
         SpanLabel sp = new SpanLabel();
        sp.setText(ServiceUsers.getInstance().getAllUsers().toString());
        add(sp);
         getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        Button add=new Button("Ajouter un arbitre");
        add.addActionListener(e->new AddArbitre(current).show());
add(add);
    }
}
