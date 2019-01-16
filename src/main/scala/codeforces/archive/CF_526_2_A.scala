package codeforces.archive

object CF_526_2_A {
  def solve(n: Int, as: Seq[Int]): Int = {
    import math.abs
    def e(floor: Int, x: Int) = (abs(floor -x) + (floor - 1) + (x - 1)) * 2
    def total(x: Int) = as.zip(1 to n).map{case (p,f) => p * e(f, x)}.sum
    val X = 1 to n minBy total
    total(X)
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) = (i.int, {i.nextLine; i.intSeq})
  def formatOut(out: Int) = out.toString

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
