/* Notes on defining own types */


object OwnTypes {

   // =========================================
   // case class automatically generates a companion object with an apply()
   // and unapply() which is used in pattern matching. Note unapply() is not the
   // reverse of apply().

   // =========================================
   // Example of class & object combination

   class Hello ( val name: String)

   object Hello {

         def apply( name: String) = new Hello( name )

         // default

         def apply() = new Hello("")

         // two names

         def apply(base: String, add :String ) = new Hello( base + " " + add)

        // extractor

        def unapply( h: Hello ): Option[String] = if(h.name.contains("Hello")) Some("Hello") else None
   }

   // =========================================
   // Own type of Box and ShoeBox

   trait Box {
      def full: Boolean
   }

   case class ShoeBox(items: Int) extends Box {
        def full: Boolean = if ( items > 100 ) true
                            else false
   }

   case class CupBoard(boxes: List[ShoeBox])

   def num( l: List[ShoeBox] ): Int = l match {
         case Nil => 0
         case head::tail => 1 + num(tail)
   }

   def getBoxContents = (c: ShoeBox) => c.items


   // More complex example using Dependency Injections

   // =========================================
   // Service Interface

   trait Switch {
       def on: Unit
       def off: Unit
   }

   trait Sensor {
       def isLiquidPresent: Boolean
   }

   // =========================================
   // Service Implementation

    class Heater extends Switch {
        def on = println("heater is on")
        def off = println(" heater is off")
    }

   class VesselSensor extends Sensor {
       def isLiquidPresent = true
   }

   // =========================================
   // Service declaring two dependencies

  class Warmer(
       implicit val sensor: Sensor,
       implicit val activated: Switch ){

        def trigger = {
          if( sensor.isLiquidPresent ) activated.on
            else activated.off
        }
  }

  // =========================================
  // Instantiate the service in a module

    object Service {
       implicit val vesselSensor = new VesselSensor
       implicit val heater = new Heater

    }

   def main(args: Array[String]){

     // Checking the class with companion objects

       println("Create with a single name: " + Hello("Hello").name )

       println("Create with two names: " + Hello("Hello", "World").name )

       println("Create using default: " + Hello("").name )

     // Check pattern matching

       Hello("Hello World") match {
           case Hello(s) => println("Result of pattern matching: " + s)
           case _ => println("Error")
       }

    // Checking if the ShoeBox is full

       println("Is the ShoeBox full: " + ShoeBox(40).full )

       val myCupBoard = CupBoard(List(ShoeBox(2), ShoeBox(3), ShoeBox(4)))

     // Number of ShoeBox's in the CupBoard

       println("Number of boxes in the cupboard: " + num(myCupBoard.boxes))

     // Total number of items stored in the ShoeBoxes in the CupBoard

       val res = myCupBoard.boxes.map(getBoxContents).foldRight(0)((x, y) => x + y )

       println("Total contents stored in boxes: " + res )

     // Checking the Service object

     // Import the service into current scope

       import Service._

       val warmer = new Warmer

       warmer.trigger

   }

}
