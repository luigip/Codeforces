package codeforces.archive

object CF_525_2_A {
  def solve(x: Int):Option[(Int, Int)] = {
    for {
      a <- 1 to x
      b <- 1 to a
      if a % b == 0 && a * b > x && a / b < x
    } return Some(a, b)
  return None
  }


  def main(args: Array[String]) = {
    val io = new IO(System.in)
    val solution = solve(io.int).fold("-1"){case(a,b) => s"$a $b"}
    println(solution)
  }


/// boilerplate utility methods: ///
    import java.util.Scanner
    class IO(sc: Scanner) {
      def this(i: java.io.InputStream) = this(new Scanner(i))
      def this(s: String) = this(new Scanner(s))
      def nextLine = sc.nextLine() // do this if still on previous line before collecting line of data
      def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
      def intSeq() = collect(_.toInt)
      def doubleSeq() = collect(_.toDouble)
      def int() = sc.nextInt()
      def long() = sc.nextLong()
      def double() = sc.nextDouble()
    }

    object Utility {
      def intCeil(a: Int, b: Int) = (a - 1) / b + 1
      def longCeil(a: Long, b: Long) = (a - 1) / b + 1
    }
}
