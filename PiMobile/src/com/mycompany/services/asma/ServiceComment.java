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
import com.mycompany.entities.asma.Comment;
import com.mycompany.entities.asma.Feed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author User
 */

public class ServiceComment {
    

   public ArrayList<Comment> showComments( String title_feed) {
        ArrayList<Comment> listComment = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/getFeedByTitle?feed_id="+title_feed);
       
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> comment = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    comment.put("comment", comment.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) comment.get("comment");

                    for (Map<String, Object> obj : list) {

                        Comment c = new Comment();
                        c.setCorp(obj.get("corp").toString());
                        
                        listComment.add(c);

                    }
                } catch (IOException ex) {
                }

            }
        });
     
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listComment;
    }
   
   public void insertComment(int userId , String feedId ,String corp) {
         
        boolean  succes = false;
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/WS/insertComment.php?user_ID="
                + userId
                + "&feed_ID=" 
                + feedId
               + "&corp=" 
                + corp ;
        con.setUrl(url);
        System.out.println(url);        
        con.addResponseListener((NetworkEvent evt) -> {
            byte[] data = (byte[]) evt.getMetaData();
            String s = new String(data);
            System.out.println(s);
            if (s.equalsIgnoreCase("success")) {
            }
            else {
            }        
        });
        
        NetworkManager.getInstance().addToQueueAndWait(con);
      //  return succes;
    }

     
    
    
}
