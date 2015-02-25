// JavaHelloWorld.java
//
//

package com.example.javaworld;

import java.util.ArrayList; 
import java.util.List;

public class JavaHelloWorld{
  
  public String reply( String msg ) { return "Hello from Java World: " + msg; }
    
  public ArrayList<String> listToUpperCase( ArrayList<String> list ) { 
  
         int length = list.size();
                  
         for( int i = 0; i < list.size(); i++ ) {
                    
           list.set(i , list.get(i).toUpperCase());
          
          }
  
         return list; }

}
