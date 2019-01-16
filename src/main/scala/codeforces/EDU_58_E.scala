package codeforces

// date: 11/01/2019
// tested working online: YES / NO

object EDU_58_E {

  type In = (Seq[String])
  type Out = Seq[String]
  type Data = (String, Int, Int)

  def solve(in: In): Out = {
    val (xs) = in

    val as: Seq[Data] =
      xs.map(_.split(" ") match {case Array(op, x, y) => (op, x.toInt, y.toInt)})

    def loop(lines: Seq[Data], longmax: Int, shortmax: Int, out: Seq[String]): Seq[String] = lines match {
      case Seq()                  => out
      case ("+", x, y) +: rest    => loop(rest, longmax max (x max y), shortmax max (x min y), out)
      case ("?", h, w) +: rest  =>
        val s = if (longmax <= (h max w) && shortmax <= (h min w)) "YES" else "NO"
        loop(rest, longmax, shortmax, out :+ s)
    }

    loop(as, 0, 0, Vector.empty)
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = i.getLines(i.int)
  def formatOut(out: Out): String  = out.mkString("\n")

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
    def getLines(lineCount: Int)   = {nextLine; (1 to lineCount).map(_ => sc.nextLine)}
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
