/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author ahmed
 */
/*
public class Terrain {
    private int id;
    private String designation;
    private String description;
    private String adresse;
    private String image;

     public Terrain()
     {
         
     }
    
    public Terrain(int id, String designation, String description, String adresse, String image) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
    }
    
    public Terrain(String designation, String description, String adresse, String image) {
   
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Terrain{" + "id=" + id + ", designation=" + designation + ", description=" + description + ", adresse=" + adresse + ", image=" + image + '}';
    }
    
    
}
*/

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entities;
//




/**
 *
 * @author ahmed
 */
public class Terrain {
    private int id;
    private String designation;
    private String description;
    private String adresse;
    private String image;
    private boolean disponible = true;
    private double prix_location;
    private Utilisateur complexe;
    private Categorie categorie;
    private String heure_ouverture;
    private String heure_fermeture;
    private String ville;

   
    
    public Terrain(int id, String des, String desc) {
        this.id = id;
        this.designation=des;
        this.description=desc;
        
    }
    public Terrain(String des, String desc) {
      
        this.designation=des;
        this.description=desc;
        
    }
    
     public Terrain(int id, String des, String adresse, String image) {
        this.id = id;
        this.designation=des;
        this.description=adresse;
        this.image = image;
        
    }

    public Terrain() {
    }
    public Terrain(String designation, String description, String adresse, String image, double prix_location, Utilisateur complexe, Categorie categorie, String heure_ouverture, String heure_fermeture, String ville) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
        this.complexe = complexe;
        this.categorie = categorie;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.ville= ville;
        
    }
    public Terrain(String designation, String description, String adresse, String image, double prix_location, String heure_ouverture, String heure_fermeture, String ville, boolean dispo) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
   
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;
        this.ville= ville;
        this.disponible= dispo;
        
    }
    public Terrain(String designation, String description, String adresse, String image, double prix_location, String ville, boolean dispo, Utilisateur u, Categorie c) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
        this.ville= ville;
        this.disponible = dispo;
        this.complexe = u;
        this.categorie = c;
        
    }
    public Terrain(int id, String designation, String description, String adresse, String image, double prix_location, String ville, boolean dispo, Utilisateur u, Categorie c) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
        this.ville= ville;
        this.disponible = dispo;
        this.complexe = u;
        this.categorie = c;
        
    }
/*
     public Terrain(int id, String designation, String description, String adresse, String image, double prix_location, Utilisateur complexe, Categorie categorie, String heure_ouverture, String heure_fermeture) {
        this.id = id;
        this.designation = designation;
        this.description = description;
        this.adresse = adresse;
        this.image = image;
        this.prix_location = prix_location;
        this.complexe = complexe;
        this.categorie = categorie;
        this.heure_ouverture = heure_ouverture;
        this.heure_fermeture = heure_fermeture;       
    }
*/
    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDescription() {
        return description;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImage() {
        return image;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public double getPrix_location() {
        return prix_location;
    }

    public Utilisateur getComplexe() {
        return complexe;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public String getHeure_ouverture() {
        return heure_ouverture;
    }

    public String getHeure_fermeture() {
        return heure_fermeture;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setPrix_location(double prix_location) {
        this.prix_location = prix_location;
    }

    public void setComplexe(Utilisateur complexe) {
        this.complexe = complexe;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setHeure_ouverture(String heure_ouverture) {
        this.heure_ouverture = heure_ouverture;
    }

    public void setHeure_fermeture(String heure_fermeture) {
        this.heure_fermeture = heure_fermeture;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Terrain other = (Terrain) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Terrain{" + "id=" + id + ", designation=" + designation + ", description=" + description + ", adresse=" + adresse + ", image=" + image + ", disponible=" + disponible + ", prix_location=" + prix_location + ", complexe=" + complexe + ", categorie=" + categorie  +"}";
   
    }
//        return "Terrain{" + "id=" + id + ", designation=" + designation + ", description=" + description + ", adresse=" + adresse + ", image=" + image + ", disponible=" + disponible + ", prix_location=" + prix_location + ", complexe=" + complexe + ", categorie=" + categorie + ", heure_ouverture=" + heure_ouverture + ", heure_fermeture=" + heure_fermeture + ", cree_a=" + cree_a +"}";
//    }

//    public String toString() {
//        return  designation ;
//    }
    
    
    
}

