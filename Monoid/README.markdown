# Monoid

The following are a series of notes about Monoids both as mathematical objects and programming paradigms in Scala.


### Mathematics

A monoid is a triple:

$$
\langle
A, \oplus, \alpha
\rangle
$$

where

$A$ is a set;

$\oplus$: $A \times A \rightarrow A$ is a binary function on $A$;

$\alpha \in A$ is an element of $A$

such that for all elements $x, y, z \in A$ the following _identity_ and _associativity_ laws hold:

$x\oplus \alpha = x$

$\alpha \oplus x = x$

$x \oplus (y \oplus z ) = ( x \oplus y ) \oplus z$

Examples of monoids:

$\langle N, +, 0  \rangle$ - natural numbers

$\langle N, \times , 0  \rangle$ - natural numbers

$\langle A^\ast,\# ,\square  \rangle$ - finite sequences

Monoids are similar to categories: $\oplus$ is like composition and $a$ is like an identity. We can view very monoid $\langle A, \oplus, \alpha \rangle$ as a category as follows:

Objects - the set $A$ is the unique object of the category,

Arrows - $x:A \rightarrow A$ means that $x \in A$, i.e. arrows are elements of A.

Identities - $id_A: A \rightarrow A$ is uniquely defined by $id_A = a$

Composition - if $x: A \rightarrow A$ and $y: A \rightarrow A$ then $y\circ x: A \rightarrow A$ is defined by $y \circ x = y \oplus x$.


### Functional Programming

A monoid takes two inputs and produces an output e.g.

5 + 7 = 12,

where the two inputs are "5" and "7" and the output is "12". Also, with the _associativity law_ monoids can be joined together e.g.

(5 + 7) + 3 = 15

where the "(5 + 7)" is the first monoid and its result is added to "3" which forms the second monoid and results in "15".

Mapping between monoids e.g. $\langle A, OpA, ZeroA  \rangle$ and $\langle B, OpB, ZeroB  \rangle$, we can define a mapping from one monoid to another $f: A \Rightarrow B$, that $f(ZeroA) = ZeroB$ and $f(x OpA y) = f(x) OpB f(y)$.

Remember - can use [Referential Transparency](https://en.wikipedia.org/wiki/Referential_transparency) as one of the overarching paradigms for Functional Programming.

### Scala Programming Notes

#### implicitly vs implicit

```{scala}

scala> implicit val a: String = "Hello, World" // define an implicit value of type String
a: String = Hello, World

scala> val b = implicitly[String] // search for an implicit value of type String
b: String = Hello, World

```

# Thanks

[Baking a π can teach you a bit of Parametricity](http://debasishg.blogspot.co.uk/2015/06/baking-can-teach-you-bit-of.html) - original article that started my exploration of Monoids which is based on comments made in [Eugenia Cheng's ](http://eugeniacheng.com) book [How to Bake Pi: An Edible Exploration of the Mathematics of Mathematics ](https://books.google.co.uk/books?id=cX4vjgEACAAJ&dq=How+to+Bake+Pi:+An+Edible+Exploration+of+the+Mathematics+of+Mathematics&hl=en&sa=X&redir_esc=y)

[Monads are just WTF in the category of huh?](http://blog.krobinson.me/posts/explaining-monads) - clear description of Monoid's written in Scala, including "Free Monoids".

[Monoid](http://eed3si9n.com/learning-scalaz/sum+function.html) - implementation of Monoids in Scala.

[Monoids for Programmers: A Scala Example](https://www.safaribooksonline.com/blog/2013/05/15/monoids-for-programmers-a-scala-example/) - describes the laws for a Monoid.

[Monoids for Programmers: A Scala Example](https://www.safaribooksonline.com/blog/2013/05/15/monoids-for-programmers-a-scala-example/) - includes a description of a "Free Monoid".

[Hands on Monoids in Scala – Applying categories to birdwatching](http://blog.leifbattermann.de/2016/11/02/hands-on-monoids-in-scala/) - applying monoids to an example and a good description behind the mechanics of a monoid.

[Description and use of Monoids from the cats docuemntation](https://typelevel.org/cats/typeclasses/monoid.html) - simple examples that explain the principles of monoids e.g. semigroup.

[Monoid Morphisms, Products, and Coproducts](http://blog.higher-order.com/blog/2014/03/19/monoid-morphisms-products-coproducts/) - detailed discussion about the relationship between monoids.

[An Introduction to Monoids](https://blog.axosoft.com/monoids-practical-category-theory/) - introduction to monoids through semi-groups with a discussion about their applications.

[Type Class 101: Monoid](https://inoio.de/blog/2014/07/20/type-class-101-monoid/) - detailed discussion with examples ( post part of a wider series on category theory ).




# Licence

[See Licence](/LICENSE)
