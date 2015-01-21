// JavaPopUp.java
//
// Testing the use of Java Libraries called from Scala
//

package com.example.javaworld;

import javax.swing.JFrame;

public class JavaPopUp extends JFrame {

     public void Define() {
        
       setTitle("Hello World");
       setSize(300, 200);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
  
}