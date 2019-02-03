package codeforces

object CF_535_3_E2 {
// date: 30/01/2019
  // Not working (too slow)

  type In  = (Int, Int, Array[Int], Seq[(Int, Int)])
  type Out = (Int, Int, Seq[Int])
  
  def solve(in: In): Out = {
    val (n, m, as, lrs) = in

    def reduce(a: Array[Int], s1: Int, s2: Int): Unit = for {
      i <- (s1 - 1) until s2
    } a(i) -= 1

    var maxDiff = 0
    var segsMaxDiff: List[Int] = Nil

    for (i <- as.indices) {
      val arr = as.clone
      var segs: List[Int] = Nil
      for {
        j <- lrs.indices
        (l, r) = lrs(j)
        if (i+1) >= l && (i+1) <= r
      } {
        segs = j :: segs
        reduce(arr, l, r)
      }
      val diff = arr.max - arr(i)
      if(diff >= maxDiff) {
        maxDiff = diff
        segsMaxDiff = segs
      }
    }

    (maxDiff, segsMaxDiff.size, segsMaxDiff.map(_+1))
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (
    i.int, i.int, {i.nextLine;
    i.stringArray.map(_.toInt) },
    i.getLinesMap(j => (j.int, j.int)))
  def formatOut(out: Out): String  = {
    val (d, q, cs)= out
    s"$d\n$q\n${cs.mkString(" ")}"
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Boilerplate & utility methods that don't change (so ignore): 

  import java.io.InputStream
  import java.util.Scanner

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
    def stringArray: Array[String] = sc.nextLine().split(" ")
    def intSeq                     = collect(_.toInt)
    def doubleSeq                  = collect(_.toDouble)
    def getLines: Vector[String]   = if (!sc.hasNextLine) Vector.empty 
                                     else sc.nextLine +: getLines
    def getLines(lineCount: Int)   = {nextLine; (1 to lineCount).map(_ => sc.nextLine)}
    def getLinesMap[T](f: Input => T) = getLines.map(s => f(new Input(s)))
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
