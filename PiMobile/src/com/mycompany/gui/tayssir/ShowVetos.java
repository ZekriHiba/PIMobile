/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.tayssir;

import com.codename1.components.Accordion;
import com.codename1.components.ImageViewer;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.hiba.Product;
import com.mycompany.entities.tayssir.Veto;
import com.mycompany.services.tayssir.ServiceVeto;
import java.util.ArrayList;

/**
 *
 * @author tay
 */
public class ShowVetos {
    
    Form f ;
    EncodedImage  enc;
    URLImage uRLImage;
    String url="http://localhost/mobile/1.png";
        private EncodedImage encodedImage;
          private URLImage urlImage;
    private ImageViewer imageviewer;
            

    public ShowVetos(Resources theme) {
        
         f=new Form(BoxLayout.y());
        ServiceVeto sv=new ServiceVeto();
        ArrayList<Veto> list=sv.showVetos();
        int i=0;
        for(Veto v : list){
        Container cnt = new Container(BoxLayout.x());
              
      
       
               
       
       enc=EncodedImage.createFromImage(theme.getImage("round.png"), false);
        uRLImage=URLImage.createToStorage(enc, "test"+v.getId(),"http://localhost"+v.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
       cnt.add(imgV);  
        //**************************************
        Label lnom =new Label(v.getNom());
        
        cnt.add(lnom);
        
        lnom.addPointerPressedListener((e)->{
        ShowSingleVetos sh =new ShowSingleVetos(theme , v);
        ServiceVeto sv1 = new ServiceVeto();
          sv1.addView(v.getId());
        sh.getF().show();
        
        });
       
        cnt.setLeadComponent(lnom);
        
        
        
        f.add(cnt);
                
       
    }
        
        
                

         f.getToolbar().addSearchCommand(e->{
             
               
              System.out.println(e.getSource());
              // Product psearch=sp1.searchByName((String)e.getSource());
               ArrayList<Veto> list1=sv.showVetosByName((String)e.getSource());
               
              
               
           if (!list.isEmpty()){
                 f.removeAll();
           
                for(Veto v : list1){
        Container cnt = new Container(BoxLayout.x());
              
      
       // v.setId(i);
               
       
       enc=EncodedImage.createFromImage(theme.getImage("round.png"), false);
        uRLImage=URLImage.createToStorage(enc, "test"+v.getId(),"http://localhost"+v.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
       cnt.add(imgV);  
        //**************************************
        Label lnom2 =new Label(v.getNom());
        
        cnt.add(lnom2);
        
        lnom2.addPointerPressedListener((m)->{
        ShowSingleVetos sh2 =new ShowSingleVetos(theme , v);
             
        sh2.getF().show();
        
        });
       
        cnt.setLeadComponent(lnom2);
        
        f.revalidate();
        
        f.add(cnt);
                
       
    }
                }   else
           {
               f.removeAll();
               f.revalidate();
           }
               
               
               
               
               
               
             
      
    });
    }
    
    
    
    
  //  Container vetoContainer
        
    
    
    


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
