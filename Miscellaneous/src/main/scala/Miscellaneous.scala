// Miscellaneous.scala
//
//

package miscellaneous

// sending out a message when the object has been created.

trait OnCreate extends DelayedInit {
  
  def onCreate:Unit
   
  def delayedInit(body: => Unit) = {
    
    body
     
    if ((body _).getClass.getDeclaringClass == this.getClass)
    {
      onCreate
    }
  }
}
 
class Derived extends OnCreate {
  def onCreate = println("Creation is fully complete")
  val x = ""
  println("Derived complete")
}
 
class SubDerived extends Derived {

  val y = ""
  println("SubDerived complete")


}

// Example of exetending a function with a class

        class IntToString extends ( Int => String ) {
             def apply(i: Int):String = i.toString } 

//        or more explicitly
//       
//        class IntToStringConverter extends Function1[Int, String] {
//               def apply(i: Int): String = i.toString }
 
// Example of methods to manipulate objects

case class Operator( op: String ) {

  def ++ (that: Operator): String = (this, that ) match { 
      case (Operator(s1), Operator(s2)) => s1 + " " + s2
      }   
      
  def output(str: String): String = p"$str" 
      
  implicit class Output(val sc: StringContext) {
    def p(args: String) = sc.s( args + " world!" )
  }
      
}

// Checking functional techniques

class Functions {


  def reduce(f:(Int, Int) => Int, l: List[Int], s:Int):Int = l match {
      case Nil => s
      case a::b::tail => reduce(f, tail, s + f(a, b) )
      case _ => -9999
  } 

}

// Difference between a method and a function

class Test {

     def m1(x:Int) = x+3
     
     // function has Function1 interface with methods such as 'apply' therefore it can be used as f1(3)
     
     val f1 = (x:Int) => x+3
     
     // can make a function from a method which will use the Function1 interface
     
     val f2 = m1 _
     
     //  A method can be type-parameterized, but an anonymous function can not
     
     def m2[T](x:T) = x.toString.substring(0,4)
     
     class myFunc[T] extends Function1[T, String] {
    
       def apply(x:T) = x.toString.substring(0,4)
    } 
    
    val f5 = new myFunc[String]
     
}

// Taken from "Functional Programming In Scala - Section 2.6

class PolymorphicFunctions {

     def partial[A,B,C](a:A, f: (A,B) => C): B => C = 
            b => f(a,b)


     def curry[A,B,C](f: (A, B) => C): A => (B => C) = a => b => f(a,b)
     
     def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)
          
     def compose[A,B,C](f: B => C, g: A => B ): A => C = a => f(g(a)) 


}


// Higher-Rank Polymorphisim

class HigherRank {   
   def rankOne[A](f: A => A, a: A ): A = f(a)
   
   trait ~>[F[_],G[_]] {
     def apply[A](a: F[A]): G[A]
    }

    type Id[A] = A
    
    val singletonList = new (Id ~> List) {
      def apply[A](a: A): List[A] = List(a)
    }

    def rankTwo[B](f: Id ~> List, b: B, s: String): (List[B], List[String]) =
     (f(b), f(s))

}

// Ordering 

trait Box[+T] {

  def value: T

}

class Sort[T](ordering: Ordering[Box[T]]){

   def apply(boxes: Seq[Box[T]]) = {
      boxes.sorted(ordering)
    }  

}

class BoxOrdering[T](ordering: Ordering[T]) extends Ordering[Box[T]] {

   def compare(x: Box[T], y: Box[T]):Int = ordering.compare(x.value, y.value)

}

case class IntBox(value: Int) extends Box[Int] {

  def +(other: IntBox ) = IntBox(value + other.value)

}

object boxSort {

    def apply[T](boxes: Seq[Box[T]])(implicit ordering: Ordering[T]) = {
    
    val boxOrdering = new BoxOrdering(ordering)
    
    boxes.sorted(boxOrdering)
    
    }

}
   
// Using a class in the "background" to manage objects


case class Sand(id: Int)
case class Bucket[+A]( sand: Sand )

sealed abstract class Sandpit[+A] {

   def isEmpty: Boolean
   
   def &:[A](b: Bucket[A]): Sandpit[A] = new &:(b, this )

}

case object Empty extends Sandpit[Nothing] {

    override def isEmpty = true

}

case class &:[A](b: Bucket[A], s: Sandpit[A]) extends Sandpit {

     override def isEmpty = false
     
} 

object Sandpit {

   def empty[A]: Sandpit[A] = Empty
   
   def apply[A]( in: Int, s: Sandpit[A] = Empty): Sandpit[A] = 
       new &:( Bucket( Sand( in ) ) , s )
   
   
}   









  
   