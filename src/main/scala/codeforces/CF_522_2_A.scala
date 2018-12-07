// date: 07/12/2018
// tested working online: YES

package codeforces

object CF_522_2_A {
  def solve(n: Int, k: Int, as: Seq[Int]): Int = {
    val counts = as.groupBy(identity).mapValues(_.size)
    val maxCount = counts.values.max
    val numSetsEach = ceil(maxCount, k)
    val numUtensilsInSet = counts.size
    val totalUtensils = k * numSetsEach * numUtensilsInSet
    val numStolen = totalUtensils - n
    numStolen
  }

  def solution(i: Input) = solve(i.int, i.int, {i.nextLine; i.intSeq()})


//     ~~~ Boilerplate ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val sol = solution(new Input(System.in))
    out.println(sol)
    out.close()
  }

//     ~~~ Utility methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  import java.util.Scanner
  class Input(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s.stripMargin))
    def nextLine = sc.nextLine() // do this if still on previous line before collecting line of data
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
    def intSeq() = collect(_.toInt)
    def doubleSeq() = collect(_.toDouble)
    def int() = sc.nextInt()
    def long() = sc.nextLong()
    def double() = sc.nextDouble()
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
}