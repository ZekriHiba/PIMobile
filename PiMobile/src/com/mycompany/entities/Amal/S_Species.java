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
public class S_Species {
      private int id_s_species;
    private String name;
    Species s;
    List <Animal> a= new ArrayList<>();

    public List<Animal> getA() {
        return a;
    }

    public void setA(List<Animal> a) {
        this.a = a;
    }
    

    public S_Species() {
    }

    public S_Species(int id_s_species, String name, Species s) {
        this.id_s_species = id_s_species;
        this.name = name;
        this.s = s;
    }

    public S_Species(String name, Species s) {
        this.name = name;
        this.s = s;
    }
    public S_Species( String name) {
        this.name = name;
    }

    public int getId_s_species() {
        return id_s_species;
    }

    public void setId_s_species(int id_s_species) {
        this.id_s_species = id_s_species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Species getS() {
        return s;
    }

    public void setS(Species s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return "S_Species{" + "id_s_species=" + id_s_species + ", name=" + name + ", s=" + s + '}';
    }
}
