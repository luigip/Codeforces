package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_528_2_B._

class CF_528_2_B_Test extends FunSuite with Matchers {

  test("1") {
    """6 3""".solveVal shouldEqual 11
  }

  test("2") {
    """1 2""".solveVal shouldEqual 3
  }
  test("3") {
    """4 6""".solveVal shouldEqual 10
  }
  test("5") {
    """999983 1000""".solveVal shouldEqual 999983001
  }

}
