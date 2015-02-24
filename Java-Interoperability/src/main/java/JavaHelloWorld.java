// JavaHelloWorld.java
//
//
// passing values : http://alvinalexander.com/scala/passing-scala-arrays-java-methods-code
//
// http://stackoverflow.com/questions/2429944/how-to-convert-a-scala-list-to-a-java-util-list
// recent blog: http://blog.madhukaraphatak.com/converting-java-collections-to-scala/
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
