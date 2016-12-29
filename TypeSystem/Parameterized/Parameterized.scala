/* Notes on using Parameterized Types */

object Parameterized {

  // A Stack Class

  class Stack[T] {
     var elems: List[T] = Nil
     def push(x: T) {elems = x :: elems}
     def top:T = elems.head
     def pop(){ elems = elems.tail }
     def size() = elems.length
  }

  // Partially applied functions (A, B) => C

 def add(i: Int, j:Int) = i + j

 // take a value and function with two values and returns a function

 def partialOne[A,B,C](a: A, f:(A,B) => C): B => C = (b: B) => f(a,b)

 // Note the a function is returned


// Curried functions A => B => C

  def add_curried(i: Int)(j:Int) = i + j

  def curried[A,B,C](f: (A,B) => C): A => (B => C) = (a: A) => (b: B) => f(a,b)

  def uncurry[A,B,C](f: A => B => C): (A, B) => C = (a, b) => f(a)(b)

// Composed functions

  def compose[A,B,C](f:(B => C), g:(A => B)): A => C = a => f(g(a))



    def main(args: Array[String]){


      // Create a Stack of Strings

      val stack = new Stack[String]

      stack.push("Hello")
      stack.push("World")

      println(stack.size)

      println(stack.top)

      stack.pop()

      println(stack.top)

      // Testing Partial Functions, Currying and Composition

      def first(x: Int) = (y: Int) => x + y

      val second = first(1)

      println(second(2))

      val func = (a: Int, b: Int) => a + b

      val partialFunction = partialOne( 3, func )

      println( "Partially applied function: " + partialFunction( 4 ) )

      val f_string = (a: String, b: String) => a + b

      val partialString = partialOne("David ", f_string)

      println("Partially applied function :" + partialString( "Black"))

      val add_eleven = curried(func)(11)

      println("Curried function: " + add_eleven(9))

      val f1 : Int => Int => Int = a => b => a + b

      println("Uncurried function: " + uncurry(f1)(10,10))

      val f = (x: Int) => x + 1

      val g = (y: Int) => y * y

      val z = (z: Int) => z + z

      println("Composition: " + ( f compose g )(5) )

      println("Associative Law ( using compose ): " + ( ( f compose g) compose z )(5) )


    } // End of main

}  // End of OwnTypes
