/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Amal;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.entities.Amal.Request_Adoption;
import com.mycompany.services.Amal.AdoptionService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author amalg
 */
public class ShowRequest {
       Form  f; 
  
    
    public ShowRequest(int id) throws IOException  {
        
      f=new Form("Adoption",GridLayout.autoFit());
      f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
         
           
       
        
        //*******************Recuperer la liste de produit de la base***************************************************
        
           AdoptionService sp1=new AdoptionService();
           ArrayList<Request_Adoption> list=sp1.ShowRequest(id);
   
        
       //********************************Parcourir la liste**************************************************************** 
        for(Request_Adoption a : list)
        {     
               Container c1 =new Container(BoxLayout.y());
               Container c2 =new Container(BoxLayout.x());
               c2.getStyle().setPadding(0,0,10,0);
              c1.getStyle().setBorder(Border.createLineBorder(2));
              Style bb = UIManager.getInstance().getComponentStyle("border-color:white;");
              c1.getStyle().setMargin(1, 1, 1, 1);
              c1.getStyle().setPadding(5, 5, 0, 0);
              c1.getStyle().merge(bb);
               
        //****************************les elements du containers********************************************************
               
          
               
               Style s = UIManager.getInstance().getComponentStyle("Button");
               Font ff=Font.createTrueTypeFont("fontello", "fontello.ttf");
               FontImage fm = FontImage.createFixed("\ue807",ff, 0xFFFFFF, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));
               Button b =new Button(fm);
               Style sb = UIManager.getInstance().getComponentStyle("background-color:transparent;");
               b.getStyle().merge(sb);
               Dimension d=new Dimension(5,5);
               
               String ch = new String();
               if(a.isRaiser()){ch+=" Je suis éleveur.";} else { ch+=" Je ne suis pas éleveur.";}
               if(a.isBreed()) {ch+=" Je connais cette race.";}  else {ch+=" Je ne connais pas cette race.";}
               if(a.getLocal().equals("Maison")){ch+=" J'habite dans une maison";}else {ch+=" J'habite dans un appartement";}
               if(a.isGarden()) {ch+=" avec un jardin.";} else {ch+=" mais pas de jardin.";}
               if(a.isSpace()){ch+=" J'ai suffisamment d'espace pour que les chiots puissent jouer.";}
               else {ch+=" Je n'ai pas suffisamment d'espace."; }
                if(a.getPlace().equals("Exterieur")) {ch+=" Il sera à l'extérieur";} else {ch+=" Il vivra avec moi";}
                if(a.getCarry().equals("Accompagne")){ch+=" et il sera accompagné. ";}else {ch+=" et souvent seul.";}
                if(a.isNeighbour()){ch+=" Les voisins sont tolérants.";} else {ch+=" Malheureusement les voisins ne sont pas tolérants.";}
                if(a.isChild()) {ch+="Sinon, oui j'ai des enfants";} else {ch+=" Sinon j'ai pas d'enfants ";}
                if(a.isFamilly()){ch+=" et ma famille veux avoir un animal .";} else {ch+=" mais ma famille n'accepte pas les animeaux.";}
                if(a.isTime()){ch+=" J'ai pleinement le temps de bien prendre soin de lui.";}else {ch+=" Je suis toujours occupé(e).";}
                if(a.isEngagement()){ch+=" Je suis prêt(e) à un tel engagement.";} else {ch+=" Je doute d'être vraiment prêt(e) à un tel engagement..";}
                if(a.isCharges()) {ch+=" J'assume tous les frais soit pour le soigner ou de sa nourriture.";}
               
               
               
               SpanLabel Req=new SpanLabel(ch);

               
               c1.add(Req);
               c2.setSize(d);
               c2.add(b);
               c1.add(c2);
               f.add(c1);
               f.show();
            //*******************************Action sur le bouton add*****************************************************
           b.addActionListener(bl->{
           sp1.ValiderReques(id);
           ShowAnimal aa=new ShowAnimal(id);
           });
           
        }

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
