/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.tayssir;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.tayssir.Veto;
import com.mycompany.services.tayssir.ServiceRdv;
import java.util.ArrayList;

/**
 *
 * @author tay
 */
class DateForm {
       Form f ;
  
            

    public DateForm(Resources theme ,  Veto v) {
        
      
         f=new Form(BoxLayout.y());
        
     String pattern="yyyy-MM-dd";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        
        Picker date_debut = new Picker();
        date_debut.setType(Display.PICKER_TYPE_DATE);
        date_debut.setFormatter(format);
        Container cnt =  new Container();
                    
           int  i =0;
           int switchs= 0;
   /*     date_debut.addActionListener(( e)->{
            
            
            //Container cnt
            ServiceRdv sr = new ServiceRdv();
            ArrayList<String> listDispo =new ArrayList<>();
            listDispo.add("09:30");
            listDispo.add("10:30");
            listDispo.add("11:00");
            listDispo.add("11:30");
            listDispo.add("12:00");
            listDispo.add("12:30");
            listDispo.add("13:30");
            listDispo.add("14:00");
            listDispo.add("14:30");
            listDispo.add("15:00");
            listDispo.add("15:30");
            listDispo.add("16:00");
            
            

            ArrayList<String> list =new ArrayList<>();
            list = sr.getTimes(2,date_debut.getText());
            
           
            for(String s : list){
                listDispo.remove(s);
                System.out.println(s);
              //  Label l= new Label()
            }
            
           for(String s : listDispo){
                System.out.println(s); 
                Label l =  new Label(s);
                cnt.add(l);
                 l.addPointerPressedListener((mo)->{
                     
        
        });
        cnt.setLeadComponent(l);
       
            }    
          //  cnt.removeAll();
        }
                
        
        );*/
        
        Button  bt =  new Button ("Next");
        
        bt.addActionListener((e)->{
            PrendreRDV pr = new PrendreRDV(theme, date_debut.getText(), v.getId());
            pr.getF().show();
            
        });
       
        
        cnt.add(bt);
        
        
        
        f.add(cnt);
        f.add(date_debut);
       
        
        
       
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
