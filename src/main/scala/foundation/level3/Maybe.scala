package foundation.level3

sealed trait Maybe[+A]
case class Just[+A](value: A) extends Maybe[A]
case object Empty extends Maybe[Nothing]

def divideByZero(a: Int, b: Int): Maybe[Int] =
  if b == 0 then Empty else Just(a / b)

@main def runYourOwnContainerStep1(): Unit =
  println("=== Step 1: The container only (Maybe1, Just1, Empty1) ===\n")
  println(
    "We have two cases: a value (Just1) or nothing (Empty1). No map/flatMap yet."
  )
  println(s"   Just1(42) = ${Just(42)}")
  println(s"   Empty1 = $Empty")
  println("\nDone.")
