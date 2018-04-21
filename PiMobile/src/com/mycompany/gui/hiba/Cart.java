/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.ui.ComponentGroup;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Hiba
 */
public class Cart {
    Form f;

    public Cart(Image image) {
        f=new Form("cart",BoxLayout.y());
        
         ComponentGroup cg=new ComponentGroup();
        for(int j=0;j<5;j++)
        {
            Container c4 =new Container(BoxLayout.x());
            ImageViewer iv=new ImageViewer();
            iv.setImage(image.scaled(80, 80));
            c4.add(iv);
            c4.add(new Label("nom"));
            c4.add(new Label("price"));
            c4.add(new TextField("1","quantite"));
            
            
            cg.add(c4);
        }
        f.add(cg);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
}
