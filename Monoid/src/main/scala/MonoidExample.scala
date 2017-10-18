// MonoidExample.scala
//
//

import monoid._
import box._

object MonoidExample {


   def main(args: Array[String]): Unit = {

     println("Program started ...")

        // sum the items in a List

        def sum[A: Monoid](xs: List[A]): A = {
             val m = implicitly[Monoid[A]]
             xs.foldLeft(m.identity)(m.append)
          }

        // add two items together

        def howMany[A: Monoid](gm: A, gp: A): A = {
              val n = implicitly[Monoid[A]]
              n.append(gm, gp)

          }

         // Check the identity for Box

         println( Monoid[Box].identity )

         // Check the "+" infix operator defined in the Box class

         println( Box(300) + Box(400) + Box(500))

         // Test the functions defined above

         println( sum( List("a", "b", "c")) )

         println( sum( List( Box(10), Box(20), Box(30))))

         println( howMany( Box(30), Box(40) ))

         // Operations on the contents of the Box

         // - define some functions
         
         val addOne = (b: Box) => Box( b.items + 1 )

         val removeOne = (b: Box) => Box( b.items - 1)

         val doNothing = (b: Box) => Box( b. items )

         implicit val contentsMonoid: Monoid[Box => Box] =
            new Monoid[Box => Box]{

               def identity = doNothing

               def append(m1: Box => Box, m2: Box => Box) = m1 andThen m2

         }

         // - add all of the operations together

         val workOnBox = sum( List(addOne, addOne, addOne, removeOne) )

         println( workOnBox( Box(10) ) )


   }
}
