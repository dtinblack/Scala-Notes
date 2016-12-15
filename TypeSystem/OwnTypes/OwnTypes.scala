/* Notes defining own types */

object OwnTypes {

    //========================================================

    trait Box {
       def full: Boolean
    }

    case class ShoeBox(items: Int) extends Box {

         def full: Boolean = if ( items > 50 ) true else false

    }

    case class CupBoard( contents: List[ShoeBox])

    def numberOfBoxes( boxes: List[ShoeBox]): Int = boxes match {
             case Nil => 0
             case head::tail => 1 + numberOfBoxes(tail)
    }

    def get(b: ShoeBox): Int = b match { case ShoeBox(n) => n }

    def main(args: Array[String]){

      // How full is the shoe box ?

      println("Is the shoebox full ? " + ShoeBox(20).full)

      // Fill the wardrobe up with shoe boxes

      val wardrobe = CupBoard(List(ShoeBox(12), ShoeBox(10), ShoeBox(5)))

      // How many shoe boxes in the cupboard ?

      println("Number of shoe boxes in the wardrobe: " + numberOfBoxes( wardrobe.contents ))

      // Total number of items in the cupboard ?

      println("Total number of items in the cupboard: " + wardrobe.contents.map(get).foldLeft(0)((r,c) => r +c ))


    } // End of main

}  // End of OwnTypes
