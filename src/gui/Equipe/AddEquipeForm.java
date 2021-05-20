/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Equipe;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;

import entities.Equipe;
import entities.Utilisateur;
import gui.user.Authentification;
import gui.user.CompteClient;
import gui.user.HomeForm;

import services.ServicesEquipe;

/**
 *
 * @author fachr
 */
public class AddEquipeForm extends Form {
    public String text;

    public void setUser(Utilisateur user) {
        this.user = user;
    }
        Utilisateur user=new Utilisateur();
    public AddEquipeForm(Resources res){
        Toolbar tb =new Toolbar(true);
        setToolbar(tb);
        setTitle("Add Equipe");
        getContentPane().setScrollVisible(false);
        
         
       tb.addSearchCommand(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
      
             text = (String)e.getSource();
  
  
}  
}); Image icon = res.getImage("joueur.png");
      Container topBar = BorderLayout.centerCenter(new Label(icon));
       Label l= new Label("Bonjour mr le joueur");
       
         topBar.add(BorderLayout.SOUTH,l);
      tb.addComponentToSideMenu(topBar);
        
         tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
             HomeForm h=  new HomeForm(res);

        h.setUtilisateur(getUser());
                        h.show();
        }); 
        tb.addMaterialCommandToSideMenu("Equipe", FontImage.MATERIAL_GROUP, e -> {
        AddEquipeForm h=  new AddEquipeForm(res);

        h.setUser(getUser());
                        h.show();});
        tb.addMaterialCommandToSideMenu("Réservations", FontImage.MATERIAL_BOOKMARK_OUTLINE, e -> {});
        tb.addMaterialCommandToSideMenu("Competition", FontImage.MATERIAL_EMOJI_EVENTS, e -> {});
        tb.addMaterialCommandToSideMenu("Store", FontImage.MATERIAL_ADD_SHOPPING_CART, e -> {});
        tb.addMaterialCommandToSideMenu("Profile", FontImage.MATERIAL_ACCOUNT_CIRCLE, e -> {CompteClient h=  new CompteClient(res);
                       h.setUtilisateur(getUser(),res);
                        h.show();});

        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_LOGOUT, e -> {
            Authentification h=  new Authentification(res);
             
            
            
            h.show();});
       
       
       
       
       
       
         Button Search=new Button("SEARCH");
         Search.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
      
          RechercheEquipeForm a = new RechercheEquipeForm(res,text);
          a.setUser(user);
          a.show();
            refreshTheme();
  
}  
});
           add(Search);
        Tabs swipe= new Tabs();
        Label s1 =new Label();
        Label s2 =new Label();
         addTab(swipe,s1,res.getImage("back.jpg"),"","",res);
        //////////////////////////////////////////////////////
        
          swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Rejoindre", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("Demande", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Request", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");

  partage.addActionListener((e) -> {
       
        
         RequestEquipeForm a = new RequestEquipeForm(res);
            a.setUser(user);
          a.show();
            refreshTheme();
        });
        mesListes.addActionListener((e) -> {
       
        
         ListEquipeForm a = new ListEquipeForm(res);
            a.setUser(user);
          a.show();
            refreshTheme();
        });
          liste.addActionListener((e) -> {
       
        
         DemandeEquipeForm a = new DemandeEquipeForm(res);
            a.setUser(user);
          a.show();
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

       
        
        
        
        
        
        
        
        
        
        
        
        //////////////////////////////////////////////////////////////
        
        setLayout(BoxLayout.y());
        
        TextField nom =new TextField("","NOM Equipe :");
    
        TextField nbr=new TextField("","Nombre Joueur :");
        Button valider=new Button("Valider");
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
              if (nom.getText().length()==0||nbr.getText().length()==0){
                  Dialog.show("Alert","Please fill all fields", new Command("OK"));
              }else{
                  try{
                      Equipe e=new Equipe( nom.getText(),Integer.parseInt(nbr.getText()),user);
                      if (new ServicesEquipe().addEquipe(e)){
                            Dialog.show("Success","Equipe Added", new Command("OK"));
                      }else{
                            Dialog.show("ERROR","Server Error", new Command("OK"));
                      }
                      
                  }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
              }
            }
        
        });
        
        addAll(nom,nbr,valider);
        
 
    }

    private void addTab(Tabs swipe,Label spacer, Image image, String string, String text, Resources res) {
     int size=Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
     
     if(image.getHeight()<size){
         image=image.scaledHeight(size);
     }
      if(image.getHeight()> Display.getInstance().getDisplayHeight()/2){
         image=image.scaledHeight(Display.getInstance().getDisplayHeight()/2);
     }
      
      ScaleImageLabel imageScale=new ScaleImageLabel(image);
      imageScale.setUIID("container");
      imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
      Label overLay=new Label("","ImageOverLay");
      Container page1 = LayeredLayout.encloseIn(
              imageScale,
              overLay,
              BorderLayout.south(
                      BoxLayout.encloseY(
                              new SpanLabel(text,"LargeWhiteText"),
            
              spacer
                      )
      )
              
              );
     swipe.addTab("",res.getImage("back.jpg"),page1);
    }
    public void bindButtonSelection(Button btn ,Label l ){
        btn.addActionListener(e->{
        if(btn.isSelected()){
            updateArrowPosition(btn,l);
        }
            });
    }

    private void updateArrowPosition(Button btn, Label l) {
       l.getUnselectedStyle().setMargin(LEFT, btn.getX()+btn.getWidth()/ 2 - l.getWidth()/2);
       l.getParent().repaint();
    }
    
    public Utilisateur getUser() {
        return user;
    }
}
