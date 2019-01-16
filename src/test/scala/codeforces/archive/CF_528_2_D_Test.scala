package codeforces.archive

import codeforces.archive.CF_528_2_D._
import org.scalatest.{FunSuite, Matchers}

class CF_528_2_D_Test extends FunSuite with Matchers {

  test("1") {
    """4 3
      |1 2
      |1 3
      |1 4
      |""".solveVal shouldEqual 2.0 +- 1e-6
  }

  test("2") {
    """6 1
      |2 1
      |2 3
      |2 5
      |5 4
      |5 6
      |""".solveVal shouldEqual 0.5 +- 1e-6
  }

  test("3") {
    """5 5
      |1 2
      |2 3
      |3 4
      |3 5
      |""".solveVal shouldEqual 3.333333333333333333 +- 1e-6
  }
}
