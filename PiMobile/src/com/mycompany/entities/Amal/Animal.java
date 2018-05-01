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
public class Animal {
  private int id_animal; 
   private int size;
   private int weight;
   private Date age;
   private String description;
   private String image;
   private int price;
   private  String nick_Name;
   private String color;
   private String gender;
   private String status;
   private int confirmation;
   S_Species s;
    public Animal() {
    }
    

    public Animal( S_Species s, int size, int weight,Date age, String description, String image,
            String nick_Name, String color, String gender) {
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.description = description;
        this.image = image;
        this.nick_Name = nick_Name;
        this.color = color;
        this.gender = gender;
        this.s = s;
    }
    public Animal(int id_animal, S_Species s, int size, int weight,Date age, String description, String image,
            String nick_Name, String color, String gender) {
        this.id_animal = id_animal;
        this.size = size;
        this.weight = weight;
        this.age = age;
        this.description = description;
        this.image = image;
        this.nick_Name = nick_Name;
        this.color = color;
        this.gender = gender;
        this.s = s;
    }

    
    public Animal(String image) {
        this.image = image;
    }
   
    public Animal(int id_animal) {
        this.id_animal = id_animal;
    }
    
    public Animal(int id_animal,String description,String image) {
        this.id_animal = id_animal;
         this.description = description;
         this.image = image;
    }


    public S_Species getS() {
        return s;
    }

    public void setS(S_Species s) {
        this.s = s;
    }

    public Date getAge() {
        return age;
    }

    public void setAge(Date age) {
        this.age = age;
    }

    
    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

   
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage1(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getNick_Name() {
        return nick_Name;
    }

    public void setNick_Name(String nick_Name) {
        this.nick_Name = nick_Name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(int confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Animal{id="+id_animal+"ss"+this.getS() + "size=" + size + ", weight=" + weight 
                + ", description=" + description + ", image=" + image
                + ", price=" + price + ", nick_Name=" + nick_Name + ", color=" 
                + color + ", gender=" + gender + ", status=" + status + ", confirmation=" + confirmation + '}';
    }
   
}
