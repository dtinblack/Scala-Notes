# Variance

A series of of notes to improve my understanding of variance in Scala.

# Discussion

- Description of the different types of variance e.g. Invariance, Covariance, Contravariance
- Adding Bounds to the parameters e.g. B >: A
- Function1 calls - what does it mean and how can it be applied to other functions


# Background

The following information helped to develop the example software shown in the folders ( big thanks to all of the 
authors):

* [The Scala Type System: Parameterized Types and Variances, Part 1](https://blog.codecentric.de/en/2015/03/scala-type-system-parameterized-types-variances-part-1/ ) gives a good
description with an example that can be understood. Also, [Part 2](https://blog.codecentric.de/en/2015/04/the-scala-type-system-parameterized-types-and-variances-part-2/) and 
[Part 3](https://blog.codecentric.de/en/2015/04/the-scala-type-system-parameterized-types-and-variances-part-3/) for more detail.

* [Learning Scala: Type bounds](http://sudheeraedama.blogspot.co.uk/2013/11/learning-scala-type-bounds.html) - clear explanation with very clear examples.

* [Advanced Programming: Scala Upper and Lower Type Bounds](http://wiki.western.edu/mcis/index.php/Advanced_Programming:_Scala_Upper_and_Lower_Type_Bounds) - quick overview of upper and 
lower bounds.

* [Variance Basics in Java and Scala](http://oldfashionedsoftware.com/2008/08/26/variance-basics-in-java-and-scala/) - using REPL examples to discuss the ideas behind variance.

* [Covariance and Contravariance in scala](http://abstractlayers.com/2014/03/06/covariance-and-contravariance-in-scala/) - using REPL and diagrams to explain the ideas behind variance.

* [Covariance and Contravariance with Horses and People](http://www.hars.de/2009/10/variance-with-horses-and-people.html) - uses "horses and people" to describe the ideas behind 
variance.

* [What are static types? Why are they useful?](https://twitter.github.io/scala_school/type-basics.html) from Twitter School gives a quick description of variance and bounds.

* [Be friend with covariance and contravariance](http://julien.richard-foy.fr/blog/2013/02/21/be-friend-with-covariance-and-contravariance/) - uses examples in REPL to describe the ideas
behind variance.

* A series of posts titled Scala Type Variances: [Part 1](http://www.jayway.com/2011/10/03/scala-type-variances-part-one/) covering Covariance, [Part 2](http://www.jayway.com/2011/10/04/scala-type-variances-part-two/) Contravariant Subtyping,
and [Part 3](http://www.jayway.com/2011/10/05/scala-type-variances-part-three/) lower bounds. 

# Licence

[See Licence](/LICENSE)










