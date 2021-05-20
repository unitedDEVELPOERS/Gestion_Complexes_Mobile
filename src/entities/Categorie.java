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
public class Categorie {
    int id;
    String designation;
    //String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
     
    public Categorie(){
        
    }
    public Categorie(int id,String designation){
        this.id=id;
        this.designation=designation;
    }
    public Categorie(String designation){
    this.designation=designation;

    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", designation=" + designation + '}';
    }
    
    
}

