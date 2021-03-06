# Mathematics

- Matrix mathematics - see Matrix.scala
- Ordinary Differential Equation solver - see ODESolver.scala

# Background

The following information helped to develop the example software shown in the folders ( big thanks to all of the
authors):

* [Éamonn O'B-S's](https://medium.com/@eob) Blog [How you might create a Scala matrix library in a functional
programming style](https://medium.com/@eob/how-you-might-create-a-scala-matrix-library-in-a-functional-programming-style-760f8bf6ee6)
which was a great start to developing the Matrix manipulation routines.

* Christian Krause's [Scala-chart](https://github.com/wookietreiber/scala-chart) which was a great help in quickly charting the
solution to the ODEs. For example add the following to build.sbt:

<pre><code>  "com.github.wookietreiber" %% "scala-chart" % "latest.integration",
  "com.lowagie" % "itext" % "4.2.1"
</code></pre>

A typical call would be:

<pre><code> val data = for(i <- 1 to result.length - 1) yield(result(0)(i), result(1)(i))
 val chart = XYLineChart(data, title = "results")
 chart.plot.domain.axis.label = "x value"
 chart.show()
</code></pre>

* [Learning Scala: Euler's Method](http://lovehateubuntu.blogspot.co.uk/2009/11/learning-scala-eulers-method.html) - starting point for the
ODE solver that was developed, in particular developing a functional solution.

* ArgMax - gives an x-value ( input value ) and max gives a y-value ( output value ). What is the value of x that will produce the maximum of f(x) = 2x + 1 over the interval [-2,3] ? The answer is argmax(f) = 3, and the maximum value is f(3) = 2(3) + 1 = 7. Scala code taken from [Stackoverflow:how can I extend scala collections with an argmax method](http://stackoverflow.com/questions/3050557/how-can-i-extend-scala-collections-with-an-argmax-method) which shows how to collect a number of points.

# Licence

[See Licence](/LICENSE)
