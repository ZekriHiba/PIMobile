/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.hiba;

/**
 *
 * @author Hiba
 */
public class Rating {
    int id_user;
    int rate;
    int id_product;

    public Rating() {
    }

    public Rating(int id_user, int rate, int id_product) {
        this.id_user = id_user;
        this.rate = rate;
        this.id_product = id_product;
    }

    public int getId_product() {
        return id_product;
    }

    public int getId_user() {
        return id_user;
    }

    public int getRate() {
        return rate;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
    
    
}
