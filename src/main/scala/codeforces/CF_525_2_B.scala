// date: 04/12/2018
// tested working online: YES
package codeforces

import java.io.PrintWriter
import scala.collection.SortedSet

object CF_525_2_B {

/*This problem took ages because it kept exceeding the time limit
* Hence tried various mutable / imperative solutions - didn't help
* Needed to use a PrintWriter instead of writing directly to System.out,
* which approximately halved the runtime*/
  def solve(n: Int, k: Int, as: Vector[Int]): Seq[Int] = {
    val xs = SortedSet(as: _*).toStream
    val xs0 = 0 #:: xs
    val result: Seq[Int] = (xs0, xs).zipped.map((a, b) => b-a).take(k).padTo(k, 0)
    result
  }

  def main(args: Array[String]) = {
    val io = new IO(System.in); import io._
//    val n = 100000 // 2060 ms using normal printer; 1007 ms using PrintWriter
//    val bigTest = for(i <- 1 to n) yield util.Random.nextInt(n) + 1
//    println(bigTest)
//    val io = new IO(s"$n $n\n" + bigTest.mkString(" ")); import io._
//    val t0 = System.currentTimeMillis()
    val solution = solve(int, int, {nextLine; intSeq()})
    val out = new PrintWriter(System.out)
    solution foreach out.println
    out.close()
//    val t1 = System.currentTimeMillis()
//    println(s"Time in ms: ${t1-t0}")

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