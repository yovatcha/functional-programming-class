

final class job$u002Eworksheet$_ {
def args = job$u002Eworksheet_sc.args$
def scriptPath = """job.worksheet.sc"""
/*<script>*/
println("Hello, World!")
val a = 10
val b = 20
val c = a + b
println(c)
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

