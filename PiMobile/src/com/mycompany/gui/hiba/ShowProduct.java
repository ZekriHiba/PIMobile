/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author Hiba
 */
public class ShowProduct {
    Form  f;

    public ShowProduct(Image image) {
        f=new Form("");
        
        ImageViewer iv=new ImageViewer();
        iv.setImage(image.scaled(200, 200));
        Container c=new Container(BoxLayout.y());
        Button b=new Button("add cart");
         
         b.addActionListener(e->{
          Cart cart=new Cart();
          cart.getF().show();
        });
        c.add(new Label("nom"));
        c.add(new Label("description"));
        c.add(b);
        f.add(iv);
        f.add(c);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
}
