/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.tayssir;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.tayssir.Veto;

/**
 *
 * @author tay
 */
public class ShowSingleVetos {
    
    



    
    Form f ;
    EncodedImage  enc;
    URLImage uRLImage;
    String url="http://localhost/mobile/1.png";
        private EncodedImage encodedImage;
          private URLImage urlImage;
    private ImageViewer imageviewer;
    private Label nomp,ville,mail;

    
    public ShowSingleVetos(Resources theme , Veto v) {
        
         f=new Form(BoxLayout.y());
       
   
        enc=EncodedImage.createFromImage(theme.getImage("round.png").scaled(120, 120), false);
        uRLImage=URLImage.createToStorage(enc, "test"+v.getId(),"http://localhost"+v.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
      
        Container c = new Container(BoxLayout.y());
        
        Label  lb0 = new Label("Vue :");
        Label vue = new Label(String.valueOf(v.getVue()));
        Label  lb1 = new Label("Nom :");
        nomp = new Label(v.getNom());
        Label  lb2 = new Label("Ville :");
        ville = new Label(v.getVille());
        Label  lb3 = new Label("E-mail :");
        mail = new Label(v.getMail());
        c.add(lb0).add(vue).add(lb1).add(nomp).add(lb2).add(ville).add(lb3).add(mail);
        
         Button showPosition = new Button("Localiser");
         MapApi map = new MapApi();
         f.add(showPosition);
         showPosition.addActionListener((e)->{
             
             map.lister( v.getLongit(), v.getLat(),v.getNomp(), v);
         });
         Button rdvButton = new Button("Prenez un rendez-vous");
         rdvButton.addActionListener((e)->{
            DateForm  d = new DateForm(theme,v);
            d.getF().show();
         
        });
          
         
         f.getToolbar().addCommandToLeftBar("retour", theme.getImage("back-command.png"), 
                  (m)->{
  
          ShowVetos sv = new ShowVetos(theme);
          sv.getF().show();
          });
         
        f.add(rdvButton);
        f.add(imgV);
        f.add(c);
        
  
                
       
    }
  
        
    
    
    


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    


    
}
