// HelloWorld.scala
//
// see Tutorial to develop popup: http://zetcode.com/tutorials/javaswingtutorial/firstprograms/
//
// see JAMA for matrix: http://mvnrepository.com/artifact/gov.nist.math/jama/1.0.3
// and some examples: http://math.nist.gov/javanumerics/jama/doc/Jama/Matrix.html
// Commons Math: http://mvnrepository.com/artifact/org.apache.commons/commons-math3/3.4.1
// example for statistics : http://developeriq.in/articles/2014/feb/24/statistical-processing-using-apache-commons-math/
// https://archive.fosdem.org/2013/schedule/event/apache_commons_math/attachments/slides/183/export/events/attachments/apache_commons_math/slides/183/1600_Thomas.pdf
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
