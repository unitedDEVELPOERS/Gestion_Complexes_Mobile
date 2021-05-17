/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.terrain.client;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import entities.Terrain;
import entities.Utilisateur;

/**
 *
 * @author ahmed
 */
public class DetailsTerrain extends Form{
    private Resources theme;
    public DetailsTerrain(Form previous,Terrain t, Utilisateur u){
        
         
        theme = UIManager.initFirstTheme("/theme");
        setTitle("Liste des terrains"); 
        setLayout(BoxLayout.y());
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
         
    
         
         
    }
    
}
