/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.Amal;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.RadioButton;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.entities.Amal.Animal;
import com.mycompany.entities.Amal.Request_Adoption;
import com.mycompany.entities.hiba.Session;
import com.mycompany.services.Amal.AdoptionService;
import java.io.IOException;

/**
 *
 * @author amalg
 */
public class AddRequest {
    Form  f; 
  
    
    public AddRequest(Animal a) throws IOException  {
        
      f=new Form("Adoption",BoxLayout.y());
      f.getStyle().setBgImage(Image.createImage("/vitrine.png"));
      f.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);

               
           Session se=new Session();
         int user=se.sessionId;
               
        //****************************les elements du containers********************************************************
              AdoptionService sp1=new AdoptionService();

            SpanLabel eleveur1 =new SpanLabel("Etes vous éleveur?");
            RadioButton eleveur =new RadioButton("Oui");
            Style sb = UIManager.getInstance().getComponentStyle("background-color:transparent;");
            eleveur.getStyle().merge(sb);
            RadioButton eleveurNon =new RadioButton("Non");
            eleveurNon.getStyle().merge(sb);
            eleveur.setGroup("eleveur");
            eleveurNon.setGroup("eleveur");
            SpanLabel local1 =new SpanLabel("Est ce que vous habitez dans une maison ou dans un appartement ?");
            ComboBox local=new ComboBox();
            local.addItem("Maison");
            local.addItem("Appartement");
            SpanLabel garden1 =new SpanLabel("Vous avez un jardin? ");
            RadioButton garden =new RadioButton("Oui");
            garden.getStyle().merge(sb);
            RadioButton gardenNon =new RadioButton("Non");
            gardenNon.getStyle().merge(sb);
            garden.setGroup("garden");
            gardenNon.setGroup("garden");
            SpanLabel space1 =new SpanLabel("Avez-vous suffisamment d'espace pour que les chiots puissent jouer? ");
            RadioButton space =new RadioButton("Oui");
            space.getStyle().merge(sb);
            RadioButton spaceNon =new RadioButton("Non");
            spaceNon.getStyle().merge(sb);
            space.setGroup("space");
            spaceNon.setGroup("space");
            SpanLabel place1 =new SpanLabel("Il sera à l extérieur ou avec vous dedans?");
            ComboBox place=new ComboBox();
            place.addItem("Exterieur");
            place.addItem("Dedans");
            SpanLabel carry1 =new SpanLabel("Seul toute la journée ou accompagné? ");
            ComboBox carry=new ComboBox();
            carry.addItem("Seul");
            carry.addItem("Accompagne");
            SpanLabel neighbour1 =new SpanLabel("Si il aboie quand il est seul, vous avez des voisins tolérant?  ");
            RadioButton neighbour =new RadioButton("Oui");
            neighbour.getStyle().merge(sb);
            RadioButton neighbourNon =new RadioButton("Non");
            neighbourNon.getStyle().merge(sb);
            neighbour.setGroup("neighbour");
            neighbourNon.setGroup("neighbour");
            SpanLabel child1 =new SpanLabel("Avez-vous des enfants à la maison? ");
            RadioButton child =new RadioButton("Oui");
            child.getStyle().merge(sb);
            RadioButton childNon =new RadioButton("Non");
            childNon.getStyle().merge(sb);
            child.setGroup("child");
            childNon.setGroup("child");
            SpanLabel time1 =new SpanLabel("Etes vous sure que votre temps vous permettra de bien prendre soin de lui?");
            RadioButton time =new RadioButton("Oui");
            time.getStyle().merge(sb);
            RadioButton timeNon =new RadioButton("Non");
            timeNon.getStyle().merge(sb);
            time.setGroup("time");
            timeNon.setGroup("time");
            SpanLabel breed1 =new SpanLabel("Connaissez-vous cette race? ");
            RadioButton breed =new RadioButton("Oui");
            breed.getStyle().merge(sb);
            RadioButton breedNon =new RadioButton("Non");
            breedNon.getStyle().merge(sb);
            breed.setGroup("breed");
            breedNon.setGroup("breed");
            SpanLabel engagement1 =new SpanLabel("Êtes-vous prêt à vous engager à long terme? ");
            RadioButton engagement =new RadioButton("Oui");
            engagement.getStyle().merge(sb);
            RadioButton engagementNon =new RadioButton("Non");
            engagementNon.getStyle().merge(sb);
            engagement.setGroup("engagement");
            engagementNon.setGroup("engagement");
            SpanLabel habits1 =new SpanLabel("Êtes-vous prêt à modifier vos habitudes de vie? ");
            RadioButton habits =new RadioButton("Oui");
            habits.getStyle().merge(sb);
            RadioButton habitsNon =new RadioButton("Non");
            habitsNon.getStyle().merge(sb);
            habits.setGroup("habits");
            habitsNon.setGroup("habits");
            SpanLabel charges1 =new SpanLabel("Êtes-vous prêt à assumer tous les frais pour les soins de l’animal? ");
            RadioButton charges =new RadioButton("Oui");
            charges.getStyle().merge(sb);
            RadioButton chargesNon =new RadioButton("Non");
            chargesNon.getStyle().merge(sb);
            charges.setGroup("charges");
            chargesNon.setGroup("charges");
            SpanLabel ready1 =new SpanLabel("Etes-vous toujours prêts à adopter un animal? ");
            RadioButton ready =new RadioButton("Oui");
            ready.getStyle().merge(sb);
            RadioButton readyNon =new RadioButton("Non");
            readyNon.getStyle().merge(sb);
            ready.setGroup("ready");
            readyNon.setGroup("ready");
            SpanLabel sacrifice1 =new SpanLabel("Etes-vous prêt à faire des sacrifices pour votre animal ? ");
            RadioButton sacrifice =new RadioButton("Oui");
            sacrifice.getStyle().merge(sb);
            RadioButton sacrificeNon =new RadioButton("Non");
            sacrificeNon.getStyle().merge(sb);
            sacrifice.setGroup("sacrifice");
            sacrificeNon.setGroup("sacrifice");
            SpanLabel familly1 =new SpanLabel("Est ce que votre famille accepte que vous élever un animal ? ");
            RadioButton familly =new RadioButton("Oui");
            familly.getStyle().merge(sb);
            RadioButton famillyNon =new RadioButton("Non");
            famillyNon.getStyle().merge(sb);
            familly.setGroup("familly");
            famillyNon.setGroup("familly");
            TextArea description =new TextArea(null);
            description.getStyle().merge(sb);
            description.setHint("Autres notes");
            CheckBox c=new CheckBox("Nothing to add");
            Font font=Font.createTrueTypeFont("fontello", "fontello.ttf");
            FontImage fm = FontImage.createFixed("\ue80f",font, 0xFFFFFF, Display.getInstance().convertToPixels(4), Display.getInstance().convertToPixels(4));

               Button b=new Button(fm);
               b.getStyle().setBgColor(45468);
               b.getAllStyles();
              
              f.add(eleveur1);
              f.add(eleveur);
              f.add(eleveurNon);
              f.add(local1);
              f.add(local);
              f.add(garden1);
              f.add(garden);
              f.add(gardenNon);
              f.add(space1);
              f.add(space);
              f.add(spaceNon);
              f.add(place1);
              f.add(place);
              f.add(carry1);
              f.add(carry);
              f.add(neighbour1);
              f.add(neighbour);
              f.add(neighbourNon);
              f.add(child1);
              f.add(child);
              f.add(childNon);
              f.add(time1);
              f.add(time);
              f.add(timeNon);
              f.add(b);
            f.show();
            
          
               b.addActionListener(e->{ 
                   if ((eleveur.isSelected() || eleveurNon.isSelected()) && (garden.isSelected() || gardenNon.isSelected())
                                   && (space.isSelected() || spaceNon.isSelected()) && (neighbour.isSelected() || neighbourNon.isSelected())
                                   && (child.isSelected() || childNon.isSelected()) && (time.isSelected() || timeNon.isSelected()))
              {
                   Form ff=new Form("Adoption",BoxLayout.y());
                   ff.removeAll();
          try {
              ff.getStyle().setBgImage(Image.createImage("/vitrine.png"));
          } catch (IOException ex) {
          }
      ff.getAllStyles().setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
              ff.add(breed1);
              ff.add(breed);
              ff.add(breedNon);
              ff.add(engagement1);
              ff.add(engagement);
              ff.add(engagementNon);
              ff.add(habits1);
              ff.add(habits);
              ff.add(habitsNon);
              ff.add(charges1);
              ff.add(charges);
              ff.add(chargesNon);
              ff.add(sacrifice1);
              ff.add(sacrifice);
              ff.add(sacrificeNon);
              ff.add(familly1);
              ff.add(familly);
              ff.add(famillyNon);
              ff.add(ready1);
              ff.add(ready);
              ff.add(readyNon);
              ff.add(description);
              c.getStyle().merge(sb);
              ff.add(c);
              Button bf=new Button("add request");
              ff.add(bf);
              ff.show();
              
               
               bf.addActionListener(bff->{
                       
                           Request_Adoption r=new Request_Adoption();
                           if(eleveur.isSelected()){r.setRaiser(true);}
                           else{r.setRaiser(false);}
                           if(local.getSelectedItem().toString().equals("Maison")){r.setLocal(Request_Adoption.local.Maison);}
                           else{r.setLocal(Request_Adoption.local.Appartement);}
                           if(garden.isSelected()){r.setGarden(true);}
                           else{r.setGarden(false);}
                           if(space.isSelected()){r.setSpace(true);}
                           else{r.setSpace(false);}
                           if(place.getSelectedItem().toString().equals("Exterieur")){r.setPlace(Request_Adoption.place.Exterieur);}
                           else{r.setPlace(Request_Adoption.place.Dedans);}
                           if(carry.getSelectedItem().toString().equals("Seul")){r.setCarry(Request_Adoption.carry.Seul);}
                           else{r.setCarry(Request_Adoption.carry.Accompagne);}
                           if(neighbour.isSelected()){r.setNeighbour(true);}
                           else{r.setNeighbour(false);}
                           if(child.isSelected()){r.setChild(true);}
                           else{r.setChild(false);}
                           if(time.isSelected()){r.setTime(true);}
                           else{r.setTime(false);}
                           if(breed.isSelected()){r.setBreed(true);}
                           else{r.setBreed(false);}
                           if(engagement.isSelected()){r.setEngagement(true);}
                           else{r.setEngagement(false);}
                           if(habits.isSelected()){r.setHabits(true);}
                           else{r.setHabits(false);}
                           if(charges.isSelected()){r.setCharges(true);}
                           else{r.setCharges(false);}
                           if(ready.isSelected()){r.setReady(true);}
                           else{r.setReady(false);}
                           if(sacrifice.isSelected()){r.setSacrifice(true);}
                           else{r.setSacrifice(false);}
                           if(familly.isSelected()){r.setFamilly(true);}
                           else{r.setFamilly(false);}
                           r.setDescription(description.getText());
                           if(c.isSelected()){r.setDescription("Nothing to add");}
                           if ((eleveur.isSelected() || eleveurNon.isSelected()) && (garden.isSelected() || gardenNon.isSelected())
                                   && (space.isSelected() || spaceNon.isSelected()) && (neighbour.isSelected() || neighbourNon.isSelected())
                                   && (child.isSelected() || childNon.isSelected()) && (time.isSelected() || timeNon.isSelected())
                                   && (breed.isSelected() || breedNon.isSelected()) && (engagement.isSelected() || engagementNon.isSelected())
                                   && (habits.isSelected() || habitsNon.isSelected()) && (charges.isSelected() || chargesNon.isSelected())
                                   && (ready.isSelected() || readyNon.isSelected()) && (sacrifice.isSelected() || sacrificeNon.isSelected())
                                   && ( familly.isSelected() || famillyNon.isSelected()) && (description.getText().toString().length()!=0|| c.isSelected()) )
                               
                           
                           {sp1.AddRequest(r,a.getId_animal(),user);
                           try {
                           ShowAdoption sh=new ShowAdoption();} catch (IOException ex) {}}
                            else {Dialog.show("Champs Obligatoire","Vueillez remplir tous les champs","ok", null);}
               });
              }
              else {Dialog.show("Champs Obligatoire","Vueillez remplir tous les champs","ok", null);}
               });
               
               

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
