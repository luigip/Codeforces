// date: ${DATE}
// tested working online: YES / NO

package ${PACKAGE_NAME}

object ${NAME} {
  def solve(???): Int = {

  ???
  }

  // Specify Input and Output formats here:
  def formatIn(i: Input) = (i.int, {i.nextLine; i.collect(_.toLong)})
  def formatOut(out: (Int, Seq[Int])) = out._1 + "\n" + out._2.mkString(" ")

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