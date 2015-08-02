// MathsExamplea.scala
//
//

package mathsexamples

import matrix.Matrix._
import odesolver.ODESolver._


object MathsExamples {
            
  def main(args: Array[String]) {
                         
  println("Program started")
  
  // Matrix manipulation
  
  val MatrixTest = List(List(1.0, 2.0, 3.0),
                        List(4.0, 5.0, 6.0),
                        List(7.0, 8.0, 9.0))
                      
  println(toStr(MatrixTest))
  
  val TMatrixTest = transpose(MatrixTest)                    
                      
  println(toStr(TMatrixTest)) 
  
  println(toStr(MatrixTest * TMatrixTest))                   
  
  val columnVector = List(List(1.0),
                          List(2.0),
                          List(3.0))
   
  println(toStr(columnVector))
  
  println(toStr(MatrixTest * columnVector))
  
  println(toStr( scalerXm(4.0, MatrixTest) ) )
  
  println(toStr( scalerXm(21.0, columnVector) ) )
  
    
 // ODE Example 
 
  val A = List(List(1.5),
               List(3.0))

  val B = List(List(-0.1, 0.075),
               List( 0.1,  -0.2))
  
  val X_0 = List(List(25.0),
                 List(15.0))
                  
 
  val testODE = LinearODE_Euler(A, B) _ 
   
  // Use a step size of 0.1, and do 10 steps
    
  val range = testODE(0.1, 10)
  
  // Use the start values

  val result = range(X_0)
  
  println(toStr(result))
    
  } 
  
} 