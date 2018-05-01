/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.Amal;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amalg
 */
public class Species {
   private int id_species;
    private String name;
    List <S_Species> ss= new ArrayList<>(); //ça sera un set 

    public List<S_Species> getSs() {
        return ss;
    }

    public void setSs(List<S_Species> ss) {
        this.ss = ss;
    }
    

    public void Ajouter_sous_catégorie(S_Species s){ss.add(s);}
    public Species() { 
    }

    public Species(int id_species, String name) {
        this.id_species = id_species;
        this.name = name;
    }
    public Species(int id_species) {
        this.id_species = id_species;
    }
    
    public Species( String name) {
        this.name = name;
    }

    public int getId_species() {
        return id_species;
    }

    public String getName() {
        return name;
    }

    public void setId_species(int id_species) {
        this.id_species = id_species;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Species{" + "id_species=" + id_species + ", name=" + name + '}';
    }   
}
