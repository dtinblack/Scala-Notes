// Monoid.scala
//
//


package monoid

import box._

trait Monoid[A] {

   def append(a: A, b: A): A
   def identity: A

}

object Monoid {

            implicit val IntMonoid: Monoid[Int] = new Monoid[Int] {
                 def append(a: Int, b: Int): Int = a + b
                 def identity : Int = 0
             }

            implicit val StringMonoid: Monoid[String] = new Monoid[String] {
               def append(a: String, b: String): String = a + b
               def identity: String = ""
             }

            implicit val BoxMonoid: Monoid[Box] = new Monoid[Box]{
               val identity:Box = Box(0)
               def append(b1: Box, b2: Box): Box = Box(b1.items + b2.items)

             }

             def apply[A](implicit F: Monoid[A]): Monoid[A] = F

}
