package codeforces.archive

object CF_529_3_C {

  type In = (Int, Int)
  type Out = String

  // Original submitted version
  def solve(in: In): Out = {
    val (n0, k0) = in

    def loop(i: Int, n: Int, k: Int): Option[Map[Int, Int]] =
      if (k > n || k < 1) None
      else if (n/2 >= k)
        // join as many as possible
        loop(i * 2, n/2, k - n%2).map(_ + (i -> n%2))
      else {
        // only join as many as required. c = number to join
       val c = n - k
        Some(Map(i * 2 -> c, i -> (n - c*2)))
      }

    loop(1, n0, k0) match {
      case None => "NO"
      case Some(m) =>
        val seq = for {
          (k, v) <- m.toSeq.sorted
           e     <- Seq.fill(v)(k)
        } yield e
        "YES\n" + seq.mkString(" ")
    }
  }

  // ~~~~~~~~~~ Experimental versions below!! ~~~~~~~~~~~~~~~~~~
  object GolfedVersion extends App {
    val sc = new java.util.Scanner(System.in)
    val n0, k0 = sc.nextInt

    def loop(i: Int, n: Int, k: Int): Option[Map[Int, Int]] =
      if (k > n || k < 1) None
      else if (n/2 >= k)  loop(i*2, n/2, k - n%2).map(_ + (i -> n%2))
      else                Some(Map(i*2 -> (n-k), i -> (n - (n-k)*2)))

    print(loop(1, n0, k0).fold("NO")(m =>
      "YES\n" + (for {
        (k, v) <- m.toSeq.sorted
        e     <- Seq.fill(v)(k)
      } yield e).mkString(" ")
    ))
  }

  def solve1(in: In): Out = {
    val (n0, k0) = in

    def loop(i: Int, bs: Vector[Int], e: Int): Option[Vector[Int]] =
      if(i == 0)
        if(e == 0)                    Some(bs)
        else                          None
      else if (e < 1 || bs(i) == 0)   loop(i-1, bs, e)
      else                            loop(i, bs.updated(i-1, bs(i-1) + 2).updated(i, bs(i)-1), e - 1)


//      (i, e, bs(i)) match {
//      case (0, 0, _)          => Some(bs)
//      case (0, _, _)          => None
//      case (_, _, _) if e < 1 => loop(i-1, bs, e)
//      case (_, _, 0)          => loop(i-1, bs, e)
//      case (_, _, b)          => loop(i, bs.updated(i-1, bs(i-1) + 2).updated(i, b-1), e - 1)
//    }

    val bs = BigInt(n0).toString(2).toVector.map(_.asDigit).reverse
    val extraTermsRequired = k0 - bs.sum

    loop(bs.indices.last, bs, extraTermsRequired) match {
      case None => "NO"
      case Some (xs) =>
        val seq = for {
            (x, i) <- xs.zipWithIndex
            if x > 0
            e <- Seq.fill(x)(math.pow(2, i).toInt)
          } yield e
        "YES\n" + seq.mkString (" ")
    }
  }

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Specify Input and Output formats on RHS here:

  def formatIn(i: Input): In       = (i.int, i.int)
  def formatOut(out: Out): String  = out.toString

//   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//   Boilerplate & utility methods that don't change:

  import java.util.Scanner
  import java.io.InputStream
  import language.implicitConversions

  def main(args: Array[String]): Unit = {
    val out = new java.io.PrintWriter(System.out)
    val resultStr = new Input(System.in).solveStr
    out.println(resultStr)
    out.close()
  }

  class Input(sc: Scanner) {
    // This class is useful for convenience, and for mock stdin in test scripts
    // Remember to call nextLine to advance past the newline character (if required) before taking a whole line
    def this(i: InputStream) =       this(new Scanner(i))
    def this(s: String) =            this(new Scanner(s.stripMargin))
    def int =                        sc.nextInt()
    def long =                       sc.nextLong()
    def double =                     sc.nextDouble()
    def nextLine =                   sc.nextLine()
    def collect[T](f: String => T) = sc.nextLine().split(" ").toVector.map(f)
    def intSeq =                     collect(_.toInt)
    def doubleSeq =                  collect(_.toDouble)
    def getLines: Vector[String] =   if (!sc.hasNextLine) Vector.empty
                                     else sc.nextLine +: getLines
    def solveVal: Out =              (solve _).tupled(formatIn(this))
    def solveStr: String =           formatOut(solveVal)
  }

  // Ceiling division for Int & Long
  def ceil(a: Int, b: Int)   = (a - 1)/b + 1
  def ceil(a: Long, b: Long) = (a - 1)/b + 1

  // A frequently used number
  val modulo = 1000000007

  // For convenience in test scripts, treat a String as an Input
  implicit def stringToInput(s: String): Input = new Input(s)
  // Required to make `solveVal` work when input has just 1 value (i.e. not a Tuple)
  implicit class makeTupledWorkOnFunction1[-T,+R](f: T => R) {
    def tupled: T => R = x => f(x)
  }
}
