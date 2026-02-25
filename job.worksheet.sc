println("Hello, World!")
val a = 10
val b = 20
val c = a + b
println(c - 25)


def add(a: Int, b: Int): Int = {
  a + b
}
val result = add(3, 4)

def multiply(x: Int, y: Int): Int = x * y
val result2 = multiply(9, 10)

def doThing(f: Int => Int, a: Int): Int = f.apply(a)
val result3 = doThing((a: Int) => a + 2, 1)
val result4 = doThing((a: Int) => a * 2,3)

// val result5 = dothing((a: Int) => a * 2, doThing(a: Int) => a + 2, 1)

//my try
def tryChain(f1: Int => Int, f2: Int => Int, a: Int): Int =
  f2(f1(a))

val result6 = tryChain(a => a + 2, a => a * 2, 1)

def calculate(factor: Int)(value: Int): Int = factor * value

val triple = calculate(3) _ // Partially applied function
val result7 = triple(10)     // Result is 30

