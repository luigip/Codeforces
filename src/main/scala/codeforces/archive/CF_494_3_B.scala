package codeforces.archive

object CF_494_3_B {

  type In  = (Int, Int, Int)
  type Out = String

  def solve(in: In): Out = {
    val (a, b, x0) = in

    val (larger, smaller) = if (a > b) ("0", "1") else ("1", "0")
    val lruns = (x0 + 1)/2 + (x0 + 1) % 2
    val sruns = (x0 + 1)/2

    val ls = Seq.fill(lruns - 1)(larger) :+ larger * ((a max b) - (lruns - 1))
    val ss = Seq.fill(sruns - 1)(smaller) :+ smaller * ((a min b) - (sruns - 1))

    if ((x0 % 2) == 0)
      (ls, ss).zipped.map{_+_}.mkString + ls.last
    else
      (ls, ss).zipped.map{_+_}.mkString


//    def loop(as: Int, bs: Int, out: String, x: Int): String = (as, bs) match {
//      case (0, 0) => out
//      case (0, n) => out + "1"*n
//      case (n, 0) => out + "0"*n
//      case _ if x%2 == 0 =>
//
//        loop()
//      case _ if x%2 == 1 =>
//
//    }
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, i.int, i.int)
  def formatOut(out: Out): String  = out.toString

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Boilerplate & utility methods that don't change (so ignore):

  import java.util.Scanner
  import java.io.InputStream
  import language.implicitConversions

  def main(args: Array[String]): Unit = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }

  class Input(val sc: Scanner) {
    // This class is useful for convenience, and for mock stdin in test scripts
    // Remember to call nextLine to advance past the newline character (if required) before taking a whole line
    def this(i: InputStream)       = this(new Scanner(i))
    def this(s: String)            = this(new Scanner(s.stripMargin))
    def int                        = sc.nextInt()
    def long                       = sc.nextLong()
    def double                     = sc.nextDouble()
    def nextLine                   = sc.nextLine()
    def collect[T](f: String => T) = sc.nextLine().split(" ").toVector.map(f)
    def intSeq                     = collect(_.toInt)
    def doubleSeq                  = collect(_.toDouble)
    def getLines: Vector[String]   = if (!sc.hasNextLine) Vector.empty
                                     else sc.nextLine +: getLines
    def getLines(lineCount: Int)   = {nextLine; (1 to lineCount).map(_ => sc.nextLine)}
    def solveVal: Out              = (solve _).tupled(formatIn(this))
    def solveStr: String           = formatOut(solveVal)
  }

  // Ceiling division for Int & Long
  // `a` MUST be > 0. Incorrect otherwise.
  def divideCeil(a: Int, b: Int)   = (a - 1)/b + 1
  def divideCeil(a: Long, b: Long) = (a - 1)/b + 1

  // A frequently used number in these comps
  val modulo = 1000000007

  // For convenience in test scripts, treat a String as an Input
  implicit def stringToInput(s: String): Input = new Input(s)
  // Required to make `solveVal` work when input has just 1 value (i.e. not a Tuple)
  implicit class makeTupledWorkOnFunction1[-T,+R](f: T => R) {
    def tupled: T => R = x => f(x)
  }
}
