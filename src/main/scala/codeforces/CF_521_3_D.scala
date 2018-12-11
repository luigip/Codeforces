// date: 09/12/2018
// tested working online: YES

package codeforces

object CF_521_3_D {
  def solve(n: Int, k: Int, ss: Seq[Int]): Seq[Int] = {
    val counts: Map[Int, Int] = ss.groupBy(identity).mapValues(_.size)
    // sort biggest first so we can stop early
    val ordered = counts.toSeq.sortWith(_._2 > _._2).toStream
    // `trial` is the number of copies of t. Start with 1 and increase until it's not possible to build such a Seq
    // It's possible if we can find k or more elements that have enough copies.
    def isPossible(trial: Int, xs: Seq[(Int, Int)], found: Int, out: Seq[Int]): Option[Seq[Int]] =
      if(found >= k) Some(out.take(k))
      else if(xs.isEmpty) None
      else {
        val (e, c) = xs.head
        // instances is the number of instances of xs.head we'll use
        val instances = c/trial
        if (instances < 1) None
        else {
          val add = Seq.fill(instances)(e)
          isPossible(trial, xs.tail, found + instances, out ++ add)
        }
      }
    def find(trial: Int, best: Seq[Int]): Seq[Int] = {
      val poss = isPossible(trial, ordered, 0, Vector.empty)
      poss match {
        case None => best
        case Some(seq) => find(trial + 1, seq)
      }
    }

    find(1,Seq.empty)
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) = (i.int, i.int, {i.nextLine; i.intSeq})
  def formatOut(out: Seq[Int]) = out.mkString(" ")

//     ~~~ Boilerplate that doesn't change ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }

//     ~~~ Utility methods ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  import java.util.Scanner
  class Input(sc: Scanner) {
    def this(i: java.io.InputStream) = this(new Scanner(i))
    def this(s: String) = this(new Scanner(s.stripMargin))
    def int = sc.nextInt()
    def long = sc.nextLong()
    def double = sc.nextDouble()
    def nextLine = sc.nextLine() 
    // If there are prior values, remember to call nextLine to advance past the newline character before collecting the line:
    def collect[T](f: String => T) = {sc.nextLine().split(" ").toVector.map(f)}
    def intSeq() = collect(_.toInt)
    def doubleSeq() = collect(_.toDouble)
    def solveVals = (solve _).tupled(formatIn(this))
    def solveStr = formatOut(solveVals)
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
}
