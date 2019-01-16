package codeforces.archive

object C_1089_L {
  def solve(n: Int, k: Int, as: Seq[Int], bs: Seq[Int]): Long = {
    val spareJobs = ((1 to k).toSet diff as.toSet).size
    val idlers = as.zip(bs)
    // idlers with less than max persuasion time)
    val spareIdlers = idlers.groupBy(_._1).mapValues(xs => xs.sortBy(-_._2).tail).values.flatten
    val leastTimes = spareIdlers.toSeq.map(_._2.toLong).sorted.take(spareJobs)
    leastTimes.sum
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) = {
    val n = i.int
    val k = i.int
    i.nextLine
    val as = i.intSeq
    val bs = i.intSeq
    (n,k,as,bs)
  }
  def formatOut(out: Long): String = out.toString

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
    def intSeq = collect(_.toInt)
    def doubleSeq = collect(_.toDouble)
    def solveVal = (solve _).tupled(formatIn(this))
    def solveStr = formatOut(solveVal)
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1
  val modulo = 1000000007

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
  implicit class makeTupledWorkOnFunction1[-T,+R](f: T => R) { def tupled: T => R = x => f(x) }
}
