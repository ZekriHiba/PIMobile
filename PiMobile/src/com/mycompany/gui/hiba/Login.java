/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.mycompany.entities.hiba.Session;
import com.mycompany.entities.hiba.User;
import com.mycompany.services.hiba.ServiceUser;

/**
 *
 * @author Hiba
 */
public class Login {
    
    Form f=new Form("Login",new FlowLayout(Component.CENTER,Component.CENTER));

    public Login() {
        
        f.setUIID("Login");
        f.getToolbar().setVisible(false);
       // f.getStyle().setOpacity(100);
        
        
        
        ServiceUser su=new ServiceUser();
        TextField login=new TextField("","Username");
        TextField pwd=new TextField("","Password");
        Label l=new Label("hhh");
        l.setVisible(false);
        Container c =new Container(BoxLayout.y());
        c.getStyle().setBorder(Border.createLineBorder(1,0x0));
        c.getStyle().setPadding(35, 20, 0, 0);
        login.getStyle().setMargin(0, 1, 1, 1);
        
        l.getStyle().setFgColor(0xff0000);
        Button b=new Button("valider");
        
        
        
        
        b.addActionListener(e-> {
            User u=su.CheckLogin(login.getText(), pwd.getText());
            System.out.println(u);
         if(u.getId()!=0)
        {
            Session.sessionId=u.getId();
             ShowListProduct lp=new ShowListProduct();
             lp.getF().show();
        }
        else
        {
            
            l.setText("Login ou mot de passe incorrect!");
            l.setVisible(true);
        }
        
        });
        
       
        c.add(login);
        c.add(pwd);
        c.add(b);
        c.add(l);
        f.add(c);
        
       
        
        f.show();
    
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
    
    
    
}
