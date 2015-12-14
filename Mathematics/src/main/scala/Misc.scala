// Misc.scala
//
// Miscellaneous mathematics functions

package misc

package object Miscellaneous {

   def test_print = "Test Miscellaneous"

   // example of an argmax method

   def argMax[A, B: Ordering](input: Iterable[A], f: A => B) = {

       // map 'input' by the function 'f'

       val fList = input map f

       // find the max value

       val maxFList = fList.max

       // To access a zipped list x can use x._1 and x._2
      
       input.view zip fList filter(_._2 == maxFList ) map (_._1) toSet

   }


}
