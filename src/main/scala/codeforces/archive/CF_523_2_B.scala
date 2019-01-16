package codeforces.archive

object CF_523_2_B extends App {
  def solve(as: Seq[Int]): Long = loop(as.filter(_>0).sortWith(_>_))

  def loop(as: Seq[Int], removed: Long = 0):Long =  as match {
    // last column, keep them all and return result
    case Seq(last) => removed
    case c1 +: c2 +: _ =>
      // remove all blocks in c1 below height of c2
      if(c1 > c2) loop(as.tail, removed + c2)
      // if c2 same height or more, remove all but 1 of c1 reduce c2 to 1 below c1 if c1 is > 1
      else  {
        val newc2 = math.max(1, c1 - 1)
        val toRemove = math.max(0, c1 - 1) + (c2 - newc2)
        loop(as.tail.updated(0, newc2), removed + toRemove)
      }
  }
  val io = new IO(System.in)
  io.int(); io.int()
  println(solve(io.intSeq()))

  /// utility class for getting args from StdIn
  import java.util.Scanner
  class IO(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s))
    def collect[T](f: String => T) = {sc.nextLine();sc.nextLine().split(" ").toVector.map(f)}
    def intSeq() = collect(_.toInt)
    def doubleSeq() = collect(_.toDouble)
    def int() = sc.nextInt()
    def double() = sc.nextDouble()
  }
}
