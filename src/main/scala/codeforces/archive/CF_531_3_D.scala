package codeforces.archive

object CF_531_3_D {

  type In  = (Int, String)
  type Out = String

  def solve(in: In): Out = {
  val (n, s) = in

  val target = n / 3
  val counts = List('0','1','2').map(i => (i, s.count(_ == i)))

  val replacees = for {
    (char, count) <- counts
    if count > target
    c <- Seq.fill(count - target)(char)
  } yield c

  val replacements = for {
    (char, count) <- counts
    if count < target
    c <- Seq.fill(target - count)(char)
  } yield c

  val (startPairs, endPairs) = replacees.zip(replacements).partition(p => p._1 > p._2)
  val startMap = startPairs.groupBy(_._1).mapValues(_.map(_._2)).withDefaultValue(Seq.empty)
  val endMap = endPairs.groupBy(_._1).mapValues(_.map(_._2).reverse).withDefaultValue(Seq.empty)

  def loop(ps: Map[Char, Seq[Char]], input: List[Char], output: List[Char]): List[Char] = input match {
    case Nil       => output
    case c +: tail => ps(c) match {
      case Seq()               => loop(ps, tail, c :: output)
      case replacement +: rest => loop(ps + (c -> rest), tail, replacement :: output)
    }
  }

    val fromStart = loop(startMap, s.toList, Nil)
    val fromEnd = loop(endMap, fromStart, Nil)
    fromEnd.mkString
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
