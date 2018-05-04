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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 * @author User
 */
public class ServiceArticle {
     public ArrayList<Article> showList() {
        ArrayList<Article> listArticles = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/getArticle.php");
                
       
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> articles = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    articles.put("article", articles.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) articles.get("article");

                    for (Map<String, Object> obj : list) {

                        Article a = new Article();
                   //    float id = Float.parseFloat(obj.get("").toString());
                        
                        a.setTitle_Article(obj.get("Title_Article").toString());
                     //   a.setImg(obj.get("Type").toString());
                        a.setImg(obj.get("image").toString());
                       
                       /* a.setDescription(obj.get("Description").toString());
                        a.setQuantity(Integer.parseInt(obj.get("Quantity").toString()));*/
                        
                        listArticles.add(a);

                    }
                } catch (IOException ex) {
                }

            }
        });
     
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listArticles;
    }
     
  
    
    
   /* public ArrayList<Article> showArticles(int id) {
        ArrayList<Article> listArticles = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/WS/showProduct.php?Id_Product="+id);

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
    }*/
   
    
}
