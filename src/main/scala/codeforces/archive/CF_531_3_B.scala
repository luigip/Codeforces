package codeforces.archive

object CF_531_3_B {

  type In  = (Int, Int, Seq[Int])
  type Out = Option[Seq[Int]]

  def solve(in: In): Out = {
    val (_, k, as) = in

    case class Elem(a: Int, index: Int, colour: Int)

    val maxLen = as.groupBy(identity).maxBy(_._2.length)._2.length

    val ais: Seq[Elem] = for {
      ((a, i), c) <- (as.zipWithIndex.sorted, Stream.iterate(0)(i => (i + 1) % k)).zipped.toVector
    } yield Elem(a, i, c + 1)

    if (maxLen > k || as.length < k) None
    else
      Some(ais.sortBy(_.index).map(_.colour))
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, i.int, {i.nextLine; i.intSeq})
  def formatOut(out: Out): String  = out.fold("NO")(s => "YES\n" + s.mkString(" ") + "\n")

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
