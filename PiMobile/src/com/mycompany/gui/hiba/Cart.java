/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.hiba.Command_Line;
import com.mycompany.entities.hiba.Panier;
import java.io.IOException;



/**
 *
 * @author Hiba
 */
public class Cart {
    Form f;

    public Cart() {
        f=new Form("cart",BoxLayout.y());
        
        
       
        Button b=new Button("back");
        b.addActionListener(e->{
           ShowListProduct sp=new ShowListProduct();
           sp.getF().show();
        });
        f.add(b);
        
        
        //**********************************instanciation du panier********************************************************
        Panier panier=Panier.getInstance();
        
        
        //********************************Parcourir le panier**************************************************************
         ComponentGroup cg=new ComponentGroup();
        for(Command_Line c :panier.p)
        {
            Container c4 =new Container(BoxLayout.x());
            Container c3 =new Container(BoxLayout.y());
            Container c2=new Container(BoxLayout.x());
            Container c1=new Container(BoxLayout.y());
            Container c5=new Container(BoxLayout.y());
          
            
            
        //***************************les elements du containers************************************************************
            ImageViewer iv=new ImageViewer();
            try {
                iv.setImage(Image.createImage("/"+ c.getProduct().getImg()).scaled(80, 80));
            } catch (IOException ex) {
                System.out.println("err");
            }
            
            Button bt=new Button("X");
            
            bt.addActionListener(e->{
               panier.removeLine(c);
               //ShowListProduct sp=new ShowListProduct();
               //sp.getF().show();
               f.refreshTheme();
            });
            //********************les boutons de modif quantite******************************************
            Button b1=new Button("+");
            Button b2=new Button("-");
            bt.getStyle().setPadding(0,0,0,0);
           
            
                
            
            
            //*****************************mettre le bouton X au milieu****************************************************
            Label lb1=new Label(".");
            Label lb2=new Label(".");
            lb1.setVisible(false);
            lb2.setVisible(false);
            c1.add(lb1);
            c1.add(bt);
            c1.add(lb2);
            
            c5.add(b1);
            c5.add(b2);
            
            c4.add(c1);
            c4.add(iv);
            
            c2.add(new Label(Integer.toString(c.getQuantity())));
            c2.add(c5);
            //c2.add(b2);
            
            //c3.add(new SpanLabel(c.getProduct().getName()));
            c3.add(c2);
            
            
            c4.add(c3);
            c4.add(new Label("$"+Float.toString(c.getProduct().getPrice()*c.getQuantity())));
            
            
            
            cg.add(c4);
        }
        f.add(cg);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
