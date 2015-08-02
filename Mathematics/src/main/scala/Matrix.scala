// Matrix.scala
//
// Matrix manipulation
//

package matrix

package object Matrix {
  
  type Row = List[Double]
  
  type Matrix = List[Row]
      
  // Add rows
  
  def addRow(r1: List[Double], r2: List[Double]) = 
     r1.zip(r2).map{t:(Double,Double) => t._1 + t._2}
     
  // Subtract rows
  
  def subRow(r1: List[Double], r2: List[Double]) = 
     r1.zip(r2).map{t:(Double,Double) => t._1 - t._2}   
     
  
  // Dot product
  
  def dotProd(v1: Row, v2:Row) =
     v1.zip( v2 ).                               // (x1,x2,) (y1,y2) => (x1,y1)(x2,y2)
     map{ t:(Double,Double) => t._1 * t._2 }.    // (x1 * y1) (x2 * y2)
     reduceLeft(_ + _)                           // (x1 * y1) + (x2 * y2) 
     
 
  // Transpose matrix
  
  def transpose(m: Matrix): Matrix = 
   if(m.head.isEmpty) Nil
   else m.map(_.head) :: transpose(m.map(_.tail))
 
 
  // Matrix Multiplication
  
   def mXm( m1: Matrix, m2: Matrix ) =
     for(m1row <- m1) yield
     for( m2col <- transpose(m2)) yield
     dotProd(m1row, m2col)
 
 
  // Add matrices
     
  def addMatrix(m1: Matrix, m2: Matrix) = 
           ( m1 zip m2 map( t => ((t._1 zip t._2)).map( x => ( x._1 + x._2 ))))
           
  
  // Multiply Matrix by a Scaler
  
  
  def scalerXm( scaler: Double, m: Matrix ): Matrix = {
        if(m.isEmpty) Nil
         else m.head.map( _ * scaler )::scalerXm( scaler, m.tail)        
   }
  
  
  // Add Columns to Matrix which increases the size of the matrix
  // Note assuming the number of the rows are the same
  
  def addColumn(m1: Matrix, m2: Matrix): Matrix = {
     if(m1.isEmpty) Nil
       else (m1.head:::m2.head)::addColumn(m1.tail, m2.tail)
  } 
  
  
  // Invert Matrix
  
  // TODO         
           
           
  // Define Matrix operators         
           
  case class TestMatrix(m: Matrix){
            
     def T = transpose( m )
   
     def +(that: TestMatrix) = addMatrix(this.m, that.m) 
     
     def *(that: TestMatrix) = mXm( this.m, that.m )        
   
   }
   
  implicit def pimp(m:Matrix) = new TestMatrix(m) 
                                 
  def index(m: Matrix, i: Int, j: Int) = m(i)(j) // Note 0 = 1
       
  // Matrix size
  
  def rowCount(m:Matrix) = m.length
  
  def colCount(m: Matrix) = m.head.length
    
  // Convert to a String
    
  def toStr (m: Matrix ) = "\n" + m.map {
      _.map{"\t" + _ }.reduceLeft(_ + _) + "\n"
    }.reduceLeft(_ + _) 
    
}

