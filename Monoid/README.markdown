# Monoid

The following are a series of notes about Monoids both as mathematical objects and programming paradigms in Scala.



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
