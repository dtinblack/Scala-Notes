// TMExample.scala
//
//


package tmexample

import turingmachine._

object TMExample {

     def main(args: Array[String]): Unit = {

       println("Program started ...")

       val machine = new TuringMachine

       import machine._             /* Tip: don't have to use "machine" everywhere */

       val test = tape(" ")

       println("Length of tape: " + test.length )

       val tm: TrnsMtrx = Map(A -> Map( blank ->( one, B, R),   one -> ( one, halt, R )),
                              B -> Map( blank ->( blank, C, R), one -> ( one, B, R )),
                              C -> Map( blank ->( one, C, L),   one -> ( one, A, L ))
                             )

       println( step( A, test, tm, halt ) )

       /* Add 5 and 1 in binary */

       val binary = tape("101   ")

       val tmadd: TrnsMtrx = Map(A -> Map( blank -> (blank, B, R),    one -> (one, B, R),    zero -> (zero, B, R)),
                                 B -> Map( blank -> (one, halt, R),   one -> (one, B, R),    zero -> (zero, B, R )),
                                 C -> Map( blank -> (blank, halt, R), one -> (one, halt, R), zero -> (zero, halt, R))
                                )

       println( binary )

       println( step( A, binary, tmadd, halt) )

     }

}
