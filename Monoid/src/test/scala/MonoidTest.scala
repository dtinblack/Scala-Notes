// MonoidTest.scala
//
//


import org.specs2._
import org.scalacheck._

import monoid._
import box._

class BoxMonoid extends Specification with ScalaCheck { def is = s2"""

 This is a specification to check the monoid Box

 The monoid Box should
   should be associative                                         $e1
   have an identity element                                      $e2
   apply append with identity returns the other argument         $e3
                                                                 """

  // (x + y) + z = (z + y) + x

  def e1 = Monoid[Box].append(Monoid[Box].append(Box(10), Box(20)), Box(30)) mustEqual
                       Monoid[Box].append(Monoid[Box].append(Box(30), Box(20)), Box(10))

  def e2 = Monoid[Box].identity mustEqual Box(0)

  // (x + id ) = x

  def e3 = Monoid[Box].append(Monoid[Box].identity, Box(10)) mustEqual Box(10)


} // end of class BoxMonoid
