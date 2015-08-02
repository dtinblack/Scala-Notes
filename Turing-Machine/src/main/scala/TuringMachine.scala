// TurinMachine.scala
//
//

package turingmachine

import scala.annotation.tailrec

class TuringMachine {

     type Symbol = Char
     type State  = Char
     type Move   = Tape => Tape

     val A: Char = 'A'
     val B: Char = 'B'
     val C: Char = 'C'

     val one:   Char ='1'            /* Write '1' */
	   val blank: Char = ' '           /* Blank */
     val zero:  Char = '0'           /* Zero */
	   val halt:  Char = '#'           /* Halt */

     val R = right _
     val L = left _

    //                     state 1                 state 2                state 3

    //  symbol 1   (symbol, state, move ) (symbol, state, move ) (symbol, state, move )
    //  symbol 2

    //  Map( state -> Map( symbol -> ( symbol, state, move )))

  	 type TrnsMtrx= Map[State, Map[Symbol, (Symbol, State, Move)]]

	 /* <--- left ----><-- head --><--- right ---> */

	 case class Tape(l: List[Symbol],head:Symbol, r: List[Symbol]){

	   /* 'reverse' - reverse the list */
	   /* 'trim' - removes spaces at the beginning and end of the tape */

       override def toString = ( l.reverse ++ (head::r)  ).mkString.trim

      /* length of tape = number of Char in left and right List + head */

      def print = println(l:::head::r)

       def length: Int = l.length + r.length + 1

     }

    /* Converts a String to a Tape */
    /* Example: right("1234") => List(blank)-1-List(1,2,3,4) => "b1234" */

     def tape(s:String)= right(Tape(Nil,blank,s.toList ))

    /* read the tape which is equivalent to returning the head */

	   def read(t:Tape)= t.head

    /* write to tape via the head */

     def write(c:Symbol, t:Tape)=Tape(t.l,c,t.r)

    /* move head to the left and add a blank to extend the tape if required */
    /* Example: tape = "b1234" => List()-b-List(1,2,3,4)                    */

     def left(t:Tape)=t match {
        case Tape(Nil,head,right) =>Tape(Nil,blank,head::right)
        case Tape(left,head,right) =>Tape(left.tail,left.head,head::right)
     }

    /* move head to the right and add a blank to extend the tape if required */

    def right(t:Tape)=t match {
      case Tape(left,head,Nil) =>Tape(head::left,blank,Nil)
      case Tape(left,head,right) =>Tape(head::left,right.head,right.tail)
    }

    /* Interpreter or the Turing Machine                                      */

//    @tailrec
    final def step(q:State, t:Tape, tm:TrnsMtrx, qf:State):Tape =
          if (q == qf ) t else {
            val (c, qnew ,move)=tm(q)(t.head);
            step(qnew, move(write(c,t)), tm, qf) }

}
