# Turing Machine

Following the example in the paper: [Turing Machines](http://iiis.tsinghua.edu.cn/~john/turing_machines.pdf) and some problems set
in [Lecture Notes](http://www.massey.ac.nz/~mjjohnso/notes/59102/notes/l22.html)


Example of a [Scala version of a Turing Machine](http://gabrielsw.blogspot.co.uk/2012/04/purely-functional-turing-machine.html) using a
[Zipper](http://etorreborre.blogspot.co.uk/2013/06/a-zipper-and-comonad-example.html) to manage the immutable version of a tape
( see [blog](http://tech.schmitztech.com/scala/zippers.html) with an explanation and a worked example.

# Software

* Operating System : Mac OS 10.10.1 ( Yosemite )
* Scala : v2.11.4
* SBT: v0.13.6

# Code Test

    <instruction> ::= <ident> "," <symbol> "," <operation> "," <ident>


# Background

- [What Is A Turing Machine](http://www.logique.jussieu.fr/~michel/tmi.html) - a worked example.
- [Turing Machine](http://www.maths.qmul.ac.uk/~whitty/Oxford/OUSSA2012/TuringMachines.pdf) - lecture with a good
description of a data structure that could be used in a 'match'.
- [Description of Turing Machine from the Standford Encyclopaedia of Philosophy](http://plato.stanford.edu/entries/turing-machine/)

# Notes




# Licence

[See Licence](/LICENSE)
