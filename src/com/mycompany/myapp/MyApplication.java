package com.mycompany.myapp;


import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import static com.codename1.ui.CN.*;

import com.codename1.ui.Form;
import com.codename1.ui.Dialog;

import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;

import com.codename1.io.NetworkManager;
import gui.Equipe.EquipeForm;
import gui.Equipe.ListEquipeForm;
import gui.Penalite.AjouterPenalite;
import gui.Penalite.ListePenalite;
import gui.categorie.AfficheUneCategorie;
import gui.categorie.AjouterCategorie;
import gui.categorie.GestionCategorie;
import gui.user.AfficheUser;
import gui.user.Authentification;
import gui.user.CompteClient;
import gui.user.HomeAdmin;
import gui.user.HomeArbitre;
import gui.user.HomeForm;
import gui.user.HomeProp;
import gui.user.Inscription;
import gui.user.ListCategorie;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Hashtable;

/**
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */
public class MyApplication {

    private Form current;
    private Resources theme;

   

    public void init(Object context) {
        // use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

        // Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
            // prevent the event from propagating
            err.consume();
            if(err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });        
    }
    
    public void start() {
          
     new Authentification(theme).show();
    // new ListePenalite().show();
   // new AjouterPenalite().show();
  
    }

    public void stop() {
        current = getCurrentForm();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = getCurrentForm();
        }
    }
    
    public void destroy() {
    }
 
}
