error id: file://<WORKSPACE>/src/main/scala/foundation/level2/Recursion.scala:
file://<WORKSPACE>/src/main/scala/foundation/level2/Recursion.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -list.
	 -scala/Predef.list.
offset: 318
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

def transform(f: A => B): List[B] =
  if list.isEmpty then Nil
  else "Title: " + list.head :: transform(l@@ist.tail)
  
val students1 = List("Alice", "Bob", "Charlie", "David", "Eve")
val scores1 = List(100, 90, 80, 70, 60)

@main def runRecursion(): Unit =
  println(factorial(5))
  println(transform(students1))
```


#### Short summary: 

empty definition using pc, found symbol in pc: 