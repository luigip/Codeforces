// date: 04/12/2018
// tested working online: YES / NO

package codeforces

import scala.collection.SortedSet

object CF_525_2_B {
  type VI = Vector[Int]
  // try sorting first then keeping tally of amount substracted


  def solve(n: Int, k: Int, as: VI): VI = {
    def loop(pass: Int, xs: Seq[Int], totalSubtracted: Long, out: VI): VI = pass match {
      case 0 => out
      case _ => xs match {
        case Vector() => out ++ Vector.fill(pass)(0)
        case Vector(a, rest@_*) =>
          val a1 = (a.toLong - totalSubtracted) max 0
          loop(pass - 1, rest.dropWhile(_ <= a), totalSubtracted + a1, out :+ a1.toInt)
      }
    }

//    val ss = SortedSet(as)
    loop(k, as.sorted.dropWhile(_==0), 0, Vector.empty)
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