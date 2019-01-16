package codeforces.archive

import codeforces.archive.CF_528_2_C._
import org.scalatest.{FunSuite, Matchers}

class CF_528_2_C_Test extends FunSuite with Matchers {

  test("1") {
    """0 0
      |1 1
      |2 2
      |""".solveStr.nextLine shouldEqual "5"
  }

  test("2") {
    """0 0
      |2 0
      |1 1
      |""".solveStr.nextLine shouldEqual "4"
  }

  test("9") {
    """81 27
      |17 47
      |81 69
      |""".solveStr.nextLine shouldEqual "107"
  }


  test("10") {
    """181 568
      |924 506
      |441 716
      |""".solveStr.nextLine shouldEqual "954"
  }
}
