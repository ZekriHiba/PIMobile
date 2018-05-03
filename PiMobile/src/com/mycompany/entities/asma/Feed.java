/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.asma;



public class Feed {
    
    private String title;
    private String subject;
    private String content;
    private String image;
    private String comment;
    

    public Feed() { 
    }

    public Feed(String title, String subject, String content, String image) {
        this.title = title;
        this.subject = subject;
        this.content = content;
        this.image = image;
    }
   

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String Image) {
        this.image = Image;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Feed{" + "title=" + title + ", subject=" + subject + ", content=" + content + ", image=" + image + ", comment=" + comment + '}';
    }

    
}
