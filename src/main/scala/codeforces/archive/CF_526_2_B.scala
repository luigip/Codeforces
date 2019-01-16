package codeforces.archive

object CF_526_2_B {
  def solve(n: Int, s: Long, vs: Seq[Int]): Long = {
    val minKegVol = vs.min.toLong
    val totalVol = vs.map(_.toLong).sum
    // amount taken before minKeg starts emptying
    val b = totalVol - n * minKegVol
    val excess = s - b
    if (excess <= 0) minKegVol
    else {
      val taken= ceil(excess, n)
      val left = minKegVol - taken
      if (left < 0) -1 else left
    }
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) = (i.int, i.long, {i.nextLine; i.intSeq()})
  def formatOut(out: Long) = out.toString

//     ~~~ Boilerplate that doesn't change ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }

//     ~~~ Utility methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  import java.util.Scanner
  class Input(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s.stripMargin))
    def int = sc.nextInt()
    def long = sc.nextLong()
    def double = sc.nextDouble()
    def nextLine = sc.nextLine()
    // If there are prior values, remember to call nextLine to advance past the newline character before collecting the line:
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
    def intSeq() = collect(_.toInt)
    def doubleSeq() = collect(_.toDouble)
    def solveVals = (solve _).tupled(formatIn(this))
    def solveStr = formatOut(solveVals)
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
}
