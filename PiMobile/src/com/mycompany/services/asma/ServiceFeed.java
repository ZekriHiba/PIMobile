/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.asma;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.asma.Article;
import com.mycompany.entities.asma.Feed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */
public class ServiceFeed {

    public ArrayList<Feed> showList() {
        ArrayList<Feed> listFeed = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/getFeed.php");
                
       
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> feed = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    feed.put("feed", feed.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) feed.get("feed");

                    for (Map<String, Object> obj : list) {

                        Feed f = new Feed();
                   //    float id = Float.parseFloat(obj.get("").toString());
                        
                        f.setTitle(obj.get("Title").toString());
                   //     f.setComment(obj.get("comment").toString());
                        f.setImage(obj.get("Image").toString());
                       
                       /* a.setDescription(obj.get("Description").toString());
                        a.setQuantity(Integer.parseInt(obj.get("Quantity").toString()));*/
                        
                        listFeed.add(f);

                    }
                } catch (IOException ex) {
                }

            }
        });
     
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listFeed;
    }
     
  
    
    
    
}
