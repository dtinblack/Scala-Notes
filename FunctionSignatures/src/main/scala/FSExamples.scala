// FSExamples.scala
//
//



object FSExamples {

    import functionsignatures.FS._

   def main(args: Array[String]): Unit = {

     println("Program started ...")

     // is Sorted example

        println( isSorted(Array(1,2,3,4), (x: Int, y: Int) => x > y ) )

        println( isSorted(Array("Hello,", "World"), (x: String, y: String) => x.length > y.length ) )

     // partial examples

        val func_test = (x: Int, y: Int) => x * y

        val new_func = verbose_partial( 10,  func_test )

        println( new_func( 20 ) )

        println( new_func( 10 ))

     // curry example

        val curry_func = verbose_curry( func_test )

        println( curry_func(10)(10) )

        val curry_func_one = curry_func(10)(_)

        println( curry_func_one(30) )

    // uncurry example

       val uncurry_test = curry_func

       val uncurry_test_func = verbose_uncurry(uncurry_test)

       println( uncurry_test_func(12,12))


    // compose example

       val g = (s: String) => s.length

       val f = (x: Int) => x+1

       println( verbose_compose(f, g)("David") == 6 )

    // map examples

       val ls = List(1,2,3,4,5,6,7)

       val doubleInt = ( x: Int ) => 2 * x

       println( verbose_map[Int, Int]( ls )( doubleInt ) )

       val str_ls = List("Scala","Java","Hello", "World")

       val stringLength = (x: String) => x.length

       println( verbose_map[String, Int]( str_ls )( stringLength ))

    // filter examples

       val fil = (x: Int) => x > 3

       println( verbose_filter( ls )( fil ) )

   // flatmap examples

      val expandList = (x: Int) => List(x + 1, x + 2)

      println( verbose_flatmap[Int,Int]( ls )( expandList ))

  // foldRight examples


      println( verbose_foldRight[Int, Int](ls, 0)(_ + _) )

      println( verbose_foldRight[String, String](str_ls, "")(_ + _))


   // State examples

      import functionsignatures.Verbose_State

      val my_transition = Verbose_State[String, Int]( (s: String) => (s, s.size))

      println( my_transition run("hello, world "))

      def double_size_function(s: Int) = s * 2

      println( my_transition map( double_size_function ) run("hello, map"))

      def repeat_function(num: Int): Verbose_State[String, Int] =
            Verbose_State( (s: String) => ( s * num, num * s.size ) )

      println( my_transition flatMap(repeat_function) run("hello, flatMap "))


   }
}
