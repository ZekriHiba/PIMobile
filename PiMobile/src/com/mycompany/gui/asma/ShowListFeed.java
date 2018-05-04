/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.asma;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.asma.Feed;
import com.mycompany.services.asma.ServiceFeed;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class ShowListFeed {

private Form current;
    private TextField nom,prenom;
    private Button valider;
    private Container ctn,ctn2;
    private ImageViewer img;
    private Label titre;
    private EncodedImage encodedImage;
    private Image urlImage;
    private ImageViewer imageviewer;
    private Toolbar tb;
    private Form form;
   

    public ShowListFeed() {
    }
    
    
    public ShowListFeed(Resources theme) {
        
           form=new Form("Actualite",BoxLayout.y());
           ServiceFeed sp1=new ServiceFeed();
           ArrayList<Feed> list=sp1.showList();
        int i=0;
       //********************************Parcourir la liste**************************************************************** 
       for(Feed f : list)
        {  
            i++;
            Container ctn = new Container(BoxLayout.x());
            
                encodedImage=EncodedImage.createFromImage(theme.getImage("round.png"), false);
                urlImage = URLImage.createToStorage(encodedImage, "brha"+i,"http://localhost"+f.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
                img =new ImageViewer(urlImage); 
                
             /*   img.addPointerDraggedListener(s->{
                         fo = new Form("hello",BoxLayout.y());
                         fo.show();
                         });*/
            ctn.add(img);
            
            titre= new Label(f.getTitle());
            ctn.add(titre);
           
            
            titre.addPointerPressedListener((e)-> {
            ShowDetailFeed sda =new ShowDetailFeed(theme ,f);
             
            sda.getForm().show();
        
             });
            
            ctn.setLeadComponent(titre);
            form.add(ctn);
        }
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    
    }
    
    
    

