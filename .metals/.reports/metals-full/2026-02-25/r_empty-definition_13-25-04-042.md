error id: file://<WORKSPACE>/src/main/scala/foundation/level2/Recursion.scala:head.
file://<WORKSPACE>/src/main/scala/foundation/level2/Recursion.scala
empty definition using pc, found symbol in pc: head.
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -list/head.
	 -list/head#
	 -list/head().
	 -scala/Predef.list.head.
	 -scala/Predef.list.head#
	 -scala/Predef.list.head().
offset: 303
uri: file://<WORKSPACE>/src/main/scala/foundation/level2/Recursion.scala
text:
```scala
package foundation.level2
//sbt "runMain foundations.runRecursion"
import scala.annotation.tailrec
import scala.annotation.targetName

def factorial(n: Int): Int =
  if n <= 1 then 1
  else n * factorial(n - 1)

def transform(f: list => B): List[B] =
  if list.isEmpty then Nil
  else "Title: " + list.h@@ead :: transform(list.tail)
  
val students1 = List("Alice", "Bob", "Charlie", "David", "Eve")
val scores1 = List(100, 90, 80, 70, 60)

@main def runRecursion(): Unit =
  println(factorial(5))
  println(transform(students1))
```


#### Short summary: 

empty definition using pc, found symbol in pc: head.