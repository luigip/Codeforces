package codeforces
// Passed online

object EDU_55_A {
  def solve(input: Vector[Int]): Int = {
    val Seq(n,x,y,d) = input
    // Page y is reachable iff:
        //1 x+kd = y where k can be + or -, and |k| is answer ||
        //2 1+kd = y where k is + ||
        //3 n-kd = y "
    // 1
    if ((y - x)%d == 0)
      math.abs((y - x) / d)
    //2
    else {
      val via1 = if ((y - 1) % d == 0)
      // presses to get back to start
        Some(intCeil(x - 1, d) +
          // presses to get up to place
          intCeil(y - 1, d)) else None
      val viaN = if ((n - y) % d == 0)
        Some(intCeil(n - x, d) +
          intCeil(n - y, d)) else None
      Seq(via1, viaN).flatten match {
        case Seq() => -1
        case Seq(a) => a
        case Seq(a,b) => a min b
      }
    }


  }

  // unintuitive but robust way of getting ceil(a/b) for ints
  def intCeil(a: Int, b: Int) = (a + b - 1) / b

  def main(args: Array[String]) = {
    val io = new IO(System.in)
    val lines = io.int()
    io.nextLine
    1 to lines foreach { _ =>
      println(solve(io.intSeq()))
    }
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
      def double() = sc.nextDouble()
    }
}