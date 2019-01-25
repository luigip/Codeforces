package codeforces.archive

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.archive.CF_531_3_C._

class CF_531_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """6 3 2
      |2 3 1 3 4 2
      |""".solveVal shouldEqual 6
  }

  test("2") {
    """5 3 3
      |1 2 4 2 3
      |""".solveVal shouldEqual 2
  }

  test("3") {
    """5 5 6
      |1 2 6 10 3
      |""".solveVal shouldEqual 2
  }

}
