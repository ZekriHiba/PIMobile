/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;


/**
 *
 * @author Hiba
 */
public class ShowListProduct {

    Form  f; 
 
    
    
    
    
    public ShowListProduct(Image image) {
        f=new Form("Shop",BoxLayout.y());
        
   
        
        
        for(int j=0;j<5;j++)
        {
       Container c2 =new Container(BoxLayout.x());
           for(int i=0;i<3;i++)
           {
               Container c1 =new Container(BoxLayout.y());
               ImageViewer iv=new ImageViewer();
               iv.setImage(image.scaled(100, 100));
               Button b=new Button("hh");
               
               
               
               
               c1.add(iv);
               c1.add(new Label("name "));
               c1.add(new Label("20$"));
               c1.add(b);
               
               b.addActionListener(e->{ 
                    
               
               });
               
               
        
       
               
        c2.add(c1);
       
           }
            f.add(c2);
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
