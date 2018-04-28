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
import com.mycompany.entities.hiba.User;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hiba
 */
public class ServiceUser {
      public User CheckLogin(String username, String password) {
     
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/piMobile/login.php?login="+username+"&pass="+password+"");

        User user = new User();
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp = new JSONParser();

                try {

                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> products = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    products.put("user", products.remove("root"));
               
                    List<Map<String, Object>> list = (List<Map<String, Object>>) products.get("user");

                    for (Map<String, Object> obj : list)
                    {
      
                        float id = Float.parseFloat(obj.get("id").toString());
                        user.setId((int) id);           
                        user.setUsername(obj.get("username").toString());
                        user.setPassword(obj.get("password").toString());
                  

                    }
                   
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return user;
    }
    
}
