// HelloWorld.scala
//
// see Tutorial to develop popup: http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
//

package com.example.scalajava


object HelloWorld {

   import com.example.scalaworld._
   import com.example.javaworld._


   
   def main(args: Array[String]): Unit = {
   
   
      val hi = ScalaHelloWorld("Hello")
      
      println(hi.reply)
      
      val hiya = new JavaHelloWorld()
    
      println(hiya.txtOut("the scala approach"))
   
      val window = new JavaPopUp()
      
      window.Define()
      
      window.setVisible(true)
   
   
   }




}
