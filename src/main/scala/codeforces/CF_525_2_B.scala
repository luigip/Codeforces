// date: 04/12/2018
// tested working online: YES / NO

package codeforces

object CF_525_2_B {
  def solve(n: Int, k: Int, arr: Array[Int]): Vector[Int] = {
    // Going mutable for performance - blech
    if(arr.forall(_ == 0))
      Vector.fill(n)(0)
    else {
      var min = arr.filter(_ > 0).min
      var pass = 0
      var out = Vector.empty[Int]
      while (pass < k) {
        out :+= min
        var newMin = Int.MaxValue
        var i = 0
        var allAreZero = true
        while (i < arr.length) {
          if (arr(i) > 0) {
            arr(i) -= min
            if (arr(i) > 0) {
              allAreZero = false
              if (arr(i) < newMin)
                newMin = arr(i)
            }
          }
          i += 1
        }
        if(allAreZero) min = 0 else min = newMin
        pass += 1
      }
      out
    }
  }
  
  def main(args: Array[String]) = {
    val io = new IO(System.in); import io._
    val solution = solve(int, int, {nextLine; intSeq()}.toArray)
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