// TypeClassExamples.scala
//
//

object TypeClassExamples{

   def main(args: Array[String]): Unit = {

     println("Program started ...")

   // Example taken from "Implicits and type classes in Scala" - see Thanks in README for
   // more information.

   // trait - describing the behaviour

   trait CanChat[A] {
      def chat(x: A): String
   }

   // class types

   final case class Person(firstName: String, lastName: String)

   final case class Dog( name: String )

   // implementation of the trait CanChat

    object ChattyAddons {

        implicit  object PersonCanChat extends CanChat[Person]{
              def chat(x: Person) = s"Hello, I'm ${x.firstName}"
         }

         implicit object DogCanChat extends CanChat[Dog]{
            def chat(x: Dog) = s"Woof, my name is ${x.name}"
         }

         // class used as an implicit conversion

         implicit class ChatUtil[A](x: A) {
              def chat( implicit makeChatty: CanChat[A]) = {
                    makeChatty.chat(x)
            }
         }

         implicit object StringCanChat extends CanChat[String]{
           def chat(x: String) = s"""I'm a string containing "${x}""""
         }

         implicit object IntCanChat extends CanChat[Int]{
             def chat(x: Int) = s"Hello ${x.toString} you are an integer"
         }
    }

    import ChattyAddons._        // bringing into scope

    // test with a few examples

    println( Person("John", "Smith").chat  )

    println( Dog("Meg").chat  )

    println( "Hello, World!".chat )

    println( 42.chat )

    // Example taken from "Type classes in Scala" - - see Thanks in README for
    // more information.

    // use trait to define behaviour

    trait Show[A]{
        def show(a: A): String
     }

    // implementation of Show

    object Show {

       // following used to avoid calling intCanShow explicitly

       // def show[A](a: A)(implicit sh: Show[A]) = sh.show(a)

       // modified the above to use "implicitly" with a context bound

       // def show[A: Show](a: A) = implicitly[Show[A]].show(a)

       // to replace the above use a def apply

       def apply[A](implicit sh: Show[A]): Show[A] = sh


       object ops {   // wraps around to allow users of this type class to redefine
                      // the default behaviour

       def show[A: Show](a: A) = Show[A].show(a)

       // To improve the type class - convert the show function to a method with a .shown
       // notation - use the convention <TypeClassName>Ops

       implicit class ShowOps[A: Show](a: A) {
            def show = Show[A].show(a)
        }

        }

       /* --- original code

       // for Integers

       implicit val intCanShow: Show[Int] =
            new Show[Int]{
               def show(int: Int): String = s"int is ${int}"
            }

        // for Strings

        implicit val stringCanChat: Show[String] =
             new Show[String]{
               def show(str: String):String = s"string ${str}"
             }

        */


        // Using Single Abstract Methods - type class instances

        implicit val intCanShow: Show[Int] =
                     int => s"int $int"

        implicit val stringCanShow: Show[String] =
                      str => s"string $str"

     } // End of companion object

     // test

     import Show._                        // load into scope
     import Show.ops._

     println( show(42) )

     println( 101.show )

    // define own a case class outside of the companion object

    case class Foo(foo: Int)

    implicit val fooShow: Show[Foo] =
          foo => s"case class Foo( foo: ${ foo.foo })"

    // test case class

    println( Foo(42).show )



   } // End of def Main

} // End of TestingConcepts
