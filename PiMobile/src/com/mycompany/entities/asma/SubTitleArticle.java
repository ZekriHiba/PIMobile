/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.asma;

public class SubTitleArticle {
   private static  Article article=new Article();
   
   private int subTitle_Id;
   private int aricle_ID;
   private String title_st;
   private String content;
   private String image;

    public SubTitleArticle() {
    }

    public SubTitleArticle(int aricle_ID, String title_st, String content, String Image) {
        this.subTitle_Id=subTitle_Id;
        this.aricle_ID = aricle_ID;
        this.title_st = title_st;
        this.content = content;
        this.image = image;
    }

    public int getAricle_ID() {
        return aricle_ID;
    }

    public void setAricle_ID(int aricle_ID) {
        this.aricle_ID = aricle_ID;
    }

    public String getTitle_st() {
        return title_st;
    }

    public void setTitle_st(String title_st) {
        this.title_st = title_st;
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

    public void setImage(String image) {
        this.image = image;
    }


    public int getSubTitle_Id() {
        return subTitle_Id;
    }

    public void setSubTitle_Id(int subTitle_Id) {
        this.subTitle_Id = subTitle_Id;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    @Override
    public String toString() {
        return "SubTitleArticle{" + "article=" + article + ", subTitle_Id=" + subTitle_Id + ", aricle_ID=" + aricle_ID + ", title_st=" + title_st + ", content=" + content + ", image=" + image + '}';
    }

    

   

   
   
   
   
   

    
    
    
}
