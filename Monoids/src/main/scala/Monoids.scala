// Monoids.scala
//
//

package com.example.monoids


object Monoids {

  def main(args: Array[String]) {

  println("Program started")
  
  val x = (0 to 4).toList

  val xtest = x map { x => List(x - 0.1, x + 0.1) }
  
  print( xtest )
  
  val xflatten = x flatMap { x => List(x - 0.1, x + 0.1) }
  
  print( xflatten )
  
  }
  
}  

