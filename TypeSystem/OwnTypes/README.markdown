## Own Types

### Notes

#### Refinement Types

In Scala you can do the following:

```
def doSomething(x : { def bar: Unit }) = ...
```

which is called structural typing - the doSomething method puts a constraint on the structure of objects that maybe passed to it. However, in Scala the above is shorthand for the following refinement type:

```
def doSomething(x : AnyRef { def bar: Unit }) = ...
```

which says that x must be a subtype of AnyRef and must have a bar method. The type of x is a "refinement" of AnyRef with an additional constraint.


#### Type alias

The following example shows one of the  uses of the keyword 'type'

```
trait Box {
   type A
   def name: A
}

class ShoeBox extends Box {
    type A = String
    def name: A = "Shoe Box"
}
```

### Thanks

[Scala Annotations](http://docs.scala-lang.org/style/types.html#annotations) - describes the use of annotations.

[Programming  in Scala - Abstract Members](http://www.artima.com/pins1ed/abstract-members.html) - includes examples of using the keyword 'type'.

[Real-world Scala: Dependency Injection (DI)](http://jonasboner.com/real-world-scala-dependency-injection-di/) - adapted approach used in the notes.

[Java Has Type Inference and Refinement Types ( But With Strange Restrictions)](http://james-iry.blogspot.co.uk/2009/04/java-has-type-inference-and-refinement.html) - describes 'Refinement Types'.

[AdvancedScalaObjects](http://naildrivin5.com/scalatour/wiki_pages/AdvancedScalaObjects/) - step-by-step description of the difference between 'case class' and class.


### Licence

[See Licence](/LICENSE)
