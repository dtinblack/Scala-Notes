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
* [Trees](/Trees) - examples of Tree data structures.
* [Miscellaneous](/Miscellaneous) - collection of scala programming techniques.
* [Mathematics](/Mathematics) - matrix and differential equations.
* [Turing Machine](/Turing-Machine) - an example of a Turing Machine.

# Useful commands

* To automatically run SBT after a change to the software:

      <pre><code>SBT ~run
      </code></pre>

* To display the phases of the Scala compiler:

    <pre><code>scala -Xshow-phases
    </code></pre>

# Background references about Scala

[Programming in Scala](http://www.lirmm.fr/~ducour/Doc-objets/scalabook.pdf) - first edition.

[10 Scala One Liners to Impress Your Friends](https://gist.github.com/mkaz/d11f8f08719d6d27bab5) - useful one line scala implementations.

[A Scala Tutorial
for Java programmers](http://www.scala-lang.org/docu/files/ScalaTutorial.pdf) - covers the basics.

[Scala By  Example](http://web.mit.edu/jhawk/mnt/spo/scala/old/share/doc/scala-1.4.0.3/ScalaByExample.pdf) - covers more advanced areas of Scala.

[Everything's an object](http://blogs.tedneward.com/post/scala-pt-3-everythings-an-object/) - describes the advantages of 'Everything being an Object' with examples.

[Functions as Objects as Functions](https://gleichmann.wordpress.com/2010/11/08/functional-scala-functions-as-objects-as-functions/) - describes the relationship between a function and object used by Scala. See [Functions are Objects in Scala](https://kwangyulseo.com/2014/03/03/functions-are-objects-in-scala/) - for a worked example.

[Methods are not Functions](https://tpolecat.github.io/2014/06/09/methods-functions.html) - examples of <i>methods</i> and <i>values</i> and includes a discussion of <i>eta expansion</i>.


# Licence

[See Licence](/LICENSE)
