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
import com.mycompany.entities.tayssir.Rdv;
import com.mycompany.entities.tayssir.Veto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author tay
 */
public class ServiceRdv {
     public ArrayList<String> getTimes(int id , String date) {
        ArrayList<String> listVetos = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://192.168.72.1/WS/dispo.php?id="
                + id 
                + "&date=" 
                + date);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> vetos = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    vetos.put("times", vetos.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) vetos.get("times");

                    for (Map<String, Object> obj : list) {
                       
                       
                        
                        listVetos.add(obj.get("time").toString());

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVetos;
    }
     
     public void insertRdv(int userid , int vetid ,String date,String time) {
         
         boolean  succes = false;
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://192.168.72.1/WS/insertRDV.php?user_id="
                + userid
                + "&vetid=" 
                + vetid
               + "&date=" 
                + date
                + "&time=" 
                + time
        
        );
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
     
      public ArrayList<Rdv> getRDVByUser(int id ) {
        ArrayList<Rdv> listRDV = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/getRDVbyUser?id="+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> vetos = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    vetos.put("rdv", vetos.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) vetos.get("rdv");

                    for (Map<String, Object> obj : list) {
                       
                        Rdv rdv = new Rdv();
                      /*  rdv.set(Float.parseFloat(obj.get("lat").toString()));
                        rdv.setLongit(Float.parseFloat(obj.get("longit").toString()));
                        rdv.setId((int) Float.parseFloat(obj.get("id").toString()));
                        rdv.setPhone((int) Float.parseFloat(obj.get("phone").toString()));
                        rdv.setVue((int) Float.parseFloat(obj.get("vue").toString()));
                        rdv.setPrix((int) Float.parseFloat(obj.get("prix").toString()));
                        rdv.setNom(obj.get("nomp").toString());
                        rdv.setMail(obj.get("mail").toString());
                        rdv.setVille(obj.get("ville").toString());
                        rdv.setDescription(obj.get("description").toString());

                        rdv.setGouv(obj.get("gouv").toString());
                        rdv.setImage(obj.get("image").toString());
                       
                        
                        
                        listRDV.add(rdv);*/

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listRDV;
    }
     
     
     
     
     
}


