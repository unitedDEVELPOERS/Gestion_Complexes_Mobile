package entities;

import java.util.Date;
//import java.time.String;


/**
 *
 * @author ahmed
 */
public class Reservation {

    private int id;
    private Date date_creation;
    private String date_reservation;
    private String heure;
    private boolean validee;
    private Utilisateur client;
    private Terrain terrain;
    private double montant;
    private boolean confirmee;
    
    
    public Reservation() {
    }

    public Reservation(String date_reservation, String heure, Utilisateur client, Terrain terrain, double montant) {
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
       
    }
    public Reservation(int id, String date_reservation, String heure,boolean validee, Utilisateur client, Terrain terrain, double montant) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.validee=validee;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
    }
    public Reservation(int id, String date_reservation, String heure,boolean validee, Utilisateur client, Terrain terrain, double montant,boolean confirmee) {
        this.id = id;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.validee=validee;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
        this.confirmee = confirmee;
    }
    public Reservation(String date_reservation, String heure,boolean validee, Utilisateur client, Terrain terrain, double montant) {
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.validee=validee;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
    }
    
    public Reservation(int id,Date date_creation, String date_reservation, String heure, Utilisateur client, Terrain terrain, double montant) {
        this.id = id;
        this.date_creation=date_creation;
        this.date_reservation = date_reservation;
        this.heure = heure;
        this.client = client;
        this.terrain = terrain;
        this.montant = montant;
    }

   

    public int getId() {
        return id;
    }

    public Date getDate_creation() {
        return date_creation;
    }

   
    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    

    public String getDate_reservation() {
        return date_reservation;
    }

    public boolean isValidee() {
        
        return validee;
    }

    public Utilisateur getClient() {
        return client;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public double getMontant() {
        return montant;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public void setDate_reservation(String date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setValidee(boolean validee) {
        this.validee = validee;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public boolean isConfirmee() {
        return confirmee;
    }

    public void setConfirmee(boolean confirmee) {
        this.confirmee = confirmee;
    }
    
    
           

//    @Override
//    public String toString() {
//        return "Reservation{" + "id=" + id + ", date_creation=" + date_creation + ", date_reservation=" + date_reservation +", Heure= "+heure+ ", validee=" + validee + ", client=" + client + ", terrain=" + terrain + ", montant=" + montant + '}';
//    }
    
    
    @Override
    public String toString() {
        return  client.getNom()+" "+client.getPrenom()+" vous invite à un match le " + date_reservation + "\nà "+heure+ " au "+ terrain ;
    }
    
    
    
}
