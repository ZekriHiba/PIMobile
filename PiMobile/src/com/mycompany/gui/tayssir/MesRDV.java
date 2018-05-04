/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.tayssir;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.services.tayssir.ServiceRdv;
import java.util.ArrayList;

/**
 *
 * @author tay
 */
public class MesRDV {
       Form f ;
    
            

    public MesRDV(Resources theme, int userid) {
        
              f=new Form(BoxLayout.y());

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
            //list = sr.getTimes(2,date);
            
           
            for(String s : list){
                listDispo.remove(s);
                System.out.println(s);
              //  Label l= new Label()
            }
            
           for(String s : listDispo){
                System.out.println(s); 
                Label l =  new Label(s);
                f.add(l);
                        
                 l.addPointerPressedListener((mo)->{
                    // sr.insertRdv(5, vetid, date,l.getText());
                     
                 });
     //   cnt.setLeadComponent(l);
       
            }    
        
                
       
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
