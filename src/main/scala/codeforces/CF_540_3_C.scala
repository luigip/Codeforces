package codeforces

object CF_540_3_C {
// date: 19/02/2019

  type In  = (Int, Seq[Int])
  type Out = (String, Seq[Seq[Int]])
  
  def solve(in: In): Out = {
    val (n, xs) = in

//    val sizes = xs.groupBy(identity).mapValues(_.size).toSeq.sortBy(_._2)
    val xss = xs.sorted

    def mirrorEven(ys: Seq[Int]): Seq[Seq[Int]] = {
      val tl = ys.grouped(n/2).toSeq
      val bl = tl.reverse
      val l = tl ++ bl
      l.map(s => s ++ s.reverse)
    }

    def mirrorOdd(ys4: Seq[Int], ys2: Seq[Int], ys1: Int): Seq[Seq[Int]] = {
      val tl = ys4.grouped((n-1)/2).toSeq
      val Seq(ms1, ms2) = ys2.grouped((n-1)/2).toSeq
      val l = Seq(tl, Seq(ms1), tl.reverse).flatten
      val m = Seq(ms2, Seq(ys1), ms2.reverse).flatten
      (l, m).zipped.map((row, n) => Seq(row, Seq(n), row.reverse).flatten)
    }

    val result: Option[Seq[Seq[Int]]] = if(n%2 == 0) // even, we need (n/2)^2 groups of 4
      {
        val groups = xss.grouped(4).toSeq
        if(groups.forall{seq => seq.forall(_ == seq.head)}) Some(mirrorEven(groups.map(_.head)))
        else None
      }
    else         // odd, we need ((n-1)/2)^2 groups of 4, (n-1)/2 groups of 2, 1 group of 1
      {

        ???
      }
    result.fold(("NO", Seq.empty[Seq[Int]]))(o => ("YES", o))
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, {i.nextLine; i.intSeq})
  def formatOut(out: Out): String  = out._1 + "\n" + out._2.map(_.mkString(" ")).mkString("\n")

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
