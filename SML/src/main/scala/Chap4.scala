// Chap4.scala
//
// Examples from Chapter 4 written in Scala
//



package com.example.chap4

import either._

import scala.math.sqrt

case class Rational(n: Int, d: Int){

    override def toString = n + "/" + d
    
    def add(that: Rational): Rational = 
        Rational( that.d + that.n * d, d * that.d )



}  










  