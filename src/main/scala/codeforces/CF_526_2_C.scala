// date: 12/12/2018
// tested working online: YES / NO

package codeforces
  import scala.util.matching.Regex

object CF_526_2_C {

  def solve(s: String): Int = {
//    def split(in: String, out: Seq[Seq[Long]], last: Long): Seq[Seq[Long]] = {
//      def stringToPowers(str: String) = Seq.iterate(last, str.filter(_=='a').length)(x => (x*2) % modulo)
//      in.indexOfSlice("aa") match {
//        case -1 => out :+ stringToPowers(in)
//        case i =>
//          val (a,b) = in.splitAt(i+1)
//          val seq = stringToPowers(a)
//          split(b, out :+ seq, seq.last)
//      }
//    }
    val justAB = s.filter(c => c == 'a' || c == 'b').toList
    def answer(seq: List[Char], last: Char, lastVal: Long, total: Long): Int = seq match {
      case Nil => assert(total < Int.MaxValue); total.toInt
      case 'a' :: tail => last match {
        case 'b' =>
          val n = total + 1
          answer(tail, 'a', n, (total + n) % modulo)
        case 'a' => answer(tail, 'a', lastVal, (total + lastVal) % modulo)
      }
      case 'b' :: tail => answer(tail, 'b', lastVal, total)
    }
    answer(justAB, 'b', 0, 0)
    

    //    val longs = split(justAB, Vector.empty, 1)
//    (longs.map(_.sum).sum % modulo).toInt
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) = i.nextLine
  def formatOut(out: Int) = out.toString


//     ~~~ Boilerplate & utility methods that don't change ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }

  import java.util.Scanner

  import scala.util.matching.Regex
  class Input(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s.stripMargin))
    def int = sc.nextInt()
    def long = sc.nextLong()
    def double = sc.nextDouble()
    def nextLine = sc.nextLine() 
    // Remember to call nextLine to advance past the newline character (if required) before collecting the line:
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
    def intSeq() = collect(_.toInt)
    def doubleSeq() = collect(_.toDouble)
    def solveVals = (solve _).tupled(formatIn(this))
    def solveStr = formatOut(solveVals)
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1
  val modulo = 1000000007

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
  implicit class makeTupledWorkOnFunction1[-T,+R](f: T => R) { def tupled: T => R = x => f(x) }
}