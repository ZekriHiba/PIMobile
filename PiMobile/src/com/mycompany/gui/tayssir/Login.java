/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.tayssir;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.tayssir.Veto;

/**
 *
 * @author tay
 */
public class Login {

    Form f = new Form("Login", new FlowLayout(Component.CENTER, Component.CENTER));

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    public Login(Resources theme) {
        TextField login = new TextField("", "Login");
        TextField mp = new TextField("", "Mot de passe");
        mp.setConstraint(TextField.PASSWORD);
        Container c = new Container(BoxLayout.y());
        Button b = new Button("Se connecter");
     //  ImageView img = new ImageView(theme.getImage("kh."));
     Label image = new Label(theme.getImage("1.png").scaled(300, 300));
        b.addActionListener(e -> {
            if ((login.getText().trim().isEmpty()) || (mp.getText().trim().isEmpty())) {
                Dialog.show("erreur", "remplir les champs", "", "ok");
            } else {
                Veto v =new Veto();
                ShowVetos ssv = new ShowVetos(theme);
                ssv.getF().show();

            }
        });
        c.add(image);
        c.add(login);
        c.add(mp);
        c.add(b);
        f.add(c);
        f.show();
    }

}
