// Chapt3.scala
//
// Examples from Chapter 3 written in Scala
//



package com.example.chap3

import either._

import scala.math.sqrt

case class Vector(x: Double, y: Double ) {

   val vx = x
   
   val vy = y
   
   override def toString = "(" + vx + ", " + vy + ")"

   def add(that: Vector ): Vector = Vector( that.vx + vx, that.vy + vy) 
 
   def sub( that: Vector ): Vector = Vector( that.vx - vx, that.vy - vy)
   
   def mult( that: Double): Vector = Vector( that * vx, that * vy )
   
   def prod( that: Vector ): Double = that.vx * vx + that.vy * vy    

} 

case class Quadratic(a: Double, b:Double, c: Double) {

      def solve: Either[String, ( Double, Double )] = { 
     
         val d = b * b - 4.0 * a * c
         
         if ( ( d < 0.0 ) ||  ( a == 0 ) ) Left( "Solution criteria failed !" ) 
             else Right( ( ( -b + sqrt(d) ) / ( 2.0 * a ), ( -b - sqrt(d) ) / ( 2.0 * a ) ) )
         }       

}   










  