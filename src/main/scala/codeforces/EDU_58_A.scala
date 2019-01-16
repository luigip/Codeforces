package codeforces

// date: 11/01/2019
// tested working online: YES / NO

object EDU_58_A {

  type In = (Int, Seq[(Int, Int, Int)])
  type Out = String
  
  def solve(in: In): Out = {
    val (n, xs) = in
    val result = for {
      (l, r, d) <- xs
    } yield if(d<l) d else (r/d + 1) * d
    result.mkString("\n")

  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, {i.nextLine; i.getLines.map{l => l.split(" ") match {case Array(a,b,c) => (a.toInt,b.toInt,c.toInt)}}})
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
