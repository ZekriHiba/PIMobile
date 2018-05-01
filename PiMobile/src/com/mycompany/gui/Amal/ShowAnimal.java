/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Amal;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.entities.Amal.Animal;
import com.mycompany.services.Amal.AdoptionService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author amalg
 */
public class ShowAnimal {
      Form  f; 
  
    
    public ShowAnimal(int id)  {
        
      f=new Form("Animal",BoxLayout.y());
          try {
              f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
          } catch (IOException ex) {
              
          }
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
       
        
           AdoptionService sp1=new AdoptionService();
           ArrayList<Animal> list=sp1.showAnimal(id);
   
        
       
        for(Animal a : list)
        { 
               Container c1 =new Container(BoxLayout.x());
               
               Container c3 =new Container(BoxLayout.y());
              c1.getStyle().setBorder(Border.createLineBorder(2));
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(20, 20, 0, 0);
              c3.getStyle().setPadding(10, 10, 0, 0);

               ImageViewer iv=new ImageViewer();
               
           try {
               iv.setImage(Image.createImage("/"+ a.getImage()).scaled(100,100));
           } catch (IOException ex) {
                    System.out.println("err");
           }
              
               Button b=new Button("Remplir formulaire");
               Button b1=new Button("Voir demandes");
               SpanLabel name=new SpanLabel("NickName : "+String.valueOf(a.getNick_Name()));
               name.getTextAllStyles().setFgColor(0xff6600);
               SpanLabel size=new SpanLabel("Size : "+String.valueOf(a.getSize()));
               size.getTextAllStyles().setFgColor(0xff6600);
               SpanLabel weight=new SpanLabel("Weight :"+String.valueOf(a.getWeight()));
               weight.getTextAllStyles().setFgColor(0xff6600);
               SpanLabel color=new SpanLabel("Color : "+String.valueOf(a.getColor()));
               color.getTextAllStyles().setFgColor(0xff6600);
               SpanLabel age=new SpanLabel("Date de naissance : ");
               age.getTextAllStyles().setFgColor(0xff6600);
               SpanLabel age1=new SpanLabel(String.valueOf(a.getAge()));
               age1.getTextAllStyles().setFgColor(0xff6600);
               
               SpanLabel description=new SpanLabel("Description : "+String.valueOf(a.getDescription()));
               description.getTextAllStyles().setFgColor(0xff6600);
              
               SpanLabel gender=new SpanLabel("Gender :"+String.valueOf(a.getGender()));
               gender.getTextAllStyles().setFgColor(0xff6600);
               
               c1.add(iv);
               c1.add(c3);
               c3.add(name);
               c3.add(size);
               c3.add(weight);
               c3.add(gender);
               c3.add(color);
               c3.add(description);
               c3.add(age);
               c3.add(age1);
               
              
  
               b.addActionListener(e->{ 
                    
                   try {
                       AddRequest aa=new AddRequest(a);
                   } catch (IOException ex) {
                   }
               });
               
               b1.addActionListener(bl->{
                   try {
                       ShowRequest rr=new ShowRequest(a.getId_animal());
                   } catch (IOException ex) {
                   }
               });
               
       
           
            f.add(c1);
            f.add(b);
            f.add(b1);
            f.show();
        }

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
