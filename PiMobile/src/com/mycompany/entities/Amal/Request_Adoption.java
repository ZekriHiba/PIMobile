/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.Amal;

import java.util.Date;



/**
 *
 * @author amalg
 */
public class Request_Adoption {
   public enum local{Maison,Appartement};
   public enum place{Exterieur,Dedans};
   public enum carry{Seul,Accompagne};
   private int id_request;
   private Date date_request;
   private boolean raiser;
   private local local;
   private boolean garden;
   private boolean space;
   private place place;
   private carry carry;
   private boolean neighbour;
   private boolean child;
   private boolean time;
   private boolean breed;
   private boolean engagement;
   private boolean habits;
   private boolean charges;
   private boolean ready;
   private boolean sacrifice;
   private boolean familly;
   private String description;
   Adoption adoption;
   Users user;

   public Request_Adoption()
   {
   }
    public Request_Adoption(Adoption adoption,Users user) {this.adoption=adoption;
    this.user=user;
    }

    public Request_Adoption(Users user,Date date_request, 
            boolean raiser,  boolean garden, boolean space, boolean neighbour, boolean child, boolean time, boolean breed,
            boolean engagement, boolean habits, boolean charges, boolean ready, boolean sacrifice,
            boolean familly, String description) {
        this.user = user;
        this.date_request = date_request;
        this.raiser = raiser;
        //this.local = local;
        this.garden = garden;
        this.space = space;
        //this.place = place;
        //this.carry = carry;
        this.neighbour = neighbour;
        this.child = child;
        this.time = time;
        this.breed = breed;
        this.engagement = engagement;
        this.habits = habits;
        this.charges = charges;
        this.ready = ready;
        this.sacrifice = sacrifice;
        this.familly = familly;
        this.description = description;
        this.adoption = adoption;
        this.user = user;
    }
     public Request_Adoption(Adoption adoption, Users user,
            boolean raiser,  boolean garden, boolean space, boolean neighbour, boolean child, boolean time, boolean breed,
            boolean engagement, boolean habits, boolean charges, boolean ready, boolean sacrifice,
            boolean familly, String description) {
        this.raiser = raiser;
        //this.local = local;
        this.garden = garden;
        this.space = space;
        //this.place = place;
        //this.carry = carry;
        this.neighbour = neighbour;
        this.child = child;
        this.time = time;
        this.breed = breed;
        this.engagement = engagement;
        this.habits = habits;
        this.charges = charges;
        this.ready = ready;
        this.sacrifice = sacrifice;
        this.familly = familly;
        this.description = description;
        this.adoption = adoption;
        this.user = user;
    }

    public Request_Adoption(Adoption adoption, Users user,  boolean raiser, local local, boolean garden,
            boolean space, place place, carry carry, boolean neighbour, boolean child, boolean time,
            boolean breed, boolean engagement, boolean habits, boolean charges, boolean ready, boolean sacrifice,
            boolean familly, String description) {
        this.raiser = raiser;
        this.local = local;
        this.garden = garden;
        this.space = space;
        this.place = place;
        this.carry = carry;
        this.neighbour = neighbour;
        this.child = child;
        this.time = time;
        this.breed = breed;
        this.engagement = engagement;
        this.habits = habits;
        this.charges = charges;
        this.ready = ready;
        this.sacrifice = sacrifice;
        this.familly = familly;
        this.description = description;
        this.adoption = adoption;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    

    public Date getDate_request() {
        return date_request;
    }

    public void setDate_request(Date date_request) {
        this.date_request = date_request;
    }

    public boolean isRaiser() {
        return raiser;
    }

    public void setRaiser(boolean raiser) {
        this.raiser = raiser;
    }

    public local getLocal() {
        return local;
    }

    public void setLocal(local local) {
        this.local = local;
    }

    public boolean isGarden() {
        return garden;
    }

    public void setGarden(boolean garden) {
        this.garden = garden;
    }

    public boolean isSpace() {
        return space;
    }

    public void setSpace(boolean space) {
        this.space = space;
    }

    public place getPlace() {
        return place;
    }

    public void setPlace(place place) {
        this.place = place;
    }

    public carry getCarry() {
        return carry;
    }

    public void setCarry(carry carry) {
        this.carry = carry;
    }

    public boolean isNeighbour() {
        return neighbour;
    }

    public void setNeighbour(boolean neighbour) {
        this.neighbour = neighbour;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public boolean isTime() {
        return time;
    }

    public void setTime(boolean time) {
        this.time = time;
    }

    public boolean isBreed() {
        return breed;
    }

    public void setBreed(boolean breed) {
        this.breed = breed;
    }

    public boolean isEngagement() {
        return engagement;
    }

    public void setEngagement(boolean engagement) {
        this.engagement = engagement;
    }

    public boolean isHabits() {
        return habits;
    }

    public void setHabits(boolean habits) {
        this.habits = habits;
    }

    public boolean isCharges() {
        return charges;
    }

    public void setCharges(boolean charges) {
        this.charges = charges;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public boolean isSacrifice() {
        return sacrifice;
    }

    public void setSacrifice(boolean sacrifice) {
        this.sacrifice = sacrifice;
    }

    public boolean isFamilly() {
        return familly;
    }

    public void setFamilly(boolean familly) {
        this.familly = familly;
    }



    public Adoption getAdoption() {
        return adoption;
    }

    public void setAdoption(Adoption adoption) {
        this.adoption = adoption;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    

    

    @Override
    public String toString() {
        
        return "Request_Adoption{  date_request=" + date_request 
                + ", raiser=" + raiser + ", local=" + local + ", garden=" + garden + ", space=" 
                + space + ", place=" + place + ", carry=" + carry + ", neighbour=" + neighbour 
                + ", child=" + child + ", time=" + time + ", breed=" + breed + ", engagement=" 
                + engagement + ", habits=" + habits + ", charges=" + charges + ", ready=" + ready
                + ", sacrifice=" + sacrifice + ", familly=" + familly + ", description=" + description + '}';
    }
  
    
}
