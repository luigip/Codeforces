package codeforces.archive

object CF_521_3_B {
  def solve(n: Int, as: Seq[Int]): Int = {
    def turnOff(as: Seq[Int], count: Int, out: Seq[Int]): (Seq[Int], Int) = as match {
      case 1 +: 0 +: 1 +: _  => turnOff(as.updated(2,0).tail, count + 1, out :+ 1)
      case a +: _ +: _ +: _  => turnOff(as.tail, count, out :+ a)
      case Seq(a,b) => (out :+ a :+ b, count)
    }
    val result = turnOff(as, 0, Seq.empty)
    result._2
  }

  // `solution` is defined by the input format - and can be called both from main and test script without repeating
  def solution(i: Input) = solve(i.int, {i.nextLine; i.intSeq()})


//     ~~~ Boilerplate that doesn't change ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
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
