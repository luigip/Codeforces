package codeforces.archive

object CF_521_3_A {

  def solve(ss: Seq[(Int, Int, Int)]): String = {
    val sols = for {
      (a,b,k) <- ss
      dist = (a - b).toLong * (k/2)
    } yield if (k%2 == 0) dist else dist + a
    sols.mkString("\n")
  }

  def solution(i: Input) = {
    val n = i.int
    val lines = 1 to n map {_ => {i.nextLine; (i.int, i.int, i.int)}}
    solve(lines)
  }


//     ~~~ Boilerplate ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val sol = solution(new Input(System.in))
    out.println(sol)
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
