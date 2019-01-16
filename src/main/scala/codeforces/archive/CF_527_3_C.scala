package codeforces.archive

object CF_527_3_C {
  def solve(n: Int, ss: Seq[String]): String = {
    val pairs: Map[Int, Seq[(String, Int)]] = ss.zipWithIndex.groupBy(_._1.length)
    // Look at longest two parts to give 2 possible strings
    val possibles: Seq[String] = pairs(n - 1) match {
      case Seq((a, _), (b, _)) => Seq(a + b.last, b + a.last)
    }

    def isPrefix(pre: String, s: String) = s.take(pre.length) == pre

    def isSuffix(suff: String, s: String) = s.takeRight(suff.length) == suff

    val strs: Seq[Seq[(String, Int)]] = pairs.values.toSeq

    def isValid(test: String, ps: Seq[Seq[(String, Int)]], out: Seq[(String, Int)]): Option[Seq[(String, Int)]] = ps match {
      case Seq() => Some(out)
      case Seq((n1, i), (n2, j)) +: tail =>
        if (isPrefix(n1, test) && isSuffix(n2, test)) isValid(test, tail, out :+ ("P", i) :+ ("S", j))
        else if (isPrefix(n2, test) && isSuffix(n1, test))
          isValid(test, tail, out :+ ("S", i) :+ ("P", j))
        else None
    }

    val result: String = possibles.map(p => isValid(p, strs, Nil)).find(_.isDefined).get.get.sortBy(_._2).map(_._1).mkString

    result
  }

//     ~~~ Specify Input and Output formats here:

  def formatIn(i: Input) = (i.int, {i.nextLine; i.getLines})
  def formatOut(out: String): String = out.toString

//     ~~~ Boilerplate & utility methods that don't change: ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
