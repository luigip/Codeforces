package ${PACKAGE_NAME}

object ${NAME} {
  def solve() = {
  
  ???
  }
  
  def main(args: Array[String]) = {
    val io = new IO(System.in)
    val solution = solve(???)
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
      def double() = sc.nextDouble()
    }
}