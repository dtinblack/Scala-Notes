// Chapt2.scala
//
// Examples from Chapter 2 written in Scala
//



package com.example.chap2

class Chap2 {

    def gcd(m: Int, n: Int):Int = (m, n) match {
        case (0, n) => n
        case (m, n) => gcd(n % m, m)
    }    
    


}       










  