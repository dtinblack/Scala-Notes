// ODESolver.scala
//
//

package odesolver

import matrix.Matrix._

package object ODESolver {

 // Non functional example

 
 def LinearODE_Euler(const: Matrix, func: Matrix)(step: Double, iterations: Int)(start: Matrix): Matrix = {
    
    var variables = start
     
    var X_new = start 
    
    var X_next = List[List[Double]]()       // just to intialise the variable
    
    var res = (0.0::Nil)::start             // add time to the results matrix
        
    for ( i <- 1 until iterations ) {
        
       X_next = X_new + scalerXm( step, const + func * X_new )
             
       X_new = X_next
    
       res = addColumn(res, (step*i.toDouble::Nil)::X_next)
    
    } 

    res
                  
 }   

}