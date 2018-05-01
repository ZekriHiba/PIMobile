/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Amal;

import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
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
public class UpdateAdoption {
       Form  f; 
  
    
    public UpdateAdoption(int id) throws IOException  {
       
        
          
      f=new Form("Adoption",BoxLayout.y());
      f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
         
      
               Container c1 =new Container(BoxLayout.x());
               Container c3 =new Container(BoxLayout.y());
              c1.getStyle().setBorder(Border.createLineBorder(2));
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(20, 20, 0, 0);

               Container c4 =new Container(BoxLayout.x());
               Container c5 =new Container(BoxLayout.x());
           
               
        //****************************les elements du containers********************************************************
              AdoptionService sp1=new AdoptionService();
              ArrayList<Species> species=sp1.ShowSpecies();
            ComboBox spec =new ComboBox();
            ComboBox sspec =new ComboBox();
            sspec.setVisible(false);
            for(Species s : species)
             {spec.addItem(s.getName());}
            
            spec.addActionListener(l-> {
                sspec.setVisible(true);
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
            ArrayList<Animal> List=sp1.showAnimal(id);
        for(Animal a : List)
        { 
            TextField nickname = new TextField(a.getNick_Name(), "NickName", 20, TextArea.ANY);
            nickname.getStyle().setFgColor(0xffffff);
            Label poids1 = new Label("Taille : ");  
            poids1.getStyle().setFgColor(0xffffff);
            Label poids=new Label(String.valueOf(a.getWeight()));
            Label taille1 = new Label("Poids : ");
            taille1.getStyle().setFgColor(0xffffff);
            Label taille=new Label(String.valueOf(a.getWeight()));
            Picker age = new Picker(); 
            age.setDate(a.getAge());
            age.setType(Display.PICKER_TYPE_DATE);
            age.getStyle().setFgColor(0xffffff);
            TextField description = new TextField(String.valueOf(a.getDescription()), "Description", 150, TextArea.ANY);
            description.getStyle().setFgColor(0xffffff);
            TextField color = new TextField(String.valueOf(a.getColor()));
            color.getStyle().setFgColor(0xffffff);
            TextField gender = new TextField(a.getGender());
            gender.getStyle().setFgColor(0xffffff);
            TextField image = new TextField(a.getImage());
            image.getStyle().setFgColor(0xffffff);
            Font ff=Font.createTrueTypeFont("fontello", "fontello.ttf");
            FontImage fm = FontImage.createFixed("\ue803", ff, 0xFFFFFF, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
            Button img=new Button(fm);
            
            
              
               Button b=new Button("Modifier publication");
               b.getStyle().setBgColor(45468);
               b.getAllStyles();
              
             Button b1=new Button("+");
            Button b2=new Button("-");
            Button b3=new Button("+");
            Button b4=new Button("-");
               
               c3.add(spec);
               c3.addComponent(sspec);
               c1.add(c3);
               c3.add(nickname);
               c4.add(poids1);
               c4.add(b1);
               c4.add(poids);
               c4.add(b2);
               c3.add(c4);
               c5.add(taille1);
               c5.add(b3);
               c5.add(taille);
               c5.add(b4);
               c3.add(c5);
               c3.add(age);
               c3.add(description);
               c3.add(color);
               c3.add(gender);
               c3.add(image);
                c3.add(b);
            f.add(c1);
            f.show();
            //Action sur le boutton image
           /* image.addActionListener(e -> {
             Display.getInstance().openGallery((ev)-> {
             if (ev != null && ev.getSource() != null) {
            String filePath =ev.getSource().toString();
            //int fileNameIndex = filePath.lastIndexOf("/") +1;
              //          String fileName = filePath.substring(fileNameIndex);
            System.err.println(filePath.toString());
            // a.setImage1(fileName);
            try {
            Image img = Image.createImage(FileSystemStorage.getInstance().openInputStream(filePath));
            } catch (IOException e) {}
            }

            }, Display.GALLERY_IMAGE);
            });*/
           
               b1.addActionListener(bb1->{
            poids.setText(String.valueOf(Integer.parseInt(poids.getText())+1));
            });
            b2.addActionListener(bb1->{
                if (Integer.parseInt(poids.getText())<=0){poids.setText(String.valueOf(0));}
                else{poids.setText(String.valueOf(Integer.parseInt(poids.getText())-1));}
            });
            
            b3.addActionListener(bb1->{
            taille.setText(String.valueOf(Integer.parseInt(taille.getText())+1));
            });
            b4.addActionListener(bb1->{
                if (Integer.parseInt(taille.getText())<=0){taille.setText(String.valueOf(0));}
                else{taille.setText(String.valueOf(Integer.parseInt(taille.getText())-1));}
            });
            //*******************************Action sur le bouton add*****************************************************
               
               b.addActionListener(e->{ 
                    if ( nickname.getText().trim().toString().length()!=0
                           && age.getDate().toString().length()!=0 && color.getText().trim().toString().length()!=0
                         && description.getText().trim().toString().length()!=0 && gender.getText().trim().toString().length()!=0 
                   && image.getText().trim().toString().length()!=0 && poids.getText()!="0" && taille.getText()!="0")
                 {
                  
                   S_Species s = new S_Species(); 
                   Species ss = new Species();
                    if(spec.getSelectedItem().toString()!=null)
                    {ss.setName(spec.getSelectedItem().toString());
                     s.setS(ss);
                    }
                   if(sspec.isVisible())
                    {s.setName(sspec.getSelectedItem().toString());
                    a.setS(s);
                    }
                  
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
                  Animal list=sp1.UpdateAnimal(a);
                try {
                    ShowAdoption sp=new ShowAdoption();
                    sp.getF().show();
                } catch (IOException ex) {
                }}
                    else {Dialog.show("Champs Obligatoire","Vueillez remplir tous les champs","ok", null);}
               
               });
               
       
          
        
        
        //*******************Insertion dans la base***************************************************
        
           //AdoptionService sp1=new AdoptionService();
           //Animal list=sp1.insertAnimal(a);
        }
    }
}
