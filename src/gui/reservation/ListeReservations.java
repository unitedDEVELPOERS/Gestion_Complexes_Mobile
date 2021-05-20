/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.reservation;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.sun.mail.smtp.SMTPTransport;
import entities.Reservation;
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
import services.ServiceReservation;


/**
 *
 * @author ahmed
 */
public class ListeReservations extends Form{
    private Resources theme;
    boolean resultOK;
    
    public ListeReservations(Form previous){
        
        theme = UIManager.initFirstTheme("/theme");
         setTitle("Liste des terrains"); 
         setLayout(BoxLayout.y());
         
        ArrayList<Reservation> res = new ArrayList<>();
        res=ServiceReservation.getInstance().getAllReservations();
        for (Reservation r : res)
        {          
            add(addItemReservation(r));
        }
    }
    
    public Container addItemReservation(Reservation r){
        Container cnt = new Container(BoxLayout.y());
        Container cnt1 = new Container(BoxLayout.x());
        Container cnt2 = new Container(BoxLayout.xRight());
       
        

Label lbDate = new Label("Le  "+r.getDate_reservation().substring(0, 10) +" à "+ r.getHeure().substring(11, 16));
lbDate.getAllStyles().setFgColor(CENTER);

Button btnConf = new Button("Confirmer");
        cnt1.add(lbDate);
        if(!r.isValidee()){
            cnt2.add(btnConf);       
            cnt1.add(cnt2);
            
        }
        cnt.add(cnt1);
        
        btnConf.addActionListener((e)->{
         if( ServiceReservation.getInstance().confirmer(r))
                      {
                            Dialog.show("Succes","Réservation confirmée",new Command("OK"));
             try {
                 sendMail("ahmedhajsaid@gmail.com");
             } catch (Exception ex) {
                
             }
             
             this.revalidate();
                      }
                            else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
            
        });
       
        return cnt;
    }
    
    
    

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
            message.setSubject("Réservation confirmée");
            String htmlCode = "<h1> Votre réservation de notre terrain est confirmée.</h1>"
                    + "<h3>Bienvenue chez nous :)</h3>";           
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            
        }
        return null;
    }


    
    
    
}
