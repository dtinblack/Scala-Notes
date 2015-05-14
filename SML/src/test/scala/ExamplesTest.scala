// ExamplesTest.scala
//
//

package com.example.examplestest

import com.example.chap4._ 

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class VarianceTest extends FunSpec with ShouldMatchers {

    
    describe("Checking Rational Arithmetic") {
    
       it("Checking addition") {
       
       val rat1 = Rational(1,2)
       
       val rat2 = Rational(1,4)
       
       val addition = rat1 add rat2
       
       addition.toString should be("6/8")
       
       }
               
    }
        
}








  