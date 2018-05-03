/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.asma;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.asma.Feed;
import com.mycompany.services.asma.ServiceComment;

/**
 *
 * @author User
 */
public class ShowDetailFeed {
    private Form form;
    private Label titre;
    private ImageViewer imageviewer;
    private ImageViewer img;
    private EncodedImage encodedImage;
    private Image urlImage;
    private Button comment;
    private TextField commentaire;
    private String url="http://localhost/text.txt";
    private ConnectionRequest cr;
    private Label lb;

    public ShowDetailFeed(Resources theme, Feed f) { 
        
        form =new Form("Detail Feed",BoxLayout.y());
        Container ctn = new Container(BoxLayout.x());
         titre= new Label(f.getTitle());
        Container ctn1= new Container(BoxLayout.x());
          encodedImage=EncodedImage.createFromImage(theme.getImage("round.png"), false);
          
          urlImage = URLImage.createToStorage(encodedImage,"tt"+String.valueOf(f.getTitle()),"http://localhost"+f.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
          img =new ImageViewer(urlImage); 
        
          Container ctn2= new Container(BoxLayout.y());
          commentaire = new TextField();
          commentaire.setText("");
          commentaire.setHint("commenter ici");
        
          ctn.add(titre);
          ctn1.add(img);
          
          ctn2.add(commentaire);
          comment = new Button("commenter");
          comment.addActionListener(e->
          {
             ServiceComment sc = new ServiceComment();
             
          }
          
          );
            
          ctn2.add(comment);
          form.add(ctn);
          form.add(ctn1);
          form.add(ctn2);
          
          form.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), (e)->{
  
          ShowListFeed sla = new ShowListFeed(theme);
          sla.getForm().show();
          });

    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

