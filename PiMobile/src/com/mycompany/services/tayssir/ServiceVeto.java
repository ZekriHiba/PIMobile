/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.tayssir;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.hiba.Product;
import com.mycompany.entities.tayssir.Veto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tay
 */
public class ServiceVeto {
     public ArrayList<Veto> showVetos() {
        ArrayList<Veto> listVetos = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/getVetos.php");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> vetos = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    vetos.put("veto", vetos.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) vetos.get("veto");

                    for (Map<String, Object> obj : list) {

                        Veto v = new Veto();
                        v.setLat(Float.parseFloat(obj.get("lat").toString()));
                        v.setLongit(Float.parseFloat(obj.get("longit").toString()));
                        v.setId((int) Float.parseFloat(obj.get("id").toString()));
                        v.setPhone((int) Float.parseFloat(obj.get("phone").toString()));
                        v.setVue((int) Float.parseFloat(obj.get("vue").toString()));
                        v.setPrix((int) Float.parseFloat(obj.get("prix").toString()));
                        v.setNom(obj.get("nomp").toString());
                        v.setMail(obj.get("mail").toString());
                        v.setVille(obj.get("ville").toString());
                        v.setDescription(obj.get("description").toString());
                        v.setGouv(obj.get("gouv").toString());
                        v.setImage(obj.get("image").toString());
                       
                        
                        listVetos.add(v);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVetos;
    }
     
     
     public void addView(int id) {
        ArrayList<Veto> listVetos = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/increaseView?id="+id);

      
      
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
     
     
          public ArrayList<Veto> showVetosByName(String nom) {
        ArrayList<Veto> listVetos = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/searshName?nom="+nom);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> vetos = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    vetos.put("veto", vetos.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) vetos.get("veto");

                    for (Map<String, Object> obj : list) {

                        Veto v = new Veto();
                        v.setLat(Float.parseFloat(obj.get("lat").toString()));
                        v.setLongit(Float.parseFloat(obj.get("longit").toString()));
                        v.setId((int) Float.parseFloat(obj.get("id").toString()));
                        v.setPhone((int) Float.parseFloat(obj.get("phone").toString()));
                        v.setVue((int) Float.parseFloat(obj.get("vue").toString()));
                        v.setPrix((int) Float.parseFloat(obj.get("prix").toString()));
                        v.setNom(obj.get("nomp").toString());
                        v.setMail(obj.get("mail").toString());
                        v.setVille(obj.get("ville").toString());
                        v.setDescription(obj.get("description").toString());
                        v.setGouv(obj.get("gouv").toString());
                        v.setImage(obj.get("image").toString());
                       
                        
                        listVetos.add(v);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVetos;
    }
    
     
     
     
     
     
     
     
     
    
    
}
