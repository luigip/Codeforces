package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_540_3_B._

class CF_540_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """7
      |5 5 4 5 5 5 6
      |""".solveVal shouldEqual 2
  }
  test("2") {
    """8
      |4 8 8 7 8 4 4 5
      |""".solveVal shouldEqual 2
  }
  test("3") {
    """9
      |2 3 4 2 2 3 2 2 4
      |""".solveVal shouldEqual 3
  }
}
