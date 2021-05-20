/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.Penalite;
import com.codename1.capture.Capture;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.sun.mail.smtp.SMTPTransport;
import entities.Penalite;
import entities.Matche;
import entities.Utilisateur;
import gui.user.HomeArbitre;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import services.ServicePenalite;

/**
 *
 * @author bezin
 */
public class AjouterPenalite extends Form{
    int index =1;
     Button email;
       private Resources theme;
     private  Resources res ;
     public boolean resultOk;
   // Utilisateur utilisateur ;
    
    public AjouterPenalite(){
        theme = UIManager.initFirstTheme("/theme");
        
      //  utilisateur = u;
        setTitle("Nouveau Penalite");   
        setLayout(BoxLayout.y());
        
        TextField tfDesignation = new TextField("", "designation");
        TextField tfNbrePointsRetires = new TextField("", "nbrePointsRetires");
         TextField tfComplexe = new TextField("", "Complexe");
       
 
       
    
                

    
        Button btnEnregistrer = new Button("Enregistrer");
        
       // email = new Button("Envoyer Mail");
     
        btnEnregistrer.addActionListener((e)->{
           
                
              Penalite p = new Penalite ( tfDesignation.getText(),Integer.parseInt(tfNbrePointsRetires.getText()));
                 
                      System.out.println(p);
                    
                      if( ServicePenalite.getInstance().addPenalite(p)){
                            Dialog.show("Success","Penalite ajouté avec succes",new Command("OK"));
                                 //sendMail();
                                 try {
                        
                                     
                                     sendMail("bezzine.onsa@gmail.com");
            
                                            
                                 } catch (Exception ex) {
                
             }
                                                
                      }
                      
                      
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                
            
        });
       
    
            

     
       // getToolbar().addMaterialCommandToLeftBar("",FontImage.MATERIAL_ARROW_BACK,e->previous.showBack());
        
        addAll(tfDesignation, tfNbrePointsRetires, btnEnregistrer );
        
                
    }
    
////     public void sendMail(){
////      try{
////             
////         System.out.println("Preparing to send email");
////        Properties properties = new Properties();
////
////        properties.put("mail Transport protocole ", "smtp");
////        properties.put("mail.smtp.host", "smtp.gmail.com");
////        properties.put("mail.smtp.auth", "true");
////        
////        Session session = Session.getInstance(null);
////        MimeMessage msg = new MimeMessage(session);
////
//////        String myAccountEmail = "num.20746081@gmail.com";
//////        String password = "Ahmed20746081";
////             
////
////            msg.setFrom(new InternetAddress("Reintialiastion mot de passe <monemail@domain.com>)"));
////            msg.setRecipients(Message.RecipientType.TO, email.getText().toString());
////            msg.setSubject("Application nom: confirmation du");
////            msg.setSentDate(new Date (System.currentTimeMillis()));
////           String mp ="";
////           String text ="Votre Penalaite est ajouter avec succes ";
////           msg.setText(text);
////         SMTPTransport st=(SMTPTransport)session.getTransport("smtps");
////         st.connect("smtp.gmail",465,"num.20746081@gmail.com","Ahmed20746081");
////           st.sendMessage(msg, msg.getAllRecipients());
////           System.out.println("server response:"+st.getLastServerResponse());
////         }
////         catch(Exception e){
////             e.printStackTrace();
////         
////         }
////     
////     }
    public static void sendMail(String recepient) throws Exception {
        System.out.println("Preparing to send email");
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        String myAccountEmail = "num.20746081@gmail.com";
        String password = "Ahmed20746081";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });

        Message message = prepareMessage(session, myAccountEmail, recepient);

        Transport.send(message);
        System.out.println("Message sent successfully");
    }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Penalite Ajouter avec succes");
            String htmlCode = "<h1> Nouos </h1>"
                    + "<h3>Bienvenue chez nous :)</h3>";           
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            
        }
        return null;
    }
}
