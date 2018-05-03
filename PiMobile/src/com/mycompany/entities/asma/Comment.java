/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.asma;

/**
 *
 * @author User
 */
public class Comment {
    
private int user_ID;
private int feed_ID;
private String corp;

    public Comment() {
    }

    public Comment(int user_ID, int feed_ID, String corp) {
        this.user_ID = user_ID;
        this.feed_ID = feed_ID;
        this.corp = corp;
    }
    
    
    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public int getFeed_ID() {
        return feed_ID;
    }

    public void setFeed_ID(int feed_ID) {
        this.feed_ID = feed_ID;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    @Override
    public String toString() {
        return "Comment{" + "user_ID=" + user_ID + ", feed_ID=" + feed_ID + ", corp=" + corp + '}';
    }
    
    
    
    
}
