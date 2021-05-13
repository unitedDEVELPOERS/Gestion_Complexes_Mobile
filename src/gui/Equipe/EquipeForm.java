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
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 *
 * @author fachr
 */
public class EquipeForm extends Form{
   public Form current;
     public Resources theme;
    public EquipeForm(){
        current=this;
        setTitle("Equipe");
        setLayout(BoxLayout.y());
        
        add (new Label("Votre Equipe"));
        Button AddEquipe=new Button("ADD Equipe");
        Button RejoindreEquipe=new Button("Rejoindre Equipe");
        Button DemandeEquipe=new Button("Demande Equipe");
        Button ListRequest=new Button("List Request");
        

         RejoindreEquipe.addActionListener(e-> new RejoindreEquipeForm(current).show());
        //   DemandeEquipe.addActionListener(e-> new DemandeEquipeForm(current).show());
           ListRequest.addActionListener(e-> new ListRequestForm(current).show());
         addAll(AddEquipe,RejoindreEquipe,DemandeEquipe,ListRequest);
     
 
        
        
    }
    
}
