// date: 31/12/2018
// tested working online: YES

package codeforces

//case class CoOrd(x: Int, y: Int)
//object CoOrd {
//  implicit val ord: Ordering[CoOrd] = Ordering.by(c => (c.x, c.y))
//}

object CF_528_2_C {

  type In = Seq[(Int, Int)]
  type Out = String
  
  def solve(in: In): Out = {
    val Seq(a, b, c) = in.sorted
    def right(a: (Int, Int), b: Int) = (a._1 to b).map(x => (x, a._2))
    def up(a: (Int, Int), b: Int) = if(b >= a._2) (a._2 to b).map(y => (a._1, y)) else (b to a._2).map(y => (a._1, y))
    // Go across, then up/down, then up/down, then across
    val squares = (right(a, b._1) ++ up((b._1, a._2), b._2) ++ up(b, c._2) ++ right((b._1, c._2), c._1)).toSet
    squares.size.toString + "\n" + squares.map { case (a, b) => s"$a $b" }.mkString("\n")
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input)    = i.getLines.map{_.split(" ")}.map{case Array(a,b) => (a.toInt, b.toInt)}
  def formatOut(out: Out): String  = out.toString

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Boilerplate & utility methods that don't change: 

  import java.util.Scanner
  import java.io.InputStream
  import language.implicitConversions
 
  def main(args: Array[String]): Unit = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }
  
  class Input(sc: Scanner) {
    // This class is useful for convenience, and for mock stdin in test scripts
    // Remember to call nextLine to advance past the newline character (if required) before taking a whole line
    def this(i: InputStream) =       this(new Scanner(i))
    def this(s: String) =            this(new Scanner(s.stripMargin))
    def int =                        sc.nextInt()
    def long =                       sc.nextLong()
    def double =                     sc.nextDouble()
    def nextLine =                   sc.nextLine()
    def collect[T](f: String => T) = sc.nextLine().split(" ").toVector.map(f)
    def intSeq =                     collect(_.toInt)
    def doubleSeq =                  collect(_.toDouble)
    def getLines: Vector[String] =   if (!sc.hasNextLine) Vector.empty 
                                     else sc.nextLine +: getLines
    def solveVal: Out =              (solve _).tupled(formatIn(this))
    def solveStr: String =           formatOut(solveVal)
  }

  // Ceiling division for Int & Long
  def ceil(a: Int, b: Int)   = (a - 1)/b + 1
  def ceil(a: Long, b: Long) = (a - 1)/b + 1
  
  // A frequently used number
  val modulo = 1000000007

  // For convenience in test scripts, treat a String as an Input 
  implicit def stringToInput(s: String): Input = new Input(s)
  // Required to make `solveVal` work when input has just 1 value (i.e. not a Tuple)
  implicit class makeTupledWorkOnFunction1[-T,+R](f: T => R) { 
    def tupled: T => R = x => f(x) 
  }
}