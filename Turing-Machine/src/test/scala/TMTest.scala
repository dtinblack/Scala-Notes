// TMTest.scala
//
//

package tmtest

import turingmachine._

import org.specs2.mutable._

class TMTest extends Specification {

    val testmachine = new TuringMachine

    import testmachine._

    val overall = tape("1234567")

     "Create a Tape from a String test" should {

       """Be created and the format correct""" in {

          val testTape = tape("12345")

         testTape.toString must be_==("12345")

      }
    }

    "Length method test" should {

     """Length should return with number or char's + head""" in {

       val testLength = tape("1234")

       testLength.length must be_== (5)

     }

    }

    "Write method test" should {

       """Write a character to a tape""" in {

       val testWrite = tape("12345")

       write('c', testWrite).toString must be_== ("c2345")


       }
    }


    "Testing read function" should {

    """Read the char where the head is pointing""" in tart{

       read( overall ) must be_==('1')

    }

  }


} // End og TMTest
