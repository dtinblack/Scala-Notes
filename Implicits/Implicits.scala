/* Notes on using Implicits */


object Implicits {


    def main(args: Array[String]){

      println("Program started ...")


     /* ================== Implicit Conversions ===================== */

     case class A(x: Int)
     case class B(m: String, v: Double) {
        def method = println(s"Hello world $m $v")
     }

     val a = A(10)

     val b = B("what is the meaning of life ?", 42.0 )

     // Clearly b does not equal a
     // However using an implict conversion from A(source) to B(target) will
     // be available ( in context ).

     implicit def conv(v: A): B = B("Some string", v.x.toDouble)

     println( "Converts A(source) to B(target): " + conv(a) ) // Converts

     val dval: Double = a.v     // A doesn't have a v attribute but B
                                // therefore its is translated into convert(a).v
     println( dval )

     val m: String = a.m

     println( m )

     // Also, A elements become valid parameters for formal parameters of type B

     def fc(x: B):Double = x.m.size * x.v

     println( fc(a) == fc(conv(a)))

     /* ================== Implicit Parameters ===================== */



     def fp( implicit x: Int ): Int = x * 2    // fp can be used by any other function

     println("Recieve 'x' explicitly: " + fp(42).toString )

     implicit val v: Int = 42    // Implicit value

     println("Receive 'x' implicitly: " + fp.toString )

     // Regular and implicit parameter lists can be combined

     def g(x: Int, y: Int)(implicit base: Int): Int = ( x + y ) % base

     println( g(41,1) )         // Returns zero

     println( g(41,1)(100))     // Returns 42



      /* ===== Implicit Conversions = Implicit Parameter ============ */


      case class Target( x: Int)
      case class Source( x: String)

      implicit val SourceToSource = (v: Source) => Target( v.x.toInt )

      val target: Target = Source("2016")

      // Implicit conversions are functions therefore values.
      // Actual implicit parameters are just values, therefore values = values.

      /* ======================== Context =========================== */

      // Normal context

      {  val x = 3                    // depth 0
         var y = 40;
        {
          val x = 7                   // depth 1 e.g. 294
          y = 42
          println( x * y)
        }
         println( x * y )             //  126
      }

     //

     case class Number( number: Int)

     case class Name( name: String)

     def func(implicit a: Number, b: Name): Unit = println("Number: " + a.number + "  "+ "Name: " + b.name )

        {                                                    // declared at depth 0

          implicit val anyOldNumber: Number = Number( 101 )
          implicit val anyOldName: Name = Name("Room")

          {

           func;                                             // call at depth 1

           {

             implicit val anyOldName: Name = Name("Another Room")
             func                                            // call at depth 2

             // If the above was replaced with:
             //
             // implicit val anotherName: Name = Name("Yet Another Room")
             //
             // then the implicit context would contain two implicit values
             // for Name and an ambiguity error would be produced.

           }

          }

            func                                             // call at depth 0

         }


          /* ============== Capturing Implicit Values ====================== */

          def implicitly[T](implicit e: T) = e

         // - Implicit parameters become implicit values within a function body

          case class getValue( x: Int)

          def printOut( implicit x: getValue ) = println(
                 s"Implicit value for integers within printOut's body: ${implicitly[getValue]}"
          )

          printOut( getValue(3) )  // 3 is explicitly passed to the function body

          implicit val vOutsidegetValue = getValue( 42 )

          printOut

          // - Implicit conversions defined at a target class companion object
          //   are available to use sources's instance where targets are expected.

          case class AS(x: Int)

          class BT(val x: Double)

          object BT{ // companion object for BT
                implicit def fromAS(o: AS): BT = new BT(o.x.toDouble)

          }

          val bt: BT = AS(32) // BT is the target class

          println( bt.x )

          def show(x: BT) = println(x)

          show( AS( 62 ))

          /* ========================= Example ============================ */

          class Complex(val re: Double, val im: Double){

               override def toString = re + ( if ( im < 0 ) " - " + -im else " + " + im) + "i"

            def +(c: Complex) = new Complex(re + c.re, im + c.im)

            def this(re: Double) = this(re,0)

            def +(d: Double) = new Complex( re + d, im)

            // Approximately Equal

            def ~=(c: Complex ):Boolean =
                 if ( ( (c.re - re).abs < 0.00001 ) &
                      ( (c.im - im).abs < 0.00001) ) true
                  else false

          }

          val x = new Complex(2, -3)
          val y = new Complex( 4, 4)
          val z = new Complex(6)

          println( (x + y).toString )

          println( (z + 2).toString )

          // following implicit conversion required otherwise '2 + z' will not work

          implicit def fromDouble(d: Double ) =  new Complex(d)

          println( (2 + z).toString) // should get the same result as 'z + 2'

          println( x ~= y )

          println( z ~= z)

    } // End of def main

}  // End of Implicits
