// date: 27/12/2018
// tested working online: YES / NO

package codeforces

object CF_527_3_B {
  def solve(n: Int, as: Seq[Int]): Int = {
    val pairs = as.sorted.grouped(2)
    pairs.map{
      case Seq(x,y) => math.abs(x-y)
    }.sum
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) =  (i.int, {i.nextLine; i.intSeq})
  def formatOut(out: Int): String = out.toString

//     ~~~ Boilerplate & utility methods that don't change ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }

  import java.util.Scanner
  class Input(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s.stripMargin))
    def int = sc.nextInt()
    def long = sc.nextLong()
    def double = sc.nextDouble()
    def nextLine = sc.nextLine()
    // Remember to call nextLine to advance past the newline character (if required) before collecting the line:
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
    def intSeq = collect(_.toInt)
    def doubleSeq = collect(_.toDouble)
    def getLines: Vector[String] = if (!sc.hasNextLine) Vector.empty else sc.nextLine +: getLines
    def solveVal = (solve _).tupled(formatIn(this))
    def solveStr = formatOut(solveVal)
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1
  val modulo = 1000000007

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
  implicit class makeTupledWorkOnFunction1[-T,+R](f: T => R) { def tupled: T => R = x => f(x) }
}