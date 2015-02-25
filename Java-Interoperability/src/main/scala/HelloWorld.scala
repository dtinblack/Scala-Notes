// HelloWorld.scala
//
//

package com.example.scalajava


import java.util.ArrayList
import scala.collection.JavaConverters._

object HelloWorld {

   import com.example.scalaworld._
   import com.example.javaworld._
   
   def main(args: Array[String]): Unit = {
     
      val hi = ScalaHelloWorld("Hello !")
      
      println(hi.reply)
      
      val javaWorld = new JavaHelloWorld()
    
      println(javaWorld.reply("Hello !"))
      
      val listNames = List("NameOne", "NameTwo", "NameThree")
      
      println( listNames )
     
      val javaListNames = new ArrayList( listNames.asJava )
            
      var javaUpperCaseListNames = javaWorld.listToUpperCase( javaListNames )
           
      var listUpperCaseNames = javaUpperCaseListNames.asScala.toList
      
      println( listUpperCaseNames )
              
   }

}
