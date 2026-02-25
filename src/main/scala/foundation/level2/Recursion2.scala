package foundation.level2

val students = List("Alice", "Bob", "Charlie", "David", "Eve")
val scores = List(100, 90, 80, 70, 60)
val products = List(("Apple", 1.0), ("Banana", 2.0), ("Cherry", 3.0))

extension [A, B](list: List[A])
  /** Transforms each element with `f`. Recursive implementation (like map). */
  def transformMap(f: A => B): List[B] =
    if list.isEmpty then Nil
    else f(list.head) :: list.tail.transformMap(f)

  /** Keeps only elements that satisfy `p`. Recursive implementation (like
    * filter).
    */
  def keepOnly(p: A => Boolean): List[A] =
    if list.isEmpty then Nil
    else if p(list.head) then list.head :: list.tail.keepOnly(p)
    else list.tail.keepOnly(p)

@main def runExtensionMethod(): Unit =
    println("----------------")
    println(students.transformMap((name => "Name: " + name)))
    println(scores.transformMap((score => score + 10)))
    println(products.transformMap((product => product._1 + " - " + product._2)))
    println(students.keepOnly(_.startsWith("A")))
    println(scores.keepOnly(_ >= 80))
