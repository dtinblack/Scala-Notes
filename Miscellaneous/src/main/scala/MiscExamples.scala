// MiscExample.scala
//
//

package miscexample

import miscellaneous._

object MiscExample {
        
   def main(args: Array[String]): Unit = {

     println("Program started ...")
     
  // send a message when the object has been created.
     
     val oncreate = new SubDerived
     
  // extending a function with a class
     
     val c = new IntToString
             
     println("Value: " + c(3) + "  Data Type: " +  c(3).getClass )
     
  // developing a operators
     
     val name1 = Operator("Hello")
     
     val name2 = Operator("World!")
     
     println( name1 ++ name2 )
     
     println( name1.output("hello") )
     
  // Testing Functional techniques
  
     val funcTest = new Functions   
     
     val lst = List(1,2,3,4,5,6)
     
     /* sum the values ina  List */
     
     val add = (x: Int, y:Int ) => x + y
     
     println( funcTest.reduce(add, lst, 0) )
          
   // difference between a method and a function
    
      val test = new Test
     
      println( test.f5("Hello, World") )
     
   // Polymorphic functions
   
      val func = (x: Int, y: Int) => x + y
      
      val polymorp = new PolymorphicFunctions
      
      println(  polymorp.partial(4, func)(5) ) 
      
      val curry = polymorp.curry( func )
      
      val testCurry = curry(3)(_)
      
      println( testCurry(9) ) 
      
      val uncurry = polymorp.uncurry(curry)
      
      println( uncurry(3,9) )
      
      val f = (x:Int) => x * x
      
      val g = (y: Int) => y + y
      
    // Note - g is followed by f 
                  
      val res = polymorp.compose(f,g)
      
      println( res(3) )
      
    // Higher Ranked Polymorphism
      
      val higherrank = new HigherRank
      
      val square = (x: Int) => x * x
      
      println( higherrank.rankOne( square, 5 ) )
      
      println( higherrank.rankTwo( higherrank.singletonList, 10, "Hello, World!") )
      
    // Ordering example
    
      val listBoxes = List(IntBox(1), IntBox(2), IntBox(3), IntBox(4), IntBox(1))
      
      println( listBoxes )  
                      
      println( boxSort( listBoxes ) )
            
      val b1 = IntBox( 6 )
      
      val b2 = IntBox( 7 )
      
      println( b1 + b2 ) 
      
    // Using an object in the background to manage other objects - see Class Sandpit
        
      val sand = Bucket( Sand( 1 ) ) &: 
                 Bucket( Sand( 2 ) ) &:
                 Bucket( Sand( 3 ) ) &:
                 Empty
                 
      println( sand ) 
      
                            
   }
} 



