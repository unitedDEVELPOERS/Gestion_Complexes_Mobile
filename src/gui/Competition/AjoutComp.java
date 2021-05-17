/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Competition;

import com.codename1.components.FloatingHint;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.SimpleDateFormat;
import gui.user.*;
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
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import static com.sun.webkit.graphics.WCImage.getImage;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import entities.Competition;

import entities.Utilisateur;
import gui.categorie.GestionCategorie;

import java.util.ArrayList;
import services.ServiceUsers;
import services.ServiceCompetition;


/**
 *
 * @author sahar
 */
public class AjoutComp extends Form {
    Competition competition=new Competition();
  Form current;
    public AjoutComp(Resources res){
         current=this;
         setTitle("COMPETITION");   
         
         Toolbar tb=new Toolbar(true);
         setToolbar(tb);
         getTitleArea().setUIID("container");
         setTitle("ajout competition");
         getContentPane().setScrollVisible(false);
         
         tb.addSearchCommand(e -> {
         
         
         });
         Tabs swipe=new Tabs();
         
         Label s1=new Label();
         Label s2=new Label();
         
//         addTab(swipe,s1,res.getImage("prop.png"),"","",res);
//         //
//         
//         
//           swipe.setUIID("Container");
//        swipe.getContentPane().setUIID("Container");
//        swipe.hideTabs();
//
//        ButtonGroup bg = new ButtonGroup();
//        int size = Display.getInstance().convertToPixels(1);
//        Image unselectedWalkthru = Image.createImage(size, size, 0);
//        Graphics g = unselectedWalkthru.getGraphics();
//        g.setColor(0xffffff);
//        g.setAlpha(100);
//        g.setAntiAliased(true);
//        g.fillArc(0, 0, size, size, 0, 360);
//        Image selectedWalkthru = Image.createImage(size, size, 0);
//        g = selectedWalkthru.getGraphics();
//        g.setColor(0xffffff);
//        g.setAntiAliased(true);
//        g.fillArc(0, 0, size, size, 0, 360);
//        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
//        FlowLayout flow = new FlowLayout(CENTER);
//        flow.setValign(BOTTOM);
//        Container radioContainer = new Container(flow);
//        for (int iter = 0; iter < rbs.length; iter++) {
//            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
//            rbs[iter].setPressedIcon(selectedWalkthru);
//            rbs[iter].setUIID("Label");
//            radioContainer.add(rbs[iter]);
//        }
//
//        rbs[0].setSelected(true);
//        swipe.addSelectionListener((i, ii) -> {
//            if (!rbs[ii].isSelected()) {
//                rbs[ii].setSelected(true);
//            }
//        });
//
//        Component.setSameSize(radioContainer, s1, s2);
//        add(LayeredLayout.encloseIn(swipe, radioContainer));
//
//        ButtonGroup barGroup = new ButtonGroup();
//        RadioButton mesListes = RadioButton.createToggle("Mes Reclamations", barGroup);
//        mesListes.setUIID("SelectBar");
//        RadioButton liste = RadioButton.createToggle("Autres", barGroup);
//        liste.setUIID("SelectBar");
//        RadioButton partage = RadioButton.createToggle("Reclamer", barGroup);
//        partage.setUIID("SelectBar");
//        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");
//
//
//        mesListes.addActionListener((e) -> {
//               InfiniteProgress ip = new InfiniteProgress();
//        final Dialog ipDlg = ip.showInifiniteBlocking();
//        
//        //  ListReclamationForm a = new ListReclamationForm(res);
//          //  a.show();
//            refreshTheme();
//        });
//
//        add(LayeredLayout.encloseIn(
//                GridLayout.encloseIn(3, mesListes, liste, partage),
//                FlowLayout.encloseBottom(arrow)
//        ));
//
//        partage.setSelected(true);
//        arrow.setVisible(false);
//        addShowListener(e -> {
//            arrow.setVisible(true);
//            updateArrowPosition(partage, arrow);
//        });
//        bindButtonSelection(mesListes, arrow);
//        bindButtonSelection(liste, arrow);
//        bindButtonSelection(partage, arrow);
//        // special case for rotation
//        addOrientationListener(e -> {
//            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
//        });
//
//       
         
         
         //
         add(new Label("Desgniation"));
         TextField des=new TextField("","Entrer desgniation ");
          add(des);
          
        
         add(new Label("Date debut"));
         
                 setLayout(BoxLayout.y());

         String formatter="mm-dd-yyyy";
          SimpleDateFormat sd=new SimpleDateFormat(formatter);
         
         Picker dd = new Picker();
        dd.setType(Display.PICKER_TYPE_CALENDAR);
        dd.setFormatter(sd);
        
//        
//         TextField dd=new TextField("","Entrer date");
//          add(dd);
          
         add(new Label("Nombre des Equipes"));
         TextField neq=new TextField("","Entrer nombre des equipes");
          add(neq);
          
          
         add(new Label("Prix du Participation"));
         TextField pp=new TextField("","PRIX");
          add(pp);
         
       
         
         addAll(dd);
         Button ajouter=new Button("Ajouter");
         Button annuler=new Button("Annuler");
         addAll(ajouter,annuler);
         
         ajouter.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent evt) {
         if((des.getText().length()==0)||(dd.getText().length()==0)||(neq.getText().length()==0)||(pp.getText().length()==0)){
           
             Dialog.show("Alert", "please fill all the fields", new Command("ok"));

         } else{
             try{  
                  

        
                      Competition e=new Competition(des.getText(),dd.getText(),neq.getText(),pp.getText());
              
                      if (new ServiceCompetition().addCompetition(e)){
                            Dialog.show("Success","COMPETITION Added ", new Command("OK"));
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
          getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->current.showBack());

    }

//    private void addTab(Tabs swipe,Label spacer, Image image, String string, String text, Resources res) {
//
//      int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
//      
//      if(image.getHeight()<size){
//      image = image.scaledHeight(size);
//      }
//     
//      if(image.getHeight() > Display.getInstance().getDisplayHeight() /2 ) {
//      
//      image = image.scaledHeight(Display.getInstance().getDisplayHeight() /2);
//            }
//      ScaleImageLabel imageScale= new ScaleImageLabel(image);
//      imageScale.setUIID("Container");
//      imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//      
//      Label overLay = new Label("","ImageOverlay");
//      
//      
//      
//      Container page1=
//              LayeredLayout.encloseIn(imageScale,
//                              overLay,
//                              BorderLayout.south(BoxLayout.encloseY(
//                                      
//                                      new SpanLabel(text,"LargeWhitrText"),
//                                              FlowLayout.encloseIn(null),
//                                              spacer
//                                      
//                                      
//                                      )
//                              )
//                              
//              );
//      
//        swipe.addTab("",res.getImage("prop.png"),page1);
//    }
//
//   public void bindButtonSelection(Button btn,Label L){
//   
//   
//   btn.addActionListener(e->{
//           if(btn.isSelected()){
//           
//           
//               updateArrowPosition(btn,L);
//                         
//           }
//           
//           
//   });
//   
//   
//   
//   }
//
//    private void updateArrowPosition(Button btn, Label l) {
//
//
//
//      l.getUnselectedStyle().setMargin(LEFT,btn.getX() + btn.getWidth()/ 2 - l.getWidth()/ 2);
//      l.getParent().repaint();
//
//    }
//
//   
    
    
}
