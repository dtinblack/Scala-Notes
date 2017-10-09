// FunctionSignatures.scala
//
// Detailed description ( verbose ) of the functions derived from a
// function signature.
//

package functionsignatures

object FS {

   // isSorted

   def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {

      @annotation.tailrec
      def iter(n: Int): Boolean =
         if ( n >= as.length - 1) true
         else if ( ordered(as(n), as(n+1)) ) false
         else iter(n+1)

         iter(0)  // start at the first element

 }

  // partial function - verbose version

  def verbose_partial[A,B,C](a: A, f: (A,B) => C): B => C = {

           (b: B) => {   // a single valued function

           f(a,b)        // apply a to function 'f' that
                         // returns a 'c' of type C

         }
   }

   // curry - verbose version

   def verbose_curry[A,B,C](f: (A, B) => C): A => ( B => C) = {

        (a: A) => {     // a function of one argument 'a'

            (b: B) => { // a function of one argument 'b'

              f(a,b)    // whose return value is what you get if you
                        // execute 'f(a,b)' ( whose type is 'C')

            }
         }
     }

   // uncurry - verbose version

   def verbose_uncurry[A,B,C](f: A => B => C):(A,B) => C = {

          (a: A, b: B ) =>  {     // a function of two arguments

            f(a)(b)      // apply 'a' to the Higher order Function ( HoF)
                         // which returns a function that consumes a 'b'
                         // which returns a 'c' whose type is C
          }
     }

     // compose - verbose version

     def verbose_compose[A,B,C]( f: B => C, g: A => B ): A => C = {

        (a: A) => {    // single valued function

           f(g(a))     // apply 'a' to the 'g' function to return a B value
                       // apply the B value to the 'f' function to return
                       // a C value

             }

         }

      // map - verbose

      def verbose_map[A,B](as:List[A])(f: A => B ): List[B] =
          as match {                 // use pattern matching to recurse
                                     // through List

             case List() => List()  // if List empty then finish

                                    // take the item from the head of the
                                    // List and compute the value placing
                                    // the result in a List and add
                                    // the next recursion

             case head::tail => List(f(head)) ::: verbose_map(tail)(f)
       }

      // filter - verbose

      def verbose_filter[A](as: List[A])(f: A => Boolean): List[A] =
            as match {                 // use pattern matching to recurse
                                       // through List

            case List() => List()      // if List empty then finish

            case head :: tail => if ( f ( head )) List(head) ::: verbose_filter(tail)(f)
                                 else List() ::: verbose_filter(tail)(f)

      }

      // flatmap - verbose

      def verbose_flatmap[A,B](as: List[A])(f: A => List[B]): List[B] =

             as match {

                 case List() => List()  // if List is empty then finish

                 case head :: tail => f( head ) ::: verbose_flatmap(tail)(f)

      }

      // foldRight - verbose

      def verbose_foldRight[A,B](as: List[A], z: B)(op: (A, B) => B): B =
               as match {

                    case Nil => z

                    case head :: tail =>  op( head, verbose_foldRight( tail, z )( op ))
       }

     }

     // State - verbose

     case class Verbose_State[S, +A](run: S => (S, A)){

         def map[B](g: A => B):Verbose_State[S,B] = Verbose_State {
               s => val (s1, a) = run(s)  
               (s1, g(a))
         }

        def flatMap[B](g: A => Verbose_State[S,B]): Verbose_State[S,B] =
             Verbose_State{ s =>
                     val (s1, a ) = run(s)
                     g(a) run s1 }

       }
