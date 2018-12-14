// date: 12/12/2018
// tested working online: YES

package codeforces

object CF_526_2_C {

  def solve(s: String): Int = {

    val justAB = s.filter(c => c == 'a' || c == 'b').toList

    def answer(seq: List[Char], last: Char, lastVal: Long, total: Long): Int = seq match {
      case Nil => total.toInt
      case 'a' :: tail => last match {
        case 'b' =>
          // If an 'a' is preceded by 'b', number of seqs stopping here is total of all previous seqs,
          // (all can continue here) plus 1 for the one that starts and ends here
          val thisVal = total + 1
          answer(tail, 'a', thisVal, (total + thisVal) % modulo)
        case 'a' =>
          // If an 'a' is preceded by 'a', the number of seqs stopping is the same as for the previous 'a', so we
          // add this 'a''s number to the total
          answer(tail, 'a', lastVal, (total + lastVal) % modulo)
      }
      case 'b' :: tail =>
        // A 'b' doesn't affect the last value or total
        answer(tail, 'b', lastVal, total)
    }
    answer(justAB, 'b', 0, 0)
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