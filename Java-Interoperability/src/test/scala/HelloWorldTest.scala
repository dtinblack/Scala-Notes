// HelloWorldTest.scala
//
//


package com.example.scalajavatest

import java.util.ArrayList
import scala.collection.JavaConverters._

import com.example.scalaworld._
import com.example.javaworld._

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class HelloWorldTest extends FunSpec with ShouldMatchers {

    describe("Checking the Scala object") {
    
       it("Checking that the reply() method is working") {
       
          val hello = ScalaHelloWorld("Hello")

          hello.reply should be("Hello from Scala World: Hello")
       
       }
               
    }
    
    
    describe("Checking the Java object") {
    
       it("Checking that the reply() method is working"){
       
         val javaWorld = new JavaHelloWorld()
         
         val result: String = javaWorld.reply("Hello")
  
         result should be("Hello from Java World: Hello")
    
       }  
       
       it("Checking that the method to convert a list to uppercase is working"){
       
         info("still to do")
         
         val javaWorld = new JavaHelloWorld()
         
         val listNames = List("NameOne", "NameTwo", "NameThree")
         
         val javaListNames = new ArrayList( listNames.asJava )
            
         var javaUpperCaseListNames = javaWorld.listToUpperCase( javaListNames )
           
         var listUpperCaseNames = javaUpperCaseListNames.asScala.toList
         
         listNames(0).toUpperCase should equal (listUpperCaseNames(0))
       
       }   
    
    }
    
    
    
    
    
    
  

}
