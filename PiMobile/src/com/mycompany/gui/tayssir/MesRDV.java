/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui.tayssir;

import com.codename1.components.ImageViewer;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.tayssir.Rdv;
import com.mycompany.entities.tayssir.Veto;
import com.mycompany.services.tayssir.ServiceRdv;
import com.mycompany.services.tayssir.ServiceVeto;
import java.util.ArrayList;

/**
 *
 * @author tay
 */
public class MesRDV {
       Form f ;
    
            

    public MesRDV(Resources theme, int userid) {
        f = new Form ();
        
        
        ServiceRdv sr=new ServiceRdv();
        ArrayList<Rdv> list=sr.getRDVByUser(userid);
        int i=0;
        
        ServiceVeto sv = new ServiceVeto();
        for(Rdv rdv : list){
        Container cnt = new Container(BoxLayout.x());
        
        Label  l  =  new Label();
        
       
       
        
        }
        
    }
        
    
    
    


    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
