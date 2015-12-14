// Misc.scala
//
// Miscellaneous mathematics functions

package misc

package object Miscellaneous {

   def test_print = "Test Miscellaneous"

   // example of an argmax method

   def argMax[A, B: Ordering](input: Iterable[A], f: A => B) = {

       val fList = input map f
       
       val maxFList = fList.max

       input.view zip fList filter(_._2 == maxFList ) map (_._1) toSet

   }


}
