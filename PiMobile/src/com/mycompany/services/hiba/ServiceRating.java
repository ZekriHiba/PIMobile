/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.hiba;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.hiba.Rating;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hiba
 */
public class ServiceRating {
    public void addRate(Rating r ) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/piMobile/addRate.php?rate="+r.getRate()+"&Id_Product="+r.getId_product()+"&User_id=" +r.getId_user();
        con.setUrl(Url);

        System.out.println(r);

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            System.out.println(str);
//            if (str.trim().equalsIgnoreCase("OK")) {
//                f2.setTitle(tlogin.getText());
//             f2.show();
//            }
//            else{
//            Dialog.show("error", "login ou pwd invalid", "ok", null);
//            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    


 public int showRate(int id) {
        ArrayList<Integer> listrate = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/piMobile/showRate?Id_Product="+Integer.toString(id));

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> products = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    products.put("rate", products.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) products.get("rate");

                    for (Map<String, Object> obj : list) {

                        int i=Integer.parseInt(obj.get("r").toString());
                        
                        
                        listrate.add(i);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        
        int rate=0;
        for(int i :listrate)
        {
            rate=i;
        }
        return rate;
    }
}
