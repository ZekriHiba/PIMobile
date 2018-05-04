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
public class MyAnimals {
    Form  f; 
  
    
    public MyAnimals() throws IOException  {
        
      f=new Form("Adoption",GridLayout.autoFit());
      f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
         Session se=new Session();
         int user=se.sessionId;
        
        //*******************Recuperer la liste de produit de la base***************************************************
        
           AdoptionService sp1=new AdoptionService();
           ArrayList<Animal> list=sp1.MyAnimals(user);
   
        
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
               Style sb = UIManager.getInstance().getComponentStyle("background-color:transparent;");
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
               b4.setVisible(false);
            //*******************************Action sur le bouton add*****************************************************
               
                
              ivv.addActionListener(e->{ShowAnimal sp=new ShowAnimal(a.getId_animal());});
             ivv.setName(a.getNick_Name());
              f.add(c1);
              f.show();
              
              b2.addActionListener(bb2->{
              sp1.DeleteAnimal(a);
              c1.remove();
              });
              
              b.addActionListener(bb1->{
                   try {
                       UpdateAdoption adop=new UpdateAdoption(a.getId_animal());
                   } catch (IOException ex) {
                   }
                   
              });
              
             
        }

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
