package entities;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sahar
 */
public class Utilisateur {
    int id;
    String nom;
    String prenom;
    Categorie categorie;
    Equipe equipe;
    String email;
    String roles;
    String pwd;
    String raisonSociale;
    String matriculeFiscale;
    int soldePoint;
    String position;
    String tel;
    int positionEquipe;
    boolean isVerified;

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getMatriculeFiscale() {
        return matriculeFiscale;
    }

    public void setMatriculeFiscale(String matriculeFiscale) {
        this.matriculeFiscale = matriculeFiscale;
    }

    public int getSoldePoint() {
        return soldePoint;
    }

    public void setSoldePoint(int soldePoint) {
        this.soldePoint = soldePoint;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getPositionEquipe() {
        return positionEquipe;
    }

    public void setPositionEquipe(int positionEquipe) {
        this.positionEquipe = positionEquipe;
    }
     public boolean isIsVerified() {
        return isVerified;
    }

    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    
    public Utilisateur(){
        
    }
    
    public Utilisateur(int id,String email,String nom,String prenom,String position,String tel){
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
       this.position=position;
       this.tel=tel;
       this.email=email;

    }
    //client
    public Utilisateur(int id,String email,String pwd,String nom,String prenom,String position,String tel){
        this.id=id;
        this.email=email;
        this.pwd=pwd;
        this.nom=nom;
        this.prenom=prenom;
       this.position=position;
       this.tel=tel;
     

    }
    //inscrit client
    public Utilisateur(String email,String pwd,String nom,String prenom,String position,String tel){
        
        this.email=email;
        this.pwd=pwd;
        this.nom=nom;
        this.prenom=prenom;
       this.position=position;
       this.tel=tel;
     

    }
    
    //prop
     public Utilisateur(int id,String email,String raisonSociale,String matriculeFiscale,String tel){
        this.id=id;
        this.email=email;
        this.raisonSociale=raisonSociale;
        this.matriculeFiscale=matriculeFiscale;
        this.tel=tel;
     

    }//gestion prop
      public Utilisateur(String email,String raisonSociale,String matriculeFiscale,String tel){
 
        this.email=email;
        this.raisonSociale=raisonSociale;
        this.matriculeFiscale=matriculeFiscale;
        this.tel=tel;
     

    }
      //inscrit prop
        public Utilisateur(String email,String pwd,String raisonSociale,String matriculeFiscale,String tel){
 
        this.email=email;
         this.pwd=pwd;
        this.raisonSociale=raisonSociale;
        this.matriculeFiscale=matriculeFiscale;
        this.tel=tel;
     

    }
        //gestion arbitre
         public Utilisateur(String email,String nom,String prenom,Categorie categorie,String tel,String raisonSociale){
        
        this.email=email;
       
        this.nom=nom;
        this.prenom=prenom;
       this.position=position;
       this.tel=tel;
     

    }
         
         
         public Utilisateur(String email,String pwd,String nom,String prenom,Categorie categorie,String tel,String raisonSociale){
        
        this.email=email;
         this.pwd=pwd;
        this.nom=nom;
        this.prenom=prenom;
       this.position=position;
       this.tel=tel;
     

    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + '}';
    }
         
      
      
    
    
   
    
    
    
    
    
}
