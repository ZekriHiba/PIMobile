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
public class Article {
    
private int aricle_ID ;
private String video;
private String contenu;
private String title_Article,img;
private int user_ID;
private SubTitleArticle title_st;
private  static SubTitleArticle subtitlearticle=new SubTitleArticle();

    public Article() {
    }

    public Article(int aricle_ID, String title_Article, String img, int user_ID, SubTitleArticle title_st) {
        this.aricle_ID = aricle_ID;
        this.title_Article = title_Article;
        this.img = img;
        this.user_ID = user_ID;
        this.title_st = title_st;
    }

    public int getAricle_ID() {
        return aricle_ID;
    }

    public void setAricle_ID(int aricle_ID) {
        this.aricle_ID = aricle_ID;
    }

   
    public String getTitle_Article() {
        return title_Article;
    }

    public void setTitle_Article(String title_Article) {
        this.title_Article = title_Article;
    }


    public int getUser_ID() {
        return user_ID;
    }

    public SubTitleArticle getTitle_st() {
        return title_st;
    }

    public void setTitle_st(SubTitleArticle title_st) {
        this.title_st = title_st;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public SubTitleArticle getSubtitlearticle() {
        return subtitlearticle;
    }

    public void setSubtitlearticle(SubTitleArticle subtitlearticle) {
        this.subtitlearticle = subtitlearticle;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Override
    public String toString() {
        return "Article{" + "aricle_ID=" + aricle_ID + ", video=" + video + ", contenu=" + contenu + ", title_Article=" + title_Article + ", img=" + img + ", user_ID=" + user_ID + ", title_st=" + title_st + '}';
    }
 
    
    

   
    
    

    

    }


   


