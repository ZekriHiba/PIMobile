/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Amal;

import com.codename1.components.ScaleImageButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.DataChangedListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.entities.Amal.Animal;
import com.mycompany.entities.hiba.Session;
import com.mycompany.services.Amal.AdoptionService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author amalg
 */
public class ShowAdoption {
      Form  f; 
  
    
    public ShowAdoption() throws IOException  {
        
      f=new Form("Adoption",BoxLayout.y());
      f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
      
      
         Session se=new Session();
         int user=se.sessionId;
         
               Style sb = UIManager.getInstance().getComponentStyle("background-color:transparent;");
         
            TextField search = new TextField("", "search");
            search.getStyle().setFgColor(0xffffff);
            f.add(search);
         
        //*******************Recuperer la liste de produit de la base***************************************************
        
           AdoptionService sp1=new AdoptionService();
           ArrayList<Animal> list=sp1.showAdoption(user);
           Container c0 =new Container(GridLayout.autoFit());
        
       //********************************Parcourir la liste**************************************************************** 
        for(Animal a : list)
        {     
               Container c1 =new Container(BoxLayout.y());
               Container c2 =new Container(BoxLayout.x());
               c2.getStyle().setPadding(0,0,10,0);
              c1.getStyle().setBorder(Border.createLineBorder(2));
              Style bb = UIManager.getInstance().getComponentStyle("border-color:white;");
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(5, 5, 0, 0);
              c1.getStyle().merge(bb);
               
        //****************************les elements du containers********************************************************
               
               ScaleImageButton ivv=new ScaleImageButton(Image.createImage("/"+ a.getImage()).scaled(80,150));
               ivv.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
               
               Style s = UIManager.getInstance().getComponentStyle("Button");
               FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_DELETE,s);
               FontImage icon2 = FontImage.createMaterial(FontImage.MATERIAL_EDIT,s);
               Button b =new Button(icon2);
               b.getStyle().merge(sb);
               Button b2 =new Button(icon);
               b2.getStyle().merge(sb);
               Font ff=Font.createTrueTypeFont("fontello", "fontello.ttf");
               FontImage fm = FontImage.createFixed("\ue813",ff, 0xFFFFFF, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
               FontImage fm1 = FontImage.createFixed("\ue812",ff, 0xcc0000, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
                Button b4;
               if(sp1.isWishlist(a,user).equals("true"))
               {b4=new Button(fm1);}
               else{b4=new Button(fm);}
               b4.getStyle().merge(sb);
               Dimension d=new Dimension(5,5);
               c2.setSize(d);
               c1.add(ivv);
               c2.add(b);
               c2.add(b4);
               c2.add(b2);
               c1.add(c2);
               b.setVisible(false);
               b2.setVisible(false);
            //*******************************Action sur le bouton add*****************************************************
               
                
              ivv.addActionListener(e->{ShowAnimal sp=new ShowAnimal(a.getId_animal());});
             ivv.setName(a.getNick_Name());
              c0.add(c1);
              
              
              b4.addActionListener(bb4->{
              if(sp1.isWishlist(a,user).equals("false"))
              { sp1.AddWishlist(a,user);
              b4.setIcon(fm1);}
              else {
              sp1.DeleteWishlist(a,user);
              b4.setIcon(fm);
              }
              });
        }
        
        f.add(c0);
        
        search.addDataChangedListener(new DataChangedListener() {
         
          @Override
          public void dataChanged(int type, int index) {
            c0.removeAll();
            c0.refreshTheme();
            ArrayList<Animal> list2=sp1.SearchAdoption(search.getText());
             for(Animal a : list2)
        {     
               Container c1 =new Container(BoxLayout.y());
               Container c2 =new Container(BoxLayout.x());
               c2.getStyle().setPadding(0,0,10,0);
              c1.getStyle().setBorder(Border.createLineBorder(2));
              Style bb = UIManager.getInstance().getComponentStyle("border-color:white;");
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(5, 5, 0, 0);
              c1.getStyle().merge(bb);
               
        //****************************les elements du containers********************************************************
               
               ScaleImageButton ivv;
                try {
                    ivv = new ScaleImageButton(Image.createImage("C:/wamp64/www/PIWeb33/web/Client/upload/"+ a.getImage()).scaled(80,150));
                
               ivv.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED);
              
               Style s = UIManager.getInstance().getComponentStyle("Button");
               FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_DELETE,s);
               FontImage icon2 = FontImage.createMaterial(FontImage.MATERIAL_EDIT,s);
               Button b =new Button(icon2);
               b.getStyle().merge(sb);
               Button b2 =new Button(icon);
               b2.getStyle().merge(sb);
               Font ff=Font.createTrueTypeFont("fontello", "fontello.ttf");
               FontImage fm = FontImage.createFixed("\ue813",ff, 0xFFFFFF, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
               FontImage fm1 = FontImage.createFixed("\ue812",ff, 0xcc0000, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
                Button b4;
               if(sp1.isWishlist(a,user).equals("true"))
               {b4=new Button(fm1);}
               else{b4=new Button(fm);}
               b4.getStyle().merge(sb);
               Dimension d=new Dimension(5,5);
               c2.setSize(d);
               c1.add(ivv);
               c2.add(b);
               c2.add(b4);
               c2.add(b2);
               c1.add(c2);
               if(sp1.IsUser(a,user).equals("false"))
               {b.setVisible(false);
               b2.setVisible(false);}
               else{b4.setVisible(false);}
               
            //*******************************Action sur le bouton add*****************************************************
               
                
              ivv.addActionListener(e->{ShowAnimal sp=new ShowAnimal(a.getId_animal());});
             ivv.setName(a.getNick_Name());
              c0.add(c1);
              
              
              b4.addActionListener(bb4->{
              if(sp1.isWishlist(a,user).equals("false"))
              { sp1.AddWishlist(a,user);
              b4.setIcon(fm1);}
              else {
              sp1.DeleteWishlist(a,user);
              b4.setIcon(fm);
              }
              });
              
                 } catch (IOException ex) {
                }
        }
            
          }
      });
    
    f.show();
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
