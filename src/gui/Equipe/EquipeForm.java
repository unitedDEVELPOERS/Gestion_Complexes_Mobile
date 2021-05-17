/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Equipe;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 *
 * @author fachr
 */
public class EquipeForm extends Form{
    Form current;
    public EquipeForm(){
        current=this;
        setTitle("Equipe");
        setLayout(BoxLayout.y());
        
        add (new Label("Votre Equipe"));
        Button AddEquipe=new Button("ADD Equipe");
        Button ListEquipe=new Button("List Equipe");
        
        AddEquipe.addActionListener(e-> new AddEquipeForm(current).show());
         ListEquipe.addActionListener(e-> new ListEquipeForm(current).show());
         addAll(AddEquipe,ListEquipe);
     
 
        
        
    }
    
}
