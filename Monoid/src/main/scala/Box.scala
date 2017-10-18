// Box.scala
//
//



package box


case class Box( items: Int ){

   def +(that: Box): Box = Box( this.items + that.items )

}
