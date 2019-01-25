package codeforces.archive

import codeforces.archive.CF_490_3_A._
import org.scalatest.{FunSuite, Matchers}

class CF_490_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """8 4
      |4 2 3 1 5 1 6 4
      |""".solveVal shouldEqual 5
  }

  test("2") {
    """5 2
      |3 1 2 1 3
      |""".solveVal shouldEqual 0
  }

  test("3") {
    """5 100
      |12 34 55 43 21
      |""".solveVal shouldEqual 5
  }
}
