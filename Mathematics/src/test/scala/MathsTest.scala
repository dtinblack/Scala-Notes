// ODETest.scala
//
// Testing Matrix and ODE Routines
//
// TO DO:
//
// - Tests are currently by example - could explore ScalaCheck and custom generate
//   a range of matrices to test the operations
//
//

package com.example.ODETest


import org.specs2.mutable._

import com.maths.Matrix._

class ODETest extends Specification {

   "A Matrix" should { 
     """Calculate the number of rows""" in {
     
     val MatrixTest = List(List(1.0, 2.0, 3.0),
                      List(4.0, 5.0, 6.0),
                      List(7.0, 8.0, 9.0))
     
     
     colCount(MatrixTest) must be_==( 3 )
   
   
     } 
     
    """Calculate the number of columns""" in {
    
     val MatrixTest = List(List(1.0, 2.0, 3.0),
                      List(4.0, 5.0, 6.0),
                      List(7.0, 8.0, 9.0))
     
     rowCount(MatrixTest) must be_==( 3 )
       
    
    } 
   
   }
   
   "Another Matrix Test" should {
   
     """Transpose a Matrix """ in {
    
     val MatrixTest = List(List(1.0, 2.0, 3.0),
                      List(4.0, 5.0, 6.0),
                      List(7.0, 8.0, 9.0))
                      
     val Answer = List(List(1.0, 4.0, 7.0),
                       List(2.0, 5.0, 8.0),
                       List(3.0, 6.0, 9.0))                  
                      
     val TMatrixTest = transpose(MatrixTest)                
                      
     TMatrixTest must_== Answer                 
            
    
    } 
   
   
   
   }
            

  
} // End of ODETest