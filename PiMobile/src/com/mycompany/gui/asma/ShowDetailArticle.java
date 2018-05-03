/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.asma;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.asma.Article;

/**
 *
 * @author User
 */
public class ShowDetailArticle {
    
    
    private Form f;
    private Label titre;
    private ImageViewer imageviewer;
    private ImageViewer img;
    private EncodedImage encodedImage;
    private Image urlImage;
    
    public ShowDetailArticle(Resources theme, Article a) {
     
        f=new Form("Detail Article",BoxLayout.y());
        Container ctn = new Container(BoxLayout.x());
         titre= new Label(a.getTitle_Article());
        Container ctn1= new Container(BoxLayout.x());
          encodedImage=EncodedImage.createFromImage(theme.getImage("round.png"), false);
          
          urlImage = URLImage.createToStorage(encodedImage,"tt"+String.valueOf(a.getAricle_ID()),"http://localhost"+a.getImg(),URLImage.RESIZE_SCALE_TO_FILL);
          img =new ImageViewer(urlImage); 
               
          ctn.add(titre);
          ctn1.add(img);
          f.add(ctn);
          f.add(ctn1);
          
          f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), (e)->{
  
          ShowListArticle sla = new ShowListArticle(theme);
          sla.getF().show();
          });

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
