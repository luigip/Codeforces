package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_531_3_A._

class CF_531_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """3""".solveVal shouldEqual 0
  }
  test("2") {
    """5""".solveVal shouldEqual 1
  }
  test("3") {
    """6""".solveVal shouldEqual 1
  }
}
