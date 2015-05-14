// Chapt1.scala
//
// Examples from Chapter 1 written in Scala
//



package com.example.chap1

class Chap1 {

   def fact(n: Int): Int = n match {
       case 0 => 1
       case n => n * fact( n-1)
   }
   
   def fib(n: Int): Int = n match {
       case 0 => 1
       case 1 => 1
       case n => fib(n-1) + fib(n-2)
   }
}       










  