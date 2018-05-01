/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Amal;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.Picker;
import com.mycompany.entities.Amal.Animal;
import com.mycompany.entities.Amal.S_Species;
import com.mycompany.entities.Amal.Species;
import com.mycompany.services.Amal.AdoptionService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author amalg
 */
public class AddAnimal {
       Form  f; 
  
    
    public AddAnimal() throws IOException  {
        
      f=new Form("Adoption",BoxLayout.y());
      f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
         
      
               Container c1 =new Container(BoxLayout.x());
               Container c3 =new Container(BoxLayout.y());
              c1.getStyle().setBorder(Border.createLineBorder(2));
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(20, 20, 0, 0);

               
           
               
        //****************************les elements du containers********************************************************
              AdoptionService sp1=new AdoptionService();
              ArrayList<Species> species=sp1.ShowSpecies();
            ComboBox spec =new ComboBox();
            ComboBox sspec =new ComboBox();
            for(Species s : species)
             {spec.addItem(s.getName());}
            
            spec.addActionListener(l-> {
                System.err.println(spec.getSelectedItem().toString());
              int dd=0;
              for(Species s : species)
             {
             if (s.getName().equals(spec.getSelectedItem().toString()))
             { dd=s.getId_species(); }
              }
            ArrayList<S_Species> ss=sp1.ShowSubSpecies(dd);
            
            
            for(S_Species s1 : ss)
             {sspec.addItem(s1.getName());}
            
            });        
            
            TextField nickname = new TextField("", "NickName", 20, TextArea.ANY);
            nickname.getStyle().setFgColor(0xffffff);
            TextField poids = new TextField("", "poids", 4, TextArea.NUMERIC);  
            poids.getStyle().setFgColor(0xffffff);
            TextField taille = new TextField("", "taille", 4, TextArea.NUMERIC);
            taille.getStyle().setFgColor(0xffffff);
            Picker age = new Picker(); 
            age.setType(Display.PICKER_TYPE_DATE);
            age.getStyle().setFgColor(0xffffff);
            TextField description = new TextField("", "Description", 150, TextArea.ANY);
            description.getStyle().setFgColor(0xffffff);
            TextField color = new TextField();
            color.getStyle().setFgColor(0xffffff);
            TextField gender = new TextField();
            gender.getStyle().setFgColor(0xffffff);
            TextField image = new TextField();
            image.getStyle().setFgColor(0xffffff);
            Font ff=Font.createTrueTypeFont("fontello", "fontello.ttf");
            FontImage fm = FontImage.createFixed("\ue803", ff, 0xFFFFFF, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
            Button img=new Button(fm);
            
            
              
               Button b=new Button("Ajouter publication");
               b.getStyle().setBgColor(45468);
               b.getAllStyles();
              
             
               
               c3.add(spec);
               c3.addComponent(sspec);
               c1.add(c3);
               c3.add(nickname);
               c3.add(poids);
               c3.add(taille);
               c3.add(age);
               c3.add(description);
               c3.add(color);
               c3.add(gender);
               c3.add(image);
                c3.add(b);
            f.add(c1);
            f.show();
             Animal a=new Animal();
            //Action sur le boutton image
            image.addActionListener(e -> {
             Display.getInstance().openGallery((ev)-> {
             if (ev != null && ev.getSource() != null) {
            String filePath =ev.getSource().toString();
            //int fileNameIndex = filePath.lastIndexOf("/") +1;
              //          String fileName = filePath.substring(fileNameIndex);
            System.err.println(filePath.toString());
            // a.setImage1(fileName);
           /* try {
            Image img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
            } catch (IOException e) {}*/
            }

            }, Display.GALLERY_IMAGE);
            });
               
            //*******************************Action sur le bouton add*****************************************************
               
               b.addActionListener(e->{ 
                  
                   S_Species s = new S_Species(); 
                   Species ss = new Species();
                   ss.setName(spec.getSelectedItem().toString());
                   s.setName(sspec.getSelectedItem().toString());
                   s.setS(ss);
                   a.setS(s);
                   a.setNick_Name(nickname.getText());
                   a.setSize(Integer.parseInt(taille.getText()));
                   a.setWeight(Integer.parseInt(poids.getText()));
                   
                   String d=age.getDate().toString();
                 
                   
                   a.setAge(age.getDate());
                                 
                   a.setColor(color.getText());
                   a.setDescription(description.getText());
                   a.setGender(gender.getText());
                  a.setImage1(image.getText());
                   a.setStatus("Adption");
                   a.setConfirmation(0);
                  Animal list=sp1.insertAnimal(a);
                  // ShowAnimal sp=new ShowAnimal(list.getId_animal());
                   // sp.getF().show();
               
               });
               
       
          
        
        
        //*******************Insertion dans la base***************************************************
        
           //AdoptionService sp1=new AdoptionService();
           //Animal list=sp1.insertAnimal(a);

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
