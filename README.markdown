# Scala - Notes

Using [Scala](http://www.scala-lang.org/) to test out ideas for apps I have ran into various problems
which have highlighted my lack of understanding in the underlying concepts of the programming language.
To solve the problems I spent a lot of time searching the web, reading books and playing with the code (
usually using [REPL](http://www.javacodegeeks.com/2011/09/scala-tutorial-scala-repl-expressions.html) ) to
identify the source of the problem and developing some solutions.

I have gathered together all of the pieces of information, under general headings, to both remind
myself of the solutions I developed ( I am sure that there are better solutions ),
and to help anybody else who runs into similar problems.

# Software

* Operating System : Mac OS 10.10.1 ( Yosemite )
* Scala : v2.11.4
* SBT: v0.13.6


# Notes

* [Type System](/TypeSystem) - examples of the different types systems.
* [Scala - Java Interoperability](/Java-Interoperability) - accessing Java Libraries from Scala.
* [Implicits](/Implicits) - examples of using implicits.
* [Trees](/Trees) - examples of Tree data structures.
* [Miscellaneous](/Miscellaneous) - collection of scala programming techniques.
* [Mathematics](/Mathematics) - matrix and differential equations.
* [Turing Machine](/Turing-Machine) - an example of a Turing Machine.
* [Monoid](/Monoid) - description and example of a Monoid.
* [Type Classes](/TypeClasses) - notes and examples of Type Classes.


# Useful commands

* To automatically run SBT after a change to the software:

      <pre><code>SBT ~run
      </code></pre>

* To display the phases of the Scala compiler:

    <pre><code>scala -Xshow-phases
    </code></pre>

# Background references about Scala:

[Programming in Scala](http://www.lirmm.fr/~ducour/Doc-objets/scalabook.pdf) - first edition.

[Strategic Scala Style: Principle of Least Power](http://www.lihaoyi.com/post/StrategicScalaStylePrincipleofLeastPower.html) - guidelines on writing Scala.

[Scala School - Basics](https://twitter.github.io/scala_school/basics.html) - covers the key concepsts used in Scala.

[10 Scala One Liners to Impress Your Friends](https://gist.github.com/mkaz/d11f8f08719d6d27bab5) - useful one line scala implementations.

[A Scala Tutorial for Java programmers](http://www.scala-lang.org/docu/files/ScalaTutorial.pdf) - covers the basics.

[Scala By  Example](http://web.mit.edu/jhawk/mnt/spo/scala/old/share/doc/scala-1.4.0.3/ScalaByExample.pdf) - covers more advanced areas of Scala.

# Examples of well written explanations:

[Complex Numbers in Scala](http://www.stoyanr.com/2013/02/complex-numbers-in-scala.html) - good format and description of the concepts and features of Scala.

# Licence

[See Licence](/LICENSE)
