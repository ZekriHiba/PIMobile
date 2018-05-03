/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.tayssir;

/**
 *
 * @author tay
 */
public class Rdv {
    
    private int id;
    
    private int vet_id;
    private int user_id;
    
    private String date ;
    private String heure;

    public Rdv(int id, int vet_id, int user_id, String date, String heure) {
        this.id = id;
        this.vet_id = vet_id;
        this.user_id = user_id;
        this.date = date;
        this.heure = heure;
    }

    public Rdv() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVet_id() {
        return vet_id;
    }

    public void setVet_id(int vet_id) {
        this.vet_id = vet_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }
    
    
    
    
    
}
