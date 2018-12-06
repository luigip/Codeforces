// Passed online

package codeforces

object CF_518_2_A {
  def solve(N: Long, // number of coin types
            M: Long, // number of friends
            K: Long, // how many types Ivan has
            L: Long  // min number of new types
           ): Long = {
    val maxTypes = (N/M)*M
    val needed = K + L
    if (needed > maxTypes) -1 else  Utility.longCeil(needed, M)
  }
  
  def main(args: Array[String]) = {
    val io = new IO(System.in)
    val solution = solve(io.long, io.long, io.long, io.long)
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