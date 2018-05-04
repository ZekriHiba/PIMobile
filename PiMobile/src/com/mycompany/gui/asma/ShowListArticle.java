/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.asma;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.asma.Article;
import com.mycompany.services.asma.ServiceArticle;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowListArticle {
    private Form current;
    private TextField nom,prenom;
    private Button valider;
    private Container ctn,ctn2;
    private ImageViewer img;
    private Label titre;
    private EncodedImage encodedImage;
    private Image urlImage;
    private ImageViewer imageviewer;
    private Toolbar tb;
    private Form f,fo;

    public ShowListArticle(Resources theme) {
       
           //  f.getStyle().setBgColor(0xC40C0C);
           
       
        
        //*******************Recuperer la liste de produit de la base***************************************************
           f=new Form("Article",BoxLayout.y());
           ServiceArticle sp1=new ServiceArticle();
           ArrayList<Article> list=sp1.showList();
        int i=0;
       //********************************Parcourir la liste**************************************************************** 
       for(Article a : list)
        {  
            i++;
            Container ctn = new Container(BoxLayout.x());
            
                encodedImage=EncodedImage.createFromImage(theme.getImage("round.png"), false);
                urlImage = URLImage.createToStorage(encodedImage, "bra"+i,"http://localhost"+a.getImg(),URLImage.RESIZE_SCALE_TO_FILL);
                img =new ImageViewer(urlImage); 
                
             /*   img.addPointerDraggedListener(s->{
                         fo = new Form("hello",BoxLayout.y());
                         fo.show();
                         });*/
            ctn.add(img);
            
            titre= new Label(a.getTitle_Article());
            ctn.add(titre);
            
            titre.addPointerPressedListener((e)->{
            ShowDetailArticle sda =new ShowDetailArticle(theme ,a);
             
            sda.getF().show();
        
             });
            ctn.setLeadComponent(titre);
            f.add(ctn);
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    }
    
    
    

