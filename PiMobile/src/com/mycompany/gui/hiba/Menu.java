/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;

/**
 *
 * @author Hiba
 */
public class Menu {
    
    Form f;
    int i;

    public Menu(Form f) {
        this.f=f;
        i=0;
        Toolbar tb=f.getToolbar();
        tb.getSideMenuCommands();
        //****************Sous Menu Boutons******************************************************************
        
        //***********************AMAL****************************************************************************
         Button b1=new Button("Mes Zanimo");
        Button b2=new Button("Mes Zanimo");
        Button b3=new Button("Mes Zanimo");
        
        Container c=new Container(BoxLayout.y());
       
        
       
        b1.setVisible(false);
        b2.setVisible(false);
        b3.setVisible(false);
        //***********************ASMA****************************************************************************
        Button b4=new Button("Mes Zanimo");
        Button b5=new Button("Mes Zanimo");
        Button b6=new Button("Mes Zanimo");
        
        Container c2=new Container(BoxLayout.y());
       
        
       
        b4.setVisible(false);
        b5.setVisible(false);
        b6.setVisible(false);
        
        //***********************FIRAS****************************************************************************
        
        
        //***************************************************************************************************
        
        tb.addMaterialCommandToSideMenu("home",FontImage.MATERIAL_HOME, (e)->{});
        tb.addMaterialCommandToSideMenu("Actualités",FontImage.MATERIAL_WEB, (e)->{
            if(i==0 && b4.isVisible()==false)
            {
               
              c2.add(b4);
              c2.add(b5);
              c2.add(b6);
               b4.setVisible(true);
               b5.setVisible(true);
               b6.setVisible(true);
                i=1;
                
            }
            else
            {
                i=0;
                
               b4.setVisible(false);
               b5.setVisible(false);
               b6.setVisible(false);
               b4.remove();
               b5.remove();
               b6.remove();
            }
        tb.openSideMenu();
        
        });
        tb.addComponentToSideMenu(c2);
        tb.addMaterialCommandToSideMenu("Réclamation",FontImage.MATERIAL_ANNOUNCEMENT, (e)->{});
        tb.addMaterialCommandToSideMenu("Achats",FontImage.MATERIAL_ADD_SHOPPING_CART, (e)->{
        ShowListProduct t=new ShowListProduct();
        t.getF().show();
        });
        
        tb.addMaterialCommandToSideMenu("Adoption",FontImage.MATERIAL_SEARCH, (e)->{
            
            if(i==0 && b1.isVisible()==false)
            {
               
              c.add(b1);
              c.add(b2);
              c.add(b3);
               b1.setVisible(true);
               b2.setVisible(true);
               b3.setVisible(true);
                i=1;
                System.out.println("i premier click bout:"+i); 
            }
            else
            {
                i=0;
                System.out.println("i 2eme click bout:"+i);
                b1.setVisible(false);
               b2.setVisible(false);
               b3.setVisible(false);
               b1.remove();
               b2.remove();
               b3.remove();
            }
        tb.openSideMenu();
        });
        tb.addComponentToSideMenu(c);
        tb.addMaterialCommandToSideMenu("Gérer membre",FontImage.MATERIAL_ACCOUNT_BOX, (e)->{});
    }

   

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
}
