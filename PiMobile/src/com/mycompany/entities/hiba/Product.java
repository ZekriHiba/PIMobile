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
public class Product {
    
    int id_product;
    String name;
    String img;
    String description;
    float price;
    String type;
    int quantity;
    

    public Product() {
    }
    public Product(int id_product) {
        this.id_product = id_product;
    }

    public Product(int id_product, String name, String img, String description, float price, String type) {
        this.id_product = id_product;
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.type = type;
    }
    public Product(int id_product, String name, String img, String description, float price, String type,int quantity) {
        this.id_product = id_product;
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.type = type;
        this.quantity=quantity;
    }
    
    public Product(String name, String img, String description, float price, String type) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.type = type;
    }
     public Product(String name, String img, String description, float price, String type,int quantity) {
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.type = type;
        this.quantity=quantity;
    }

     
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

     
    public String getType() {
        return type;
    }

    public int getId_product() {
        return id_product;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public float getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    public void setId_product(int id_product) {
        this.id_product = id_product;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
       return "                "+name+"\n                "+price+"DT         quantity:"+ quantity;
    }
    
    
    
    

    
    
   
    
}
