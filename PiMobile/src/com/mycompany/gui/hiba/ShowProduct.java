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
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.hiba.Command_Line;
import com.mycompany.entities.hiba.Order;
import com.mycompany.entities.hiba.Panier;
import com.mycompany.entities.hiba.Product;
import com.mycompany.services.hiba.ServiceProduct;

import java.io.IOException;
import java.util.ArrayList;




/**
 *
 * @author Hiba
 */
public class ShowProduct {
    Form  f;

    public ShowProduct(int id)  {
        f=new Form("");
        
        //*******************************Recuperer le produit selectionné*************************************************
       
        ServiceProduct sp1=new ServiceProduct();
        ArrayList<Product> list=sp1.showProduct(id);
   
   for(Product p : list){
        Container c1=new Container(BoxLayout.x());
         Container c2=new Container(BoxLayout.y());
         Container c3=new Container();
         
         c1.getStyle().setMargin(20, 20, 1, 1);
         
         c3.getStyle().setBorder(Border.createLineBorder(2,"Description"));
         c3.getStyle().setMargin(20, 20, 1, 1);
        //*******************************Les elements du container*********************************************************
        ImageViewer iv=new ImageViewer();
        
            try {
                iv.setImage(Image.createImage("/"+ p.getImg()).scaled(200, 200));
            } catch (IOException ex) {
                System.out.println("erreur");
            }
            
       
        Button b=new Button("add cart");
        SpanLabel l=new SpanLabel(p.getDescription());
        l.getStyle().setTextDecoration(0);
       // l.getStyle().setFont(Font.getFont(""));
         
        //*********************************Action sur le bouton*************************************************************
         b.addActionListener(e->{
             Panier panier= Panier.getInstance();
             Order o=new Order();
             Command_Line com=new Command_Line(p.getId_product(),1,o,p);
             panier.addLine(com);
             
          Cart cart=new Cart();
          cart.getF().show();
        });
         
         
         
         
         f.add(new SpanLabel(p.getName()));
        
        
        Label lb=new Label("h");
        lb.setVisible(false);
        c2.add(lb);
        c2.add(new Label("$"+Float.toString(p.getPrice())));
        c2.add(b);
        c1.add(iv);
        c1.add(c2);
        c3.add(l);
        
        f.add(c1);
        f.add(c3);
    }
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
}
