/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.mycompany.services.hiba.ServiceProduct;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.hiba.Command_Line;
import com.mycompany.entities.hiba.Panier;
import com.mycompany.entities.hiba.Product;

import java.io.IOException;



/**
 *
 * @author Hiba
 */
public class Cart {
    Form f;
    private int cmpt;

    public Cart() {
        f=new Form("cart",BoxLayout.y());
        Menu m=new Menu(f);
       
        
       f.getToolbar().addCommandToRightBar("Back", null, e->{
           ShowListProduct sp=new ShowListProduct();
           sp.getF().show();
       });
       
       
       
        Button bpayer=new Button("PROCEED TO CHECKOUT");
        bpayer.addActionListener(e->{
            try {
                Payement p=new Payement();
                p.getF().show();
            } catch (IOException ex) {
                System.out.println("err");
            } 
            
        });
       
       
      
        
        
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
            Label q=new Label(Integer.toString(c.getQuantity()));
            Label lp=new Label("$"+Float.toString(c.getProduct().getPrice()*c.getQuantity()));
            Button bt=new Button("X");
            
            bt.addActionListener(e->{
               panier.removeLine(c);
               c4.remove();
               
               f.revalidate();
               //ShowListProduct sp=new ShowListProduct();
               //sp.getF().show();
               
               
            });
            //********************les boutons de modif quantite******************************************
            Button b1=new Button("+");
            Button b2=new Button("-");
            bt.getStyle().setPadding(0,0,0,0);
           
            b1.addActionListener(e -> {
                cmpt = c.getQuantity();
                 cmpt++;
           ServiceProduct ps=new ServiceProduct();
           Product pfound=ps.searchById(c.getProduct().getId_product());
          if(cmpt<=pfound.getQuantity())
                {
                    
                    c.setQuantity(cmpt);
                    System.out.println("new quantity===>"+c.getQuantity());
                    q.remove();
                    f.revalidate();
                    q.setText(String.valueOf(cmpt));
                    lp.setText("$"+Float.toString(c.getProduct().getPrice()*c.getQuantity()));
                    c2.add(q);
                }
          else
          {
              Dialog.show("Error!","Stock insuffisant!","ok", null);
          }
            });
           b2.addActionListener(e -> {
               
           ServiceProduct ps=new ServiceProduct();
           Product pfound=ps.searchById(c.getProduct().getId_product());
           cmpt = c.getQuantity();
          cmpt--;
                if(cmpt<=0)
                {
                   panier.removeLine(c);
                   c4.remove();
                   f.revalidate();
                }
                else if(cmpt<=pfound.getQuantity())
                {
                    
                    c.setQuantity(cmpt);
                     q.remove();
                    f.revalidate();
                    q.setText(String.valueOf(cmpt));
                    lp.setText("$"+Float.toString(c.getProduct().getPrice()*c.getQuantity()));
                    c2.add(q);
                }
                f.revalidate();
            });
            
            
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
            
            c2.add(c5);
            c2.add(q);
    
            c3.add(c2);
            
            
            c4.add(c3);
            c4.add(lp);
            
            
            
            cg.add(c4);
        }
        f.add(cg);
        f.add(bpayer);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
