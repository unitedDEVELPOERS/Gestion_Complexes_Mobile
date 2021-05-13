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
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridBagConstraints;
import com.codename1.ui.layouts.GridBagLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import entities.Equipe;
import entities.Invitation;
import entities.Utilisateur;
import java.util.ArrayList;
import jdk.nashorn.internal.ir.RuntimeNode.Request;
import services.ServiceInvitation;
import services.ServicesEquipe;

/**
 *
 * @author fachr
 */
public class ListEquipeForm extends Form{
    public ArrayList<Equipe> equips;
     public ListEquipeForm(Resources res){
        Toolbar tb =new Toolbar(true);
        setToolbar(tb);
        setTitle("Add Equipe");
        getContentPane().setScrollVisible(false);
       
        tb.addSearchCommand(e->{
        
        });
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
        RadioButton partage = RadioButton.createToggle("List Request", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
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
        
      equips= ServicesEquipe.getInstance().getAllEquips();
      for(int i=0;i<equips.size();i++){
          
          String urlImage="back.jpg";
          Image placeHolder=Image.createImage(120,90);
          EncodedImage enc =EncodedImage.createFromImage(placeHolder, false);
          URLImage urlim= URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);
          
        addButton(urlim,equips.get(i));
         add (new Label(""));
        ScaleImageLabel image =new ScaleImageLabel(urlim);
        Container containerimg=new Container();
        
      image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
      
      }
        
         
        ///getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack()); 
       
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

    private void addButton(Image img,Equipe get) {
        int height=Display.getInstance().convertToPixels(11.5f);
           int width=Display.getInstance().convertToPixels(14f);
           Button image= new Button(img.fill(width, height));
           image.setUIID("Label");
            Button valider=new Button("Envoyer une invitation");
        valider.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent evt) {
           
                  try{
                     Equipe e=new Equipe();
                      e.setId((int)get.getId());
                e.setNbre_joueur((int)get.getNbre_joueur());
                e.setNom(get.getNom());
                Utilisateur u = new Utilisateur();
                u.setId(73);
                Invitation i =new Invitation("request",e,u,0);
                   if (new ServiceInvitation().addInvitation(i)){
                            Dialog.show("Success","Invitation SENDED", new Command("OK"));
                      }else{
                            Dialog.show("ERROR","Server Error", new Command("OK"));
                      }
                  }catch(NumberFormatException e)
                              {
                               Dialog.show("ERROR","FIELD!!", new Command("OK"));
                              }
              }
            
        
        });

      Container cnt    =new Container();
      TextArea ta = new TextArea(get.nom);
      ta.setUIID("Equipe");
      ta.setEditable(false);
      GridBagLayout gb = new GridBagLayout();

      GridBagConstraints gbc = new GridBagConstraints();
   cnt.setLayout(gb);
     gbc.fill = GridBagConstraints.BOTH;
      gbc.weightx = 1;
      gbc.weighty = 1;
      gb.setConstraints(ta, gbc); // mise en forme des objets
      gb.setConstraints(valider, gbc);

   cnt.add(ta);
   cnt.add(valider);
      add(cnt);
      
    }
    
}
