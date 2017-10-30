# Type Classes

The following are a series of notes made when I was learning about Scala's Type classes.


Stages in the design and implementation of a type class are:

1 ) Define the behaviour of the type class using a trait.

- Be clear about the [variance](https://twitter.github.io/scala_school/type-basics.html#variance) of the type variables e.g covariant, contravariant or invariant.

2 ) Put the implementations for the trait in a companion object.

- Use implicits to ensure that compiler can find the types.
- Aim to use an implicit class, often called type enrichment, to make sure that all of the working code is in the background and it is easier to call the function e.g. .function type notation

## Scala - Programming Notes

See the section "Context bounds & implicitly[]" in [Scala School - Advanced Types](https://twitter.github.io/scala_school/advanced-types.html) for a concise description about the implicitly keyword.

[Value Classes in Scala](https://ivanyu.me/blog/2014/12/14/value-classes-in-scala/) - value classes are a  feature of Scala that could help to make a type system more powerful - it uses AnyVal ( see example in code ).

[Single Abstract Methods or SAM Types](http://www.scala-lang.org/news/2.12.0/#lambda-syntax-for-sam-types) - Scala 2.12 type checker accepts a function literal ( or a [Lambda expression](http://michaelpnash.github.io/scala-lambdas/) ) as a valid expression for any Single Abstract Method (SAM) type, in addition to the FunctionN types from standard library.

[revisiting implicits without import tax](http://eed3si9n.com/revisiting-implicits-without-import-tax) - discusses Category 1 and 2 implicits.

# Thanks

[Type classes in Scala](https://blog.scalac.io/2017/04/19/typeclasses-in-scala.html) -     includes references to more background on polymorphism.

[https://www.theguardian.com/info/developer-blog/2016/dec/22/parental-advisory-implicit-content](https://www.theguardian.com/info/developer-blog/2016/dec/22/parental-advisory-implicit-content) - clear discussion about implicit parameters and conversions. Implementation of the CanChat example, discussed in the article, is shown in the Scala file.


# Licence

[See Licence](/LICENSE)
