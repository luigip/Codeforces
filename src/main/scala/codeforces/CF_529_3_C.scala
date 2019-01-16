package codeforces

// date: 09/01/2019
// tested working online: YES / NO

object CF_529_3_C {

  type In = (Int, Int)
  type Out = String

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

/*
  implicit class pimpMap(m: Map[Int, Int]) {
    def add(k: Int, v: Int) = {
      val v0 = m(k)
      if (v0 + v == 0)
        m - k
      else m + (k -> (v0 + v))
    }
  }

  // `terms` is SortedMap ordered high -> low
  def solve(terms0: Map[Int, Int], k: Int): Option[Map[Int, Int]] = {
    val terms = terms0.filter(_._2 > 0)
    val n = terms.size
    if (k > n) None
    else if (k == n) Some(terms)
    //1. If n < k/2, split largest term into ones and continue
    else if (n < k/2) {
      val largestTerm = terms.head._1
      val updated = terms.add(largestTerm, -1).add(1, largestTerm)
      solve(updated, k - largestTerm + 1)
    }
    //2. If




      // repeatedly look for the largest power less than size of terms
      def findAndSplit(m: Map[Int, Int], numExtra: Int): Map[Int, Int] = numExtra match {
        case 0 => m
        case _ =>
          val powers = m.filter(_._2 > 0).keys.toList.sorted(Ordering.Int.reverse)
          val toBeSplit = powers.find(i => `2^`(i) <= numExtra && `2^`(i) > 1)
          toBeSplit match {
            // There is a power that can be split into 1s
            case Some(p) =>
              val current = m(p)
              findAndSplit(m + (p -> (current - 1)) + (1 -> (m.getOrElse(1, 0) + current)), numExtra - (current - 1))
            case None =>
              val p = powers.head
              findAndSplit(m + (p -> (m(p) - 1)) + (p -1 -> m.getOrElse(p - 1, 0)), numExtra - 1)

          }
      }

      val ps = for {
        (k, v) <- findAndSplit(terms, numExtrasRequired).toList
        i <- Iterator.fill(v)(`2^`(k))
      } yield i

      "YES\n" + ps.mkString(" ")
    }
  }


  def solve2(in: In): Out = {
    val (n0, k0) = in

    val `2^` = Vector.iterate(1,31)(_*2)

    // get powers of 2 that sum to n
    def decompose(n: Int, i: Int): Map[Int, Int] = i match {
      case -1                 => Map.empty
      case _ if `2^`(i) <= n  => decompose(n - `2^`(i), i - 1) + (i -> 1)
      case _                  => decompose(n, i - 1)
    }

    val terms = decompose(n0, 30)
    val numExtrasRequired = k0 - terms.size
    if(numExtrasRequired < 0 || k0 > n0) "NO"
    else {
      // repeatedly look for the largest power less than size of terms
      def findAndSplit(m: Map[Int, Int], numExtra: Int): Map[Int, Int] = numExtra match {
        case 0 => m
        case _ =>
          val powers = m.filter(_._2 > 0).keys.toList.sorted(Ordering.Int.reverse)
          val toBeSplit = powers.find(i => `2^`(i) <= numExtra && `2^`(i) > 1)
          toBeSplit match {
              // There is a power that can be split into 1s
            case Some(p) =>
              val current = m(p)
              findAndSplit(m + (p -> (current - 1)) + (1 -> (m.getOrElse(1, 0) + current)), numExtra - (current - 1))
            case None =>
              val p = powers.head
              findAndSplit(m + (p -> (m(p) - 1)) + (p -1 -> m.getOrElse(p - 1, 0)), numExtra - 1)

          }
      }

      val ps = for {
        (k, v) <- findAndSplit(terms, numExtrasRequired).toList
        i <- Iterator.fill(v)(`2^`(k))
      } yield i

      "YES\n" + ps.mkString(" ")
    }
  }
*/


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
