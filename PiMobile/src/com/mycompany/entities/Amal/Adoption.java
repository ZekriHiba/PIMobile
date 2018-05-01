/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.Amal;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author amalg
 */
public class Adoption {
  Animal a;
    Users u;
    private Date Date_adoption ;
    private Date Date_expiration;
    Set <Request_Adoption> r= new HashSet<>();

    public Set<Request_Adoption> getR() {
        return r;
    }

    public void setR(Set<Request_Adoption> r) {
        this.r = r;
    }

    
    public Adoption() {
    }

    public Adoption(Users u,Animal a, Date Date_adoption, Date Date_expiration) {
        this.a = a;
        this.u = u;
        this.Date_adoption = Date_adoption;
        this.Date_expiration = Date_expiration;
    }
    public Adoption(Users u,Animal a) {
        this.a = a;
        this.u = u;
    }
    public Adoption(Date Date_adoption ) {
        this.Date_adoption = Date_adoption;
    }
    

    public Animal getA() {
        return a;
    }

    public void setA(Animal a) {
        this.a = a;
    }

    public Users getU() {
        return u;
    }

    public void setU(Users u) {
        this.u = u;
    }

    public Date getDate_adoption() {
        return Date_adoption;
    }

    public void setDate_adoption(Date Date_adoption) {
        this.Date_adoption = Date_adoption;
    }

    public Date getDate_expiration() {
        return Date_expiration;
    }

    public void setDate_expiration(Date Date_expiration) {
        this.Date_expiration = Date_expiration;
    }

    @Override
    public String toString() {
        return "Adoption{" + "a=" + a + ", u=" + u + ", Date_adoption=" + Date_adoption + ", Date_expiration=" + Date_expiration + '}';
    }   
}
