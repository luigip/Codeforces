// date: 07/12/2018
// tested working online: YES

package codeforces

object CF_522_2_B {

  case class Output(rows: Int, columns: Int, table: Seq[String])

  def solve(in: String): Output = {
    // Max 5 rows x 20 cols
    // Minimize number of rows (then cols)

    val n = in.length
    val rows = ceil(n,20)
    val cols = ceil(n, rows)
    val tableSize = rows * cols
    val remainder = tableSize - n
    def make(r: Int, s: String, out: Seq[String]): Seq[String] = r match {
      case 0 => out
      case _ =>
        val len = if (r <= remainder) cols - 1 else cols
        val (first, last) = s.splitAt(len)
        make(r - 1, last, out :+ first.padTo(cols,'*'))
    }
    val table = make(rows, in, Seq.empty)
    Output(rows, cols, table)
  }

  def solution(i: Input) = solve(i.string)

  
//     ~~~ Boilerplate ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  def main(args: Array[String]) {
    val out = new java.io.PrintWriter(System.out)
    val sol = solution(new Input(System.in))
    out.println(sol.rows + " " + sol.columns + "\n" + sol.table.mkString("\n"))
    out.close()
  }

//     ~~~ Utility methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  import java.util.Scanner
  class Input(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s.stripMargin))
    def int = sc.nextInt()
    def long = sc.nextLong()
    def double = sc.nextDouble()
    def string = sc.next()
    def nextLine = sc.nextLine() 
    // If there are prior values, remember to call nextLine to advance past the newline character before collecting the line:
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
    def intSeq() = collect(_.toInt)
    def doubleSeq() = collect(_.toDouble)
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
}