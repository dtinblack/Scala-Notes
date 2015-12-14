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

* [Scala - Java Interoperability](/Java-Interoperability) - accessing Java Libraries from Scala.
* [Scala-Variance](/Variance) - notes about Variance and Bounds.
* [SML](/SML) - an exercise in converting SML to Scala.
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


# Licence

[See Licence](/LICENSE)
