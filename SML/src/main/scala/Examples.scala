// Examples.scala
//
//

package com.example.examples

import either._

object Examples {

    def getQuadResult(r: Either[String, (Double, Double)]): String = r match {
        case Right(solution) => "Root 1 =  " + solution._1.toString + "  Root 2 = " + solution._2.toString
        case Left( msg ) =>  msg
    }

         
  def main(args : Array[String]) {
  
    import com.example.chap1._
    import com.example.chap2._
    import com.example.chap3._
  
    println("Program started ... ")
    
    val chap1 = new Chap1
    
    val chap2 = new Chap2
    
    // Output results
    
    println("Result of fact(6): " + chap1.fact(6) )
    
    println("Result of fib(6): " + chap1.fib(6) )
    
    println("Result of gcd(36, 116): " + chap2.gcd(36, 116) )
    
    // vector calculations

    val a = Vector(1.0, -2.0)
    
    val b = Vector(3.0, 4.0)
        
    println("Adding vectors: " +  (a add b).toString )
    
    println("Subtracting vectors: " + (a sub b).toString )
    
    println("Multiplying a vector: " + ( a mult 2.0 ).toString )
        
    println("Vector product: " + (a prod b).toString )
    
    println("Chapter example: " + ( b sub ( a mult 2.0 ) ).toString )
    
    val quadratic = Quadratic(1.0, 1.0, -2.0)
    
    
    /*
    
    println("Solution for a = 1.0, b = 1.0, c = -2.0 : Root 1 = " + quadratic.solve._1.toString 
                                            + " Root 2 = " + quadratic.solve._2.toString )
    
    
    */
    
    println(quadratic.solve)
    
   
    
    println("Solution for a = 1.0, b = 1.0, c = -2.0 : " + getQuadResult( quadratic.solve ) )  
    

                                
  }
}












  