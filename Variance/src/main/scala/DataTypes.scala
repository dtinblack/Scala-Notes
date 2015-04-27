// DataTypes.scala
//
//

package com.example.datatypes


class InVar[T] { override def toString = "Invariant"}
class CoVar[+T] { override def toString = "Covariant" }
class ContraVariant[-T] { override def toString = "Contravariant" }

// Define Class Types

class A { override def toString = "Class A" }
class B extends A { override def toString = "Class B ( Sub Class of A )" }
 

