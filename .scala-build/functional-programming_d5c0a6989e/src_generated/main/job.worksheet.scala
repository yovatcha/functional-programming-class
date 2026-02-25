

final class job$u002Eworksheet$_ {
def args = job$u002Eworksheet_sc.args$
def scriptPath = """job.worksheet.sc"""
/*<script>*/
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

val result5 = dothing((a: Int) => a * 2, doThing(a: Int) => a + 2, 1)

def chain2(f1: Int => Int, f2: Int => Int, a: Int): Int =
  f2(f1(a))

val result5 = chain2(a => a + 2, a => a * 2, 1)  // 6
/*</script>*/ /*<generated>*//*</generated>*/
}

object job$u002Eworksheet_sc {
  private var args$opt0 = Option.empty[Array[String]]
  def args$set(args: Array[String]): Unit = {
    args$opt0 = Some(args)
  }
  def args$opt: Option[Array[String]] = args$opt0
  def args$: Array[String] = args$opt.getOrElse {
    sys.error("No arguments passed to this script")
  }

  lazy val script = new job$u002Eworksheet$_

  def main(args: Array[String]): Unit = {
    args$set(args)
    val _ = script.hashCode() // hashCode to clear scalac warning about pure expression in statement position
  }
}

export job$u002Eworksheet_sc.script as `job.worksheet`

