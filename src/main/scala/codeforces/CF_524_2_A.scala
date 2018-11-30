package codeforces

object CF_524_2_A extends App {
  def solve(n: Int, k: Int): Int = {
    def books(sheets: Double) = math.ceil(n * sheets / k).toInt
    books(2) + books (5) + books(8)
  }

  val io = new IO(System.in)

  val solution = solve(io.int, io.int)
  println(solution)














//// boilerplate utility methods:
  import java.util.Scanner

  class IO(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))

    def this(s: String) = this(new Scanner(s))

    def collect[T](f: String => T) = {
      sc.nextLine(); sc.nextLine().split(" ").toVector.map(f)
    }

    def intSeq() = collect(_.toInt)

    def doubleSeq() = collect(_.toDouble)

    def int() = sc.nextInt()

    def double() = sc.nextDouble()
  }
}