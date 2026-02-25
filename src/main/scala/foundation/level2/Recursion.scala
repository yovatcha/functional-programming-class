package foundation.level2
//sbt "runMain foundations.runRecursion"
import scala.annotation.tailrec
import scala.annotation.targetName

def factorial(n: Int): Int =
  if n <= 1 then 1
  else n * factorial(n - 1)

def transform(list: List[String]): List[String] =
  if list.isEmpty then Nil
  else "Title: " + list.head :: transform(list.tail)

def transformPlus5(list: List[Int]): List[Int] =
  if list.isEmpty then Nil
  else (list.head + 5) :: transformPlus5(list.tail)



extension (list: List[Int])
  @targetName("transformWith")
  def transformWith(f: Int => Int): List[Int] =
    if list.isEmpty then Nil
    else f(list.head) :: list.tail.transformWith(f)
 
val students1 = List("Alice", "Bob", "Charlie", "David", "Eve")
val scores1 = List(100, 90, 80, 70, 60)

@main def runRecursion(): Unit =
  println(factorial(5))
  println(transform(students1))
  println(transformPlus5(scores1))
  println(scores1.transformWith(a => a * 5))