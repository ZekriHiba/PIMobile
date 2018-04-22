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
public class Order {
    private int order_id;
    private float price;
    private String date;
    private User user=new User();
    

    public Order() {
    }
    public Order(int order_id) {
        this.order_id = order_id;
    }

    public Order(float price, String date,User user) {
        
        this.price = price;
        this.date = date;
        this.user=user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
     

    public String getDate() {
        return date;
    }

    public int getOrder_id() {
        return order_id;
    }

    public float getPrice() {
        return price;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "id:"+order_id+"   price:"+price+"   date:"+date;
    }
    
    
    
    
}
