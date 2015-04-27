// VarianceTest.scala
//
//

package com.example.variancetest

import com.example.datatypes._ 

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class VarianceTest extends FunSpec with ShouldMatchers {

    
    describe("Checking Invariance") {
    
       it("Checking the variance of Class A") {
       
          val tst:InVar[A] = new InVar[A]
      
          tst.toString should be("Invariant")
       
       }
       
      it("Checking the variance of Class B ( Sub Class of A )") {
       
          val tst:InVar[B] = new InVar[B]
      
          tst.toString should be("Invariant")
       
       }  
       
    }
       
       
    describe("Checking Covariance") {
    
      it("Checking the covariance between Class A and Class B ( Sub Class of A )") {
      
       val tst:CoVar[A] = new CoVar[B]
       
       tst.toString should be("Covariant")
      
      
      }
    
    }   
       
       
       
       
        
}
