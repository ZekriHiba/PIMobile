/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.hiba.Product;
import com.mycompany.entities.hiba.Rating;
import com.mycompany.services.hiba.ServiceProduct;
import com.mycompany.services.hiba.ServiceRating;
import java.io.IOException;
import java.util.ArrayList;






/**
 *
 * @author Hiba
 */
public class ShowListProduct {

    Form  f; 
   // Slider s= null;
 
 
    
    
    
    public ShowListProduct()  {
        f=new Form("Shop",BoxLayout.y());
        Menu m=new Menu(f);
         
         
       f.getToolbar().addMaterialCommandToOverflowMenu("cart",FontImage.MATERIAL_ADD_SHOPPING_CART,(e)->{
        Cart c=new Cart();
        c.getF().show();
        });

        
        //*******************Recuperer la liste de produit de la base***************************************************
        
           ServiceProduct sp1=new ServiceProduct();
           ServiceRating sr=new ServiceRating();
           ArrayList<Product> list=sp1.showList();
           
           
 
           
       //***************************Recherche*******************************************************************       
           f.getToolbar().addSearchCommand(e->{
             
               
               System.out.println(e.getSource());
               Product psearch=sp1.searchByName((String)e.getSource());
               
               System.out.println(psearch);
               if(psearch.getDescription()!=null)
               {
                Container c1 =getContainer(psearch);
       
           
                f.removeAll();
                f.add(c1);
                f.revalidate();
               }
               else
               {
                   f.removeAll();
                   for(Product p : list)
                     {  
                       Container c1=getContainer(p);
                        f.add(c1);
                      }
                   f.revalidate();
               }
           
           });
 
           
     //********************************Parcourir la liste**************************************************************** 
        for(Product p : list)
        {  
              
            Container c1=getContainer(p);
       
           
            f.add(c1);
        }
    }
    
    
    
    
    
    
    
    public Container getContainer(Product p)
    {
        ServiceRating sr=new ServiceRating();
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
               Slider s=createStarRankSlider(0);
              
               s.addActionListener(new ActionListener()
              {
                  @Override
                  public void actionPerformed(ActionEvent evt)
                  {
                     Rating r=new Rating(1,s.getProgress(),p.getId_product());
                     sr.addRate(r);
                     
                  }
              }
              );
           
               Label l1=new Label("$"+Float.toString(p.getPrice()));
             //  l1.getStyle().set(0xC40C0C);
               
               
               
               c1.add(iv);
               c1.add(c3);
               c3.add(new SpanLabel(p.getName()));
               c3.add(l1);
               c3.add(FlowLayout.encloseCenter(s));
               c3.add(b);
               
            //*******************************Action sur le bouton add*****************************************************
               
               b.addActionListener(e->{ 
                    ShowProduct sp=new ShowProduct(p.getId_product());
                    sp.getF().show();
               
               });
    
        return c1;
    }
    
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}
    private Slider createStarRankSlider(int i) {
    Slider starRank = new Slider();
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(5);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    starRank.setProgress(i);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
    return starRank;
}
   

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
