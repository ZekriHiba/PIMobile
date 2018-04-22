/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.hiba.Product;
import com.mycompany.services.hiba.ServiceProduct;
import java.io.IOException;
import java.util.ArrayList;






/**
 *
 * @author Hiba
 */
public class ShowListProduct {

    Form  f; 
 
    
    
    
    
    public ShowListProduct()  {
        f=new Form("Shop",BoxLayout.y());
     
           //  f.getStyle().setBgColor(0xC40C0C);
           
       
        
        //*******************Recuperer la liste de produit de la base***************************************************
        
           ServiceProduct sp1=new ServiceProduct();
           ArrayList<Product> list=sp1.showList();
   
        
       //********************************Parcourir la liste**************************************************************** 
        for(Product p : list)
        {  
               Container c1 =new Container(BoxLayout.x());
               Container c3 =new Container(BoxLayout.y());
              c1.getStyle().setBorder(Border.createLineBorder(2));
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(20, 20, 0, 0);

               
           
               
        //****************************les elements du containers********************************************************
               
               ImageViewer iv=new ImageViewer();
               
           try {
               iv.setImage(Image.createImage("/"+ p.getImg()).scaled(100, 100));
           } catch (IOException ex) {
                    System.out.println("err");
           }
              
               //Button b=new Button(image2.scaled(30,30));
               Button b=new Button("add");
            
              
           
               Label l1=new Label("$"+Float.toString(p.getPrice()));
             //  l1.getStyle().set(0xC40C0C);
               
               
               
               c1.add(iv);
               c1.add(c3);
               c3.add(new SpanLabel(p.getName()));
               c3.add(l1);
               c3.add(b);
               
            //*******************************Action sur le bouton add*****************************************************
               
               b.addActionListener(e->{ 
                    ShowProduct sp=new ShowProduct(p.getId_product());
                    sp.getF().show();
               
               });
               
       
           
            f.add(c1);
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
