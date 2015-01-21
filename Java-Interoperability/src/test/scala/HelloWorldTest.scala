// HelloWorldTest.scala
//
//


package com.example.scalajavatest

import com.example.scalaworld._
import com.example.javaworld._

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class HelloWorldTest extends FunSpec with ShouldMatchers {

    describe("Checking the function of an object") {
    
       it("checking that the test is working") {
       
          val hi = ScalaHelloWorld("Hello")
       
          val text: String = "Hello"
       
          hi.reply should be("Scala World: Hello")
       
       }
               
    }
    
    
    describe("Added a second test") {
    
       it("checking that a second test could be added"){
       
         val test: String = "Hello"
         
         info("string defined")
       
         test should be("Hello")
    
       }     
    
    }
  

}
