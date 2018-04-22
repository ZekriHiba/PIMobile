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
import com.mycompany.entities.hiba.Product;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Hiba
 */
public class ServiceProduct {
    
    
    
    public ArrayList<Product> showList() {
        ArrayList<Product> listProducts = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/piMobile/showListProduct.php");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> products = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    products.put("product", products.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) products.get("product");

                    for (Map<String, Object> obj : list) {

                        Product p = new Product();
                        float id = Float.parseFloat(obj.get("Id_Product").toString());
                        
                        p.setId_product((int) id);
                        p.setName(obj.get("Name").toString());
                        p.setPrice(Float.parseFloat(obj.get("Price").toString()));
                        p.setImg(obj.get("Type").toString());
                        p.setImg(obj.get("Image").toString());
                        p.setDescription(obj.get("Description").toString());
                        p.setQuantity(Integer.parseInt(obj.get("Quantity").toString()));
                        
                        listProducts.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProducts;
    }
    
    
    public ArrayList<Product> showProduct(int id) {
        ArrayList<Product> listProducts = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/piMobile/showProduct.php?Id_Product="+id);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> products = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    products.put("product", products.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) products.get("product");

                    for (Map<String, Object> obj : list) {

                        Product p = new Product();
                        float id = Float.parseFloat(obj.get("Id_Product").toString());
                        
                        p.setId_product((int) id);
                        p.setName(obj.get("Name").toString());
                        p.setPrice(Float.parseFloat(obj.get("Price").toString()));
                        p.setImg(obj.get("Type").toString());
                        p.setImg(obj.get("Image").toString());
                        p.setDescription(obj.get("Description").toString());
                        p.setQuantity(Integer.parseInt(obj.get("Quantity").toString()));
                        
                        listProducts.add(p);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProducts;
    }
    
    
    
}
