# Miscellaneous


A collection of pieces of code that I have gathered together to improve my understanding of Scala.

* Sending a message when an object has been created - see onCreate.
* Extending a function with a class - see IntToString.
* Developing operators e.g. ++ - see Operators.
* Checking functional approaches e.g. reduce - see Functions.
* Difference between a function and a methode - see Test.
* Examples of Polymorphic Functions ( taken from [Functional Programming in Scala](http://www.manning.com/bjarnason/) )- see PolymorphicFunctions.
* Higher Ranked Polymorphism ( taken from [Higher-Rank Polymorphism in Scala](https://apocalisp.wordpress.com/2010/07/02/higher-rank-polymorphism-in-scala/) ) - see HigherRank.
* Ordering from [Basics Comparable/Ordered](http://like-a-boss.net/2012/07/30/ordering-and-ordered-in-scala.html) - see Box and sortBox.
* Using an object to manage other objects ( approach adapted from [Purely functional graph data structure in Scala](http://hs.ljungblad.nu/post/64133088058/purely-functional-graph-data-structure-in-scala) - see Sand and Sandpit.


# Background

The following information helped to develop the example software shown in the folders ( big thanks to all of the 
authors).

* [OnCreate trait: call onCreate method after object creation](https://issues.scala-lang.org/browse/SI-4330) and 
[And you thought the App trait is just a convenient way of creating an executable Scala program](http://blog.knoldus.com/2014/10/05/app-trait-with-delayedinit/)
used to develop the onCreate class.
* [Scala Functions vs Methods](http://jim-mcbeath.blogspot.co.uk/2009/05/scala-functions-vs-methods.html) - Jim McBeath excellent blog that explains the subtle difference.
* [How do I get (a, b) => c from a => b => c in Scala?](http://stackoverflow.com/questions/3456864/how-do-i-get-a-b-c-from-a-b-c-in-scala) - Stakoverflow discussion about uncurrying.
* [Function Currying in Scala](http://www.codecommit.com/blog/scala/function-currying-in-scala) - step-by-step discussion of partial applied functions and currying.
* [Scala partial functions (without a PhD)](http://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html) - step-by-step discussion about partial functions.
* [10 Scala One Liners to Impress Your Friends](https://mkaz.com/2011/05/31/10-scala-one-liners-to-impress-your-friends/) -  a list of Scala one-liners.
* [Cannot understand 'functions as arguments' recursion](http://stackoverflow.com/questions/14636502/cannot-understand-functions-as-arguments-recursion) - Stakoverflow discussion uses an "illustrative trace" which gives an insight into 
how recursion works in functional programming.

# Licence

[See Licence](/LICENSE)










