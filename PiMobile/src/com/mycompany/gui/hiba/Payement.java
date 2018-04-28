/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.hiba;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.FlowLayout;
import com.mycompany.entities.hiba.Command_Line;
import com.mycompany.entities.hiba.Panier;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Hiba
 */
public class Payement {
    Panier pan = Panier.getInstance();
    Label prix ;
    Form f;
    ImageViewer Pdp;
    TextField card ;
TextField NomProd;
    String c = "";
    ImageViewer iv;
    int p=0;
    
    public Payement() throws IOException
    {
         f=new Form("Payment",new FlowLayout(Component.CENTER,Component.CENTER));
         Menu m=new Menu(f);
         
        // f.setUIID("Payement");
         
        /* try{
        
        iv.setImage(Image.createImage("/stripe.jpg"));
         } catch (IOException ex) {
                System.out.println("err");
            }*/ 
              

         
         
         card=new TextField("","Card number");
         
         Container c1=new Container(new FlowLayout(Component.CENTER,Component.CENTER));
          Container c2=new Container(new FlowLayout(Component.CENTER,Component.CENTER));
          
        
         Panier panier=Panier.getInstance();
         for(Command_Line c:panier.p)
         {
             p+=c.getQuantity()*c.getProduct().getPrice();
         }
          prix=new Label("$"+Float.toString(p));
         
          Button bt=new Button("VALIDER");
//         c1.add(iv);
         c1.add(prix);
         c1.add(card);
         c2.add(bt);
        
         f.add(c1);
         f.add(c2);
         
             bt.addActionListener(e->{ 
              
                      payer();
                      Cart c=new Cart();
                      c.getF().show();
               
               });
      
       
    }
    
    

    public void payer() 
    {
        if (card.getText().equals("4000000000000119")) {
            c = "tok_mastercard";
        }
        if (card.getText().equals("4242424242424241")) {
            c = "tok_visa";
        }
        if (card.getText().equals("4000000000000069")) {
            c = "tok_visa_debit";
        }

        if (card.getText().equals("4000000000000101")) {
            c = "tok_mastercard_prepaid";
        }

        if ((card.getText().equals("4000000000000119")) || (card.getText().equals("4242424242424241")) || (card.getText().equals("4000000000000069")) || (card.getText().equals("4000000000000101"))) {
            try {
                
                int a = (int) Integer.parseInt(NomProd.getText());
                System.out.println("LE MONTANT A PAYER EST ===>"+a);
                Stripe.apiKey = "sk_test_73RHI91LtuRlMJQlmYtGp1sB";
                Map<String, Object> chargeParams = new HashMap<String, Object>();

                chargeParams.put("amount", a * 100);
                chargeParams.put("currency", "usd");
                chargeParams.put("description", "Charge for hiba");
                chargeParams.put("source", c);
                Charge.create(chargeParams);

            } catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException | APIException ex) {
                System.out.println("Erreur1");
            }

           
            Panier panier = Panier.getInstance();
            panier.p.clear();

        } else {
            System.out.println("Erreur1");
        }
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
}
