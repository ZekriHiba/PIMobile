/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entities.hiba.User;
import com.mycompany.services.hiba.ServiceUser;

/**
 *
 * @author Hiba
 */
public class Login {
    
    Form f=new Form(BoxLayout.y());

    public Login() {
        
        ServiceUser su=new ServiceUser();
        TextField login=new TextField();
        TextField pwd=new TextField();
        Label l=new Label("hhh");
        l.setVisible(false);
        Container c =new Container(BoxLayout.y());
        
        l.getStyle().setFgColor(0xff0000);
        Button b=new Button("valider");
        
        
        
        
        b.addActionListener(e-> {
            User u=su.CheckLogin(login.getText(), pwd.getText());
            System.out.println(u);
         if(u.getId()!=0)
        {
             ShowListProduct lp=new ShowListProduct();
             lp.getF().show();
        }
        else
        {
            
            l.setText("Login ou mot de passe incorrect!");
            l.setVisible(true);
        }
        
        });
        
       
        f.add(login);
        f.add(pwd);
        f.add(l);
        f.add(b);
       
        
        f.show();
    
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
