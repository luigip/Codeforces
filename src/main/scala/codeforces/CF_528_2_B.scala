// date: 29/12/2018
// tested working online: YES

package codeforces

object CF_528_2_B {

  type In = (Int, Int)
  type Out = Int
  
  def solve(in: In): Out = {
    val (n, k) = in

    // f1 is x / k
    // f2 is x % k
    // both are factors of n
    // f2 must be smaller than k
    // x is minimized where x/k is minimized, hence f1 must be as small as possible
    // hence f2 is the largest factor smaller than k, and f1 = n/f2

    val sqrtn = math.sqrt(n).toInt

    def findFactors(i: Int, out: Vector[Int], compout: Vector[Int]): Seq[Int] =
      if (i > sqrtn) out ++ compout
      else if (n%i == 0) findFactors(i + 1, out :+ i, n/i +: compout)
      else findFactors(i + 1, out, compout)

    val factorsOfN = findFactors(1, Vector.empty, Vector.empty)

    val i = factorsOfN.lastIndexWhere(_ < k)
    val f2 = factorsOfN(i)
    val f1 = n / f2
    val x = k*f1 + f2
    x
  }

  // Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, i.int)
  def formatOut(out: Out): String  = out.toString

  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  // Boilerplate & utility methods that don't change:

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
    // Remember to call nextLine to advance past the newline character 
    // (if required) before taking a whole line
    def this(i: InputStream) =       this(new Scanner(i))
    def this(s: String) =            this(new Scanner(s.stripMargin))
    def int =                        sc.nextInt()
    def long =                       sc.nextLong()
    def double =                     sc.nextDouble()
    def nextLine =                   sc.nextLine()
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
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