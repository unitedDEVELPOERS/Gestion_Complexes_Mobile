/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *   
 * @author bezin
 */
public class Penalite {
    private int id;
    private String designation;
    private int nbrePointsRetires ;
    private Utilisateur complexe ;

    public Penalite() {
    }

    public Penalite(int id, String designation, int nbrePointsRetires, Utilisateur complexe) {
        this.id = id;
        this.designation = designation;
        this.nbrePointsRetires = nbrePointsRetires;
        this.complexe = complexe;
    }

    public Penalite(int id, String designation, int nbrePointsRetires) {
        this.id = id;
        this.designation = designation;
        this.nbrePointsRetires = nbrePointsRetires;
    }
    

    public Penalite(String designation, int nbrePointsRetires) {
        this.designation = designation;
        this.nbrePointsRetires = nbrePointsRetires;
    }

    public Penalite(String designation, int nbrePointsRetires, Utilisateur complexe) {
        this.designation = designation;
        this.nbrePointsRetires = nbrePointsRetires;
        this.complexe = complexe;
    }
    
    

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

    public int getNbrePointsRetires() {
        return nbrePointsRetires;
    }

    public void setNbrePointsRetires(int nbrePointsRetires) {
        this.nbrePointsRetires = nbrePointsRetires;
    }

    public Utilisateur getComplexe() {
        return complexe;
    }

    public void setComplexe(Utilisateur complexe) {
        this.complexe = complexe;
    }

    @Override
    public String toString() {
        return "Penalite{" + "id=" + id + ", designation=" + designation + ", nbrePointsRetires=" + nbrePointsRetires + ", complexe=" + complexe + '}';
    }

    
    
    
    
}


