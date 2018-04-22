/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities.hiba;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




/**
 *
 * @author Hiba
 */
public class Panier {
    public static Panier instance;
    
  // public Map<User,List<Command_Line>> p=new HashMap<User,List<Command_Line>>();
    public List<Command_Line> p=new ArrayList();
    

    public Panier() {
    }

    public static Panier getInstance()
    {
        if(instance == null)
        {
            instance=new Panier();
        }
        return instance;
        
    }
    
    public void addLine(Command_Line c)
    {
        if(search(c)==false)
        {
            p.add(c);
        }
        else
        {
            for(Command_Line c1:p)
             {
               if(c1.equals(c))
                 {
                     c1.quantity++;
                 }
             }
        }
            
    }
    public void deleteCart()
    {
        p.removeAll(p);
         
    }
    public void removeLine(Command_Line c)
  {
      p.remove(c); 
     
  }
    
    public void show()
    {
       
       for(Command_Line c:p)
       {
           System.out.println(c.toString());
       }
    }
    
    public boolean search(Command_Line c)
    {
     for(Command_Line c1:p)
       {
           if(c.getLine_id()==c1.getLine_id())
               return true;
       }
     return false;
    }
    
   
    
}
