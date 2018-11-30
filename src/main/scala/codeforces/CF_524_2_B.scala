package codeforces

object CF_524_2_B {
  def solve(input: Vector[Range]): String = {
    def isOdd(n: Int) = n%2 != 0
    def convert(r: Range): Int = (r.start, r.end) match {
      case (a, b) if isOdd(a) =>
        if(isOdd(b))
          // end odd => (b + 1) is even => +ve => take it away
          convert(a to (b + 1)) - (b + 1)
        else (b - a + 1)/2
      // start even
      case (a, b) =>
        if(isOdd(b))
          (b - a + 1)/(-2)
        // end even => (b + 1) is odd => -ve => add it back
        else convert(a to (b + 1)) + (b + 1)
    }
    input.map(convert).mkString("\n")
  }

  def main(args: Array[String]): Unit = {
    val io = new IO(System.in)
    val lines = io.int()
    io.sc.nextLine()
    def s2r(xs: Seq[Int]) = xs(0) to xs (1)
    val input = Vector.fill(lines)(io.intSeq()).map(s2r)
    val solution = solve(input)
    println(solution)
  }


//// boilerplate utility methods:
    import java.util.Scanner
    class IO(val sc: Scanner) {
      def this(i: java.io.InputStream) = this(new Scanner(i))
      def this(s: String) = this(new Scanner(s))
      def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
      def intSeq() = collect(_.toInt)
      def doubleSeq() = collect(_.toDouble)
      def int() = sc.nextInt()
      def double() = sc.nextDouble()
    }
}