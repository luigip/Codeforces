// date: 02/12/2018
// tested working online: YES
// note similarities to Project Euler 357.
package codeforces

import java.util
import scala.collection.JavaConverters._


object CF518_2_B {
  def solve(b: Long): Long = {
    val pfs = Utility.primeFactors(b)
//    println("b = "+b)
//    println(pfs.asScala.toList)
    val ns = pfs.asScala.groupBy(identity).mapValues(_.size).values
    ns.map(_+1).product
  }
  
  def main(args: Array[String]) = {
    val io = new IO(System.in)
//    val io = new IO("7169516929")
    val solution = solve(io.long())
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
      def long() = sc.nextLong()
      def double() = sc.nextDouble()
    }

    object Utility {
      def intCeil(a: Int, b: Int) = (a - 1) / b + 1
      def longCeil(a: Long, b: Long) = (a - 1) / b + 1
      // Euclid's algorithm
      def gcd(a: Long, b: Long): Long = b match {
        case 0 => a
        case _ => gcd(b, a % b)
      }
      // lcm(a,b) = abs(a*b)/gcd(a,b)
      def lcm(a: Long, b: Long) = math.abs(a)/gcd(a,b)*math.abs(b)

      // These were written in Java then auto-converted by IntelliJ to Scala... so ugly!
      def primesFromSieve(upto: Int): util.BitSet = { // true means it's a prime
        val bs: util.BitSet = new util.BitSet(upto + 1)
        // even numbers aren't prime, so we initialize intelligently. Takes ~ 15% of total method run time for 1e8
        // (future optimization if required: try initializing as longs with value 0x01010101010101...)
        bs.set(2)
        locally {var i: Int = 3
        while ( {
          i <= upto
        }) {
          bs.set(i)
          i += 2
        }}
        // end of initialization.
        val max: Int = Math.sqrt(upto).toInt
        // nextSetBit returns -1 if none exists so we have to check that i is still > 0
        locally { var i: Int = 3
        while ( {
          i <= max && i > 0
        }) {
          var j: Int = i * 2
          while ( {
            j < upto
          }) {
            bs.clear(j)

            j += i
          }

          i = bs.nextSetBit(i + 2)
        }}
        bs
      }

      def primeFactors(x: Long): util.ArrayList[Long] = {
        val factors = new util.ArrayList[Long]
        if (x < 2) return factors
        val maxPrimeFactor = Math.sqrt(x).toInt
        val allPrimes = primesFromSieve(maxPrimeFactor)
        var remaining = x
        var trial = 2L
        while ( {
          trial * trial <= remaining && trial > -1
        }) if (remaining % trial == 0) { // trial is prime factor of x
          factors.add(trial)
          remaining = remaining / trial
        }
        else trial = allPrimes.nextSetBit(trial.toInt + 1)
        factors.add(remaining)
        factors
      }

    }
}