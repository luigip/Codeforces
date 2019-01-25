package codeforces

object CF_535_3_D {
// date: 25/01/2019

  type In  = (Int, String)
  type Out = String
  
  def solve(in: In): Out = {
    val (n, s) = in
    val m = Map('R' -> Seq('G','B'), 'G' -> Seq('B','R'), 'B' -> Seq('G','R'))

    def loop(cs: Seq[Char], out: Seq[Char]): Seq[Char] = cs match {
      case Seq(a) =>              out :+ a
      case Seq(a, b) if a == b => out :+ a :+ m(a)(0)
      case Seq(a, b)           => out :+ a :+ b
      case a +: b +: c +: rest =>
        if (a == b && c == m(a)(0))  loop(m(a)(1) +: c +: rest, out :+ a)
        else if (a == b)             loop(m(b)(0) +: c +: rest, out :+ a)
        else                         loop(cs.tail, out :+ a)
    }

    val res = loop(s.toList, Vector.empty).mkString
    def differences(xs: Seq[Char], ys: Seq[Char]) = (xs, ys).zipped.count(i => i._1 != i._2)
    val diffs = differences(s, res)
    s"$diffs\n$res"
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, {i.nextLine; i.nextLine})
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
