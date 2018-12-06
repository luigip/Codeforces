// date: 04/12/2018
// tested working online: YES / NO

package codeforces

object CF_525_2_B {
  type VI = Vector[Int]
  // try sorting first then keeping tally of amount substracted


  def solve(n: Int, k: Int, as: VI): VI = {
    def loop(pass: Int, xs: VI, out: VI): VI = pass match {
      case 0 => out
      case _ => xs match {
        case Vector() => out ++ Vector.fill(pass)(0)
        case _ =>
          val min = xs.min
          val ys = for(x <- xs; if x - min > 0) yield x - min
          loop(pass - 1, ys, out :+ min)
      }
    }
    loop(k, as, Vector.empty)
  }
  
  def main(args: Array[String]) = {
    val io = new IO(System.in); import io._
    val solution = solve(int, int, {nextLine; intSeq()})
    solution foreach println
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