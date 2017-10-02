# Function Signatures

I struggle with Scala's <i>function signatures</i>, for example:

```{scala}

def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = ???

```
where I can just about understand what is required for an implementation but I usually resort to 'trail and error' which is very limiting. The following notes, and accompanying software, are an attempt to develop an approach to the implementation of <i>function signatures</i> in a more systematic.

First is to understand what an <i>anonymous function</i> ( or can be called a <i>literal function</i>) is. Examples of anonymous functions ( a function without a name ) are:

```{scala}
scala> val addOne = (x:Int) => x + 1
scala> addOne(3)
res0: Int = 4
```

With two arguments:

```{scala}
scala> val add => (x: Int, y: Int) => x + y
scala> add(2,3)
res0: Int = 5
```
Or a two part function:

```{scala}
scala> val twoPart = (x:Int) => (y:Int) => x + y + 2
twoPart: Int => (Int => Int)
scala> twoPart(10)(10)
res0: Int = 22
```

```{scala}
scala> val twoPart_one = twoPart(10)(_)
twoPart_one: Int => Int
scala> twoPart_one(12)
res5: Int = 24
```

How about three arguments ?

```{scala}
scala> val threePart = (x:Int) => (y:Int) => (z:Int) => x + y + z
threePart: Int => (Int => (Int => Int))
scala> threePart(1)(2)(3)
res6: Int = 6
```

and finally a tuple:

```{scala}
scala> val tuple = (x: Int) => (x, x+1)
tuple: Int => (Int, Int)
scala> tuple(2)
res0: (Int, Int) = (2,3)
```

The following are typical function signatures use din Scala:

#### Example: Comparator Function

The Comparator Function applies a comparator function to an Array:

```{scala}

def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {

   @annotation.tailrec
   def iter(n: Int): Boolean =
      if ( n >= as.length - 1) true
      else if ( ordered(as(n), as(n+1)) ) false
      else iter(n+1)

      iter(0)  // start at the first element

}


```

#### Example: Partial Function

A partial function's signature is:

```{scala}

def partial[A,B,C](a: A, f: (A,B) = C)): B => C = ???

```

which takes a a value and a two valued function and returns a function of one value. We are looking for a function that returns a type parameter C, which comes from the two valued function which now gives:

```{scala}

def partial[A,B,C](a: A, f: (A,B) = C)): B => C =
     b => f(a,b)

```

#### Example: Currying

[Currying](https://en.wikipedia.org/wiki/Currying) is the technique of taking a function that takes multiple arguments and evaluates it as a sequence of single valued functions. Note that this is different than a partial function which fixes the value of one of a functions arguments.

The function signature for a two valued function is:

```{scala}

def curry[A,B,C](f: (A, B) = > C): A => ( B => C) = ???

```

Starting with the "B => C" which can be got from the two valued function which gives b => f(a,b), and using the fact that a => b gives the following:

```{scala}

  def curry[A,B,C](f: (A, B) = > C): A => ( B => C) =
      a => b => f(a,b)

```


#### Example: Uncurry

```{scala}

  def uncurry[A,B,C]( f: A => B => C ): (A,B) => C = ???

```

Starting with the function that has two single arguments return a tuple (a, b) which can be got by applying 'a' to the HoF which returns a function that consumes a 'b' which returns a C.

```{scala}

def uncurry[A,B,C](f: A => B => C):(A,B) => C = (a,b) => f(a)(b)

```

#### Example: Compose

```{scala}

  def compose[A,B,C]( f: B => C, g: A => B ): A => C = ???

```
Apply 'a' to the 'g' function to return a B value then apply the B value to the 'f' function to return a C value.

```{scala}

def compose[A,B,C]( f: B => C, g: A => B ): A => C = a => f(g(a))

```

#### Example: map

```{scala}

def map[A,B](as:List[A])(f: A => B ): List[B] = ???

```


```{scala}

def map[A,B](as:List[A])(f: A => B ): List[B] =
    as match {                
       case List() => List()  
       case head::tail => List(f(head)) ::: map(tail)(f)
 }

```


#### Example: flatmap

```{scala}

def flatmap[A,B](as: List[A])(f: A => List[B]): List[B] = ???

```

```{scala}

def flatmap[A,B](as: List[A])(f: A => List[B]): List[B] =
      as match {
         case List() => List()           
         case head :: tail => f( head ) ::: latmap(tail)(f)

}

```

#### Example: filter


```{scala}

def filter[A](as: List[A])(f: A => Boolean): List[A] = ???

```

```{scala}

def filter[A](as: List[A])(f: A => Boolean): List[A] =
      as match {                
        case List() => List()      
        case head :: tail => if ( f ( head )) List(head) :::        filter(tail)(f) else List() ::: filter(tail)(f)
}

```


#### Example: foldRight


```{scala}

def foldRight[A,B](as: List[A])(op: (A, B) => B): B = ???

```

```{scala}

def foldRight[A,B](as: List[A], z: B)(op: (A, B) => B): B =
         as match {
              case Nil => z
              case head :: tail =>  op( head, verbose_foldRight( tail, z )( op ))
 }

```

#### Example: State

```{scala}

case class State[S, +A](run: S => (S, A)){

      def map[B](g: A => B):State[S,B] = ???

      def flatMap[B](g: A => State[S,B]) = ???

}

```

```{scala}
   case class State[S, +A](run: S => (S, A)){

        def map[B](g: A => B):State[S,B] = State {
             s => val (s1, a) = run(s)
             (s1, g(a))
         }

        def flatMap[B](g: A => State[S,B]): State[S,B] =
           State{ s =>
                val (s1, a ) = run(s)
                g(a) run s1 }

    }

```

# Thanks

[Implementing a higher order function that performs currying in
scala](https://stackoverflow.com/questions/13793756/implementing-a-higher-order-function-that-performs-currying-in-scala) - where I got the idea of the verbose approach used in the accompanying software ( see at the bottom of the page ).

[A Tour of Scala: Polymorphic Methods](https://www.scala-lang.org/old/node/121.html) - example of using Polymorphic methods.

[Scala: method\operator overloading](https://stackoverflow.com/questions/1991240/scala-method-operator-overloading) - can a polymorphic function use operator overload ?

# Licence

[See Licence](/LICENSE)
