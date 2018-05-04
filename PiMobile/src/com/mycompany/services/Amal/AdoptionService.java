/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services.Amal;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Amal.Animal;
import com.mycompany.entities.Amal.Request_Adoption;
import com.mycompany.entities.Amal.S_Species;
import com.mycompany.entities.Amal.Species;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



/**
 *
 * @author amalg
 */
public class AdoptionService {
 
    
    public ArrayList<Animal> showAdoption(int user) {
        
        ArrayList<Animal> listZanimo = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/show/"+user);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clÃ© = root et valeur le reste
                    Map<String, Object> zanimo = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    zanimo.put("Animal", zanimo.remove("root"));
                   
                   
                  
                    List<Map<String, Object>> list = (List<Map<String, Object>>) zanimo.get("Animal");
                    for ( Map<String, Object> obj : list) {
                        S_Species s = new S_Species(); 
                        Animal a = new Animal();
                        int id = (int)Float.parseFloat(obj.get("idAnimal").toString());
                        a.setId_animal((int) id);
                        
                        s.setId_s_species((int)Float.parseFloat(obj.get("sSpeciesId").toString().substring(12,15)));
                          
                        a.setS(s);
                        a.setSize((int)Float.parseFloat(obj.get("size").toString()));
                        a.setWeight((int)Float.parseFloat(obj.get("weight").toString()));
                        String myFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
                         
                        String  c="1"+obj.get("age").toString().substring(114,122);
                        int i=c.indexOf("E");
                        String d=c.substring(0, i)+"00";
                        if (d.length()==6){d=d+"0000";}
                        if (d.length()==7){d=d+"000";}
                        if (d.length()==8){d=d+"00";}
                        if (d.length()==9){d=d+"0";}
                        Date date1=new Date(Long.parseLong(d) * 1000L);
                        a.setDescription(obj.get("description").toString());
                        a.setImage1(obj.get("image").toString());
                        a.setNick_Name(obj.get("nickName").toString());
                        a.setColor(obj.get("color").toString());
                        
                        a.setGender(obj.get("gender").toString());
                        
                        
                        listZanimo.add(a);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listZanimo;
    }
    
    public ArrayList<Animal> MyAnimals(int user) {
        
        ArrayList<Animal> listZanimo = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/MyAnimals/"+user);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clÃ© = root et valeur le reste
                    Map<String, Object> zanimo = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    zanimo.put("Animal", zanimo.remove("root"));
                   
                   
                  
                    List<Map<String, Object>> list = (List<Map<String, Object>>) zanimo.get("Animal");
                    for ( Map<String, Object> obj : list) {
                        S_Species s = new S_Species(); 
                        Animal a = new Animal();
                        int id = (int)Float.parseFloat(obj.get("idAnimal").toString());
                        a.setId_animal((int) id);
                        
                        s.setId_s_species((int)Float.parseFloat(obj.get("sSpeciesId").toString().substring(12,15)));
                          
                        a.setS(s);
                        a.setSize((int)Float.parseFloat(obj.get("size").toString()));
                        a.setWeight((int)Float.parseFloat(obj.get("weight").toString()));
                        String myFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
                         
                        String  c="1"+obj.get("age").toString().substring(114,122);
                        int i=c.indexOf("E");
                        String d=c.substring(0, i)+"00";
                        if (d.length()==6){d=d+"0000";}
                        if (d.length()==7){d=d+"000";}
                        if (d.length()==8){d=d+"00";}
                        if (d.length()==9){d=d+"0";}
                        Date date1=new Date(Long.parseLong(d) * 1000L);
                        a.setDescription(obj.get("description").toString());
                        a.setImage1(obj.get("image").toString());
                        a.setNick_Name(obj.get("nickName").toString());
                        a.setColor(obj.get("color").toString());
                        
                        a.setGender(obj.get("gender").toString());
                        
                        
                        listZanimo.add(a);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listZanimo;
    }
    
    public ArrayList<Animal> showAnimal(int id) {
        ArrayList<Animal> listAnimal = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/showAnimal/"+id);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();

                try {
                    //renvoi une map avec clÃ© = root et valeur le reste
                    Map<String, Object> zanimo = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    zanimo.put("Animal", zanimo.remove("root"));
                   
                    List<Map<String, Object>> list = (List<Map<String, Object>>) zanimo.get("Animal");

                    for (Map<String, Object> obj : list) {

                         S_Species s = new S_Species(); 
                        Animal a = new Animal();
                        int id = (int)Float.parseFloat(obj.get("idAnimal").toString());
                        a.setId_animal((int) id);
                        s.setId_s_species((int)Float.parseFloat(obj.get("sSpeciesId").toString().substring(12,15)));
                          
                        a.setS(s);
                        a.setSize((int)Float.parseFloat(obj.get("size").toString()));
                        a.setWeight((int)Float.parseFloat(obj.get("weight").toString()));
                        String myFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
                         
                        String  c="1"+obj.get("age").toString().substring(114,122);
                        int i=c.indexOf("E");
                        String d=c.substring(0, i)+"00";
                        if (d.length()==6){d=d+"0000";}
                        if (d.length()==7){d=d+"000";}
                        if (d.length()==8){d=d+"00";}
                        if (d.length()==9){d=d+"0";}
                        Date date1=new Date(Long.parseLong(d) * 1000L);
                        a.setAge(date1);
                        a.setDescription(obj.get("description").toString());
                        a.setImage1(obj.get("image").toString());
                        a.setNick_Name(obj.get("nickName").toString());
                        a.setColor(obj.get("color").toString());
                        a.setGender(obj.get("gender").toString());
                        listAnimal.add(a);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listAnimal;
    }
    public ArrayList<Species> ShowSpecies()
    {
         ArrayList<Species> listspecies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/ShowSpecies");

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clÃ© = root et valeur le reste
                    Map<String, Object> Species = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Species.put("Species", Species.remove("root"));
                   
                   
                  
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Species.get("Species");
                    for ( Map<String, Object> obj : list) {
                        Species s = new Species();
                        int id = (int)Float.parseFloat(obj.get("speciesId").toString());
                        s.setId_species((int) id);
                        s.setName(obj.get("name").toString());  
                        listspecies.add(s);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listspecies;
    }
    
    public ArrayList<S_Species> ShowSubSpecies(int id)
    {
         ArrayList<S_Species> listspecies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/ShowSubSpecies/"+id);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clÃ© = root et valeur le reste
                    Map<String, Object> Species = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Species.put("SSpecies", Species.remove("root"));
                   
                   
                  
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Species.get("SSpecies");
                    for ( Map<String, Object> obj : list) {
                        S_Species s = new S_Species();
                        int id = (int)Float.parseFloat(obj.get("sSpeciesId").toString());
                        s.setId_s_species((int) id);
                        s.setName(obj.get("name").toString());
                        listspecies.add(s);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listspecies;
    }

    
    public Animal insertAnimal(Animal a,int user)
    {
        ConnectionRequest con = new ConnectionRequest();        
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/AddAnimal/"
                +a.getS().getName()+"/"+
                a.getSize()+"/"+a.getWeight()+"/"+a.getAge()+"/"+a.getDescription()+"/"+a.getImage()+"/"+
                a.getNick_Name()+"/"+a.getColor()+"/"+a.getGender()+"/"+user);
        NetworkManager.getInstance().addToQueueAndWait(con);
        return a;
    }
    
    public void DeleteAnimal(Animal a)
    {
    ConnectionRequest con = new ConnectionRequest();        
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/DeleteAnimal/"+a.getId_animal());
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public Animal UpdateAnimal(Animal a)
    {
     ConnectionRequest con = new ConnectionRequest();        
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/UpdateAnimal/"+a.getId_animal()+
               "/" +a.getS().getName()+"/"+
                a.getSize()+"/"+a.getWeight()+"/"+a.getAge()+"/"+a.getDescription()+"/"+a.getImage()+"/"+
                a.getNick_Name()+"/"+a.getColor()+"/"+a.getGender());
        NetworkManager.getInstance().addToQueueAndWait(con);
        return a;
    }
    
    public void AddWishlist(Animal a,int user)
    {
    ConnectionRequest con = new ConnectionRequest();        
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/AddWishlist/"+a.getId_animal()+"/"+user);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
    public String IsUser(Animal a,int user)
    {
    ArrayList<String> response= new ArrayList();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/IsUser/"+a.getId_animal()+"/"+user);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                    //renvoi une map avec clÃ© = root et valeur le reste
                    String userr;
                try {
                    userr = new String(con.getResponseData(),"utf-8");
                 System.err.println(userr);
                 response.add(userr);

                } catch (IOException ex) {
                }
                                      

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return response.get(0);
    }
    public String isWishlist(Animal a,int user)
    {
        ArrayList<String> response= new ArrayList();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/IsWishlit/"+a.getId_animal()+"/"+user);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                    //renvoi une map avec clÃ© = root et valeur le reste
                  //renvoi une map avec clÃ© = root et valeur le reste
                    String wish;
                try {
                    wish = new String(con.getResponseData(),"utf-8");
                 System.err.println(wish);
                 response.add(wish);

                } catch (IOException ex) {
                }
                      
                                      

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return response.get(0);
    }
    
    public void DeleteWishlist(Animal a,int user)
    {
    ConnectionRequest con = new ConnectionRequest();        
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/DeleteWishlist/"+a.getId_animal()+"/"+user);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
    
     public void AddRequest(Request_Adoption r,int id,int user)
    {
    ConnectionRequest con = new ConnectionRequest();     
    
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/AddRequest/"+id+"/"+r.isRaiser()+"/"+
                r.getLocal()+"/"+r.isGarden()+"/"+r.isSpace()+"/"+r.getPlace()+"/"+r.getCarry()+"/"+
                r.isNeighbour()+"/"+r.isChild()+"/"+r.isTime()+"/"+r.isBreed()+"/"+r.isEngagement()+"/"+
                r.isHabits()+"/"+r.isCharges()+"/"+r.isReady()+"/"+r.isSacrifice()+"/"+r.isFamilly()+"/"+r.getDescription()+"/"+user);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
      public ArrayList<Request_Adoption> ShowRequest(int id)
    {
         ArrayList<Request_Adoption> listspecies = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/ShowRequest/"+id);

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                try {
                    //renvoi une map avec clÃ© = root et valeur le reste
                    Map<String, Object> Request = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    Request.put("Request", Request.remove("root"));
                    
                    List<Map<String, Object>> list = (List<Map<String, Object>>) Request.get("Request");
                    for ( Map<String, Object> obj : list) {
                        Request_Adoption s = new Request_Adoption();
                       int idAnimalOwner = (int)Float.parseFloat(obj.get("idAdoptionAnimal").toString()); 
                       int iduserOwner = (int)Float.parseFloat(obj.get("idAdoptionOwner").toString());
                       int currentuser=(int)Float.parseFloat(obj.get("idAdoptionOwner").toString());
                        String  c="1"+obj.get("dateRequest").toString().substring(114,122);
                        int i=c.indexOf("E");
                        String d=c.substring(0, i)+"00";
                        if (d.length()==6){d=d+"0000";}
                        if (d.length()==7){d=d+"000";}
                        if (d.length()==8){d=d+"00";}
                        if (d.length()==9){d=d+"0";}
                        Date date1=new Date(Long.parseLong(d) * 1000L);
                        s.setDate_request(date1);
                        s.setRaiser((Boolean) Boolean.parseBoolean(obj.get("raiser").toString()));
                        if(obj.get("local").toString().equals("Maison"))
                        {s.setLocal(Request_Adoption.local.Maison);}
                        else{s.setLocal(Request_Adoption.local.Appartement);}
                        s.setGarden((Boolean) Boolean.parseBoolean(obj.get("garden").toString()));
                        s.setSpace((Boolean) Boolean.parseBoolean(obj.get("space").toString()));
                        if(obj.get("place").toString().equals("Exterieur"))
                        {s.setPlace(Request_Adoption.place.Exterieur);}
                        else{s.setPlace(Request_Adoption.place.Dedans);}
                        if(obj.get("carry").toString().equals("Seul"))
                        {s.setCarry(Request_Adoption.carry.Seul);}
                        else{s.setCarry(Request_Adoption.carry.Accompagne);}
                        s.setNeighbour((Boolean) Boolean.parseBoolean(obj.get("neighbour").toString()));
                        s.setChild((Boolean) Boolean.parseBoolean(obj.get("child").toString()));
                        s.setTime((Boolean) Boolean.parseBoolean(obj.get("time").toString()));
                        s.setBreed((Boolean) Boolean.parseBoolean(obj.get("breed").toString()));
                        s.setEngagement((Boolean) Boolean.parseBoolean(obj.get("engagement").toString()));
                        s.setHabits((Boolean) Boolean.parseBoolean(obj.get("habits").toString()));
                        s.setCharges((Boolean) Boolean.parseBoolean(obj.get("charges").toString()));
                        s.setReady((Boolean) Boolean.parseBoolean(obj.get("ready").toString()));
                        s.setSacrifice((Boolean) Boolean.parseBoolean(obj.get("sacrifice").toString()));
                        s.setFamilly((Boolean) Boolean.parseBoolean(obj.get("familly").toString()));
                        s.setDescription(obj.get("description").toString());
                        
                        listspecies.add(s);

                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listspecies;
    }
      
      
      
      public void ValiderReques(int id)
      {
          ConnectionRequest con = new ConnectionRequest();        
        con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/ValiderRequest/"+id);
        NetworkManager.getInstance().addToQueueAndWait(con);
      }
      
      
      public ArrayList<Animal> SearchAdoption(String field) {
        
        ArrayList<Animal> listZanimo = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        if (!field.trim().equals(""))
        { con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/SearchAdoption/"+field);}
        else {con.setUrl("http://localhost/PIWeb33/web/app_dev.php/mobile/SearchAdoption/null");}

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                //listTasks = getListTask(new String(con.getResponseData()));
                JSONParser jsonp = new JSONParser();
                 
                try {String ss=new String(con.getResponseData(),"utf-8");
                if(!ss.equals("{}"))
                    //renvoi une map avec clÃ© = root et valeur le reste
                { Map<String, Object> zanimo = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    zanimo.put("Animal", zanimo.remove("root"));
                   
                   
                  
                    List<Map<String, Object>> list = (List<Map<String, Object>>) zanimo.get("Animal");
                    for ( Map<String, Object> obj : list) {
                        S_Species s = new S_Species(); 
                        Animal a = new Animal();
                        int id = (int)Float.parseFloat(obj.get("idAnimal").toString());
                        a.setId_animal((int) id);
                        
                        s.setId_s_species((int)Float.parseFloat(obj.get("sSpeciesId").toString().substring(12,15)));
                          
                        a.setS(s);
                        a.setSize((int)Float.parseFloat(obj.get("size").toString()));
                        a.setWeight((int)Float.parseFloat(obj.get("weight").toString()));
                        String myFormatString = "yyyy-MM-dd'T'HH:mm:ss.SSSX";
                         
                        String  c="1"+obj.get("age").toString().substring(114,122);
                        int i=c.indexOf("E");
                        String d=c.substring(0, i)+"00";
                        if (d.length()==6){d=d+"0000";}
                        if (d.length()==7){d=d+"000";}
                        if (d.length()==8){d=d+"00";}
                        if (d.length()==9){d=d+"0";}
                        Date date1=new Date(Long.parseLong(d) * 1000L);
                        a.setDescription(obj.get("description").toString());
                        a.setImage1(obj.get("image").toString());
                        a.setNick_Name(obj.get("nickName").toString());
                        a.setColor(obj.get("color").toString());
                        
                        a.setGender(obj.get("gender").toString());
                        
                        
                        listZanimo.add(a);

                    }}
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listZanimo;
    }
}
