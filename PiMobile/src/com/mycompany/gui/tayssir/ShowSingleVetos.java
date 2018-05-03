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
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
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
            

    public ShowSingleVetos(Resources theme , Veto v) {
        
         f=new Form(BoxLayout.y());
       
   
        enc=EncodedImage.createFromImage(theme.getImage("round.png"), false);
        uRLImage=URLImage.createToStorage(enc, "test"+v.getId(),"http://localhost"+v.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
         Button showPosition = new Button("Localiser");
         showPosition.addActionListener((e)->{
             
         });
         Button rdvButton = new Button("Prenez un rendez-vous");
         rdvButton.addActionListener((e)->{
            DateForm  d = new DateForm(theme,v);
            d.getF().show();
                    
        });
         f.add(rdvButton);
        f.add(imgV);
  
                
       
    }
  /*   f.getToolbar().addSearchCommand(e -> {
            String t = (String)e.getSource();
            if(t == null) {
                t = "";
            } else {
                t = t.toLowerCase();
            }
            for(Component c : cnt) {
                DemoComponent mb = (DemoComponent)c;
                boolean show = t.length() == 0 || mb.getText().toLowerCase().indexOf(t) > -1;
                mb.setVisible(show);
                mb.setHidden(!show);
            }
            cnt.animateLayout(200);
        }, 3);*/
    
        
    
    
    


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    


    
}
