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
import com.mycompany.entities.asma.Article;
import com.mycompany.entities.asma.Comment;
import com.mycompany.entities.asma.Feed;
import com.mycompany.services.asma.ServiceArticle;
import com.mycompany.services.asma.ServiceComment;
import java.util.ArrayList;
import static java.util.Collections.list;

/**
 *
 * @author User
 */
public class ShowDetailFeed {
    private Form form;
    private Label corp,titre;
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
          encodedImage=EncodedImage.createFromImage(theme.getImage("round.png"), false);
          
          urlImage = URLImage.createToStorage(encodedImage,"tt"+String.valueOf(f.getTitle()),"http://localhost"+f.getImage(),URLImage.RESIZE_SCALE_TO_FILL);
          img =new ImageViewer(urlImage); 
        
         titre= new Label(f.getTitle());
         Container ctn1= new Container(BoxLayout.x());
       
          Container ctn2= new Container(BoxLayout.y());
          commentaire = new TextField();
          commentaire.setText("");
          commentaire.setHint("commenter ici");
        
          ctn.add(titre);
          ctn1.add(img);
          
          ctn2.add(commentaire);
          comment = new Button("commenter");
          
          ctn2.add(comment);
          form.add(ctn);
          form.add(ctn1);
          form.add(ctn2);
          
          //display comments by title
            ServiceComment c =new ServiceComment();
           ArrayList<Comment> list=c.showComments("CAMPAGNES");
           Container cntComment  =  new Container(BoxLayout.y());
           int i=0;
           
           for(Comment co : list)
    
           { 
             i++;
            Container cont = new Container(BoxLayout.x());
            corp= new Label(co.getCorp());
            cont.add(corp);
            cont.setLeadComponent(corp);
            cntComment.add(cont);
    
           }
          
            comment.addActionListener(e->
          {  
              
             cntComment.removeAll();
             c.insertComment(2, "CAMPAGNES", commentaire.getText());
             
             ShowDetailFeed sh = new ShowDetailFeed(theme, f);
             sh.getForm().show();
        
                                    
            
             
             
          });
          form.add(cntComment);
           
          form.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), 
                  (e)->{
  
          ShowListFeed slf = new ShowListFeed();
          slf.getForm().show();
          });

    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    

