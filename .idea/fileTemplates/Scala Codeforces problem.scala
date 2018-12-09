// date: ${DATE}
// tested working online: YES / NO

package ${PACKAGE_NAME}

object ${NAME} {
  def solve(???): Int = {

  ???
  }

// These formatting methods are useful to call from both main and test script
  // Extract input values and pass to the real (!) `solve` 
  def solve(i: Input) = solve(i.int, i.int, {i.nextLine; i.intSeq()})
  // Take output and make it into a String we can output (main) or compare to expected (test)
  def formatted(???): String = s"$ $"

  
//     ~~~ Boilerplate that doesn't change ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  def main(args: Array[String]) = {
    val out = new java.io.PrintWriter(System.out)
    val result = solve(new Input(System.in))
    out.println(formatted(result))
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
  }

  def ceil(a: Int, b: Int) = (a - 1) / b + 1
  def ceil(a: Long, b: Long) = (a - 1) / b + 1

  import language.implicitConversions
  implicit def stringToInput(s: String): Input = new Input(s)
}