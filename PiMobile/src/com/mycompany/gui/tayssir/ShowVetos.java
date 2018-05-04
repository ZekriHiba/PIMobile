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
              
      
        i ++ ;
        v.setId(i);
               
       
       enc=EncodedImage.createFromImage(theme.getImage("round.png").scaled(500, 500), false);
        uRLImage=URLImage.createToStorage(enc, "test"+v.getId(),"http://localhost"+v.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
        ImageViewer imgV=new ImageViewer(uRLImage);
       /* Image originalImage = imgV.getImage();
         Label label1 = new Label(originalImage);
        cnt.addComponent(label1);
        int w = originalImage.getWidth();
        int h = originalImage.getHeight();
        
        Image maskImage = Image.createImage(w, h);
        Graphics g = maskImage.getGraphics();
        g.setAntiAliased(true);
        g.setColor(0x000000);
        g.fillRect(0, 0, w, h);
        g.setColor(0xffffff);
        g.fillArc(0, 0, w, h, 0, 360);
        Label label2 = new Label(maskImage);
        cnt.addComponent(label2);
        
        Object mask = maskImage.createMask();
        
        Image maskedImage = originalImage.applyMask(mask);
        Label label3 = new Label(maskedImage);*/
       cnt.add(imgV);
        
          /*    Image im = theme.getImage("border.png");
        
              int deviceWidth = Display.getInstance().getDisplayWidth();
              Image placeholder = Image.createImage(deviceWidth / 10, deviceWidth / 10, 0xbfc9d2); //square image set to 10% of screen width
              EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);
       
       // EncodedImage encodedImage1=EncodedImage.createFromImage(im, false);

        URLImage urlImage=URLImage.createToStorage(encImage,"mobile"+i,"http://localhost/mobile/1.png");
         Label label = new Label(urlImage);*/
        // label.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_ALIGNED_CENTER);
     //  URLImage urlImage2=URLImage.createToStorage(encodedImage,String.valueOf(v.getId()),"http://localhost/PIWeb/web/Back/dist/img/user1-128x128.jpg");
    //    ImageViewer imageviewer2 =new ImageViewer(urlImage2);
    // **************************************** date picker cn1 ******************************************//
     String pattern="yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        
        Picker date_debut = new Picker();
        date_debut.setType(Display.PICKER_TYPE_DATE);
        date_debut.setFormatter(format);
        
        
        
        //**************************************
        Label lnom =new Label(v.getNom());
        
        cnt.add(lnom);
        
        lnom.addPointerPressedListener((e)->{
        ShowSingleVetos sh =new ShowSingleVetos(theme , v);
             
        sh.getF().show();
        
        });
       
        cnt.setLeadComponent(lnom);
        f.add(cnt);
                
       
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
    }
        
    
    
    


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
