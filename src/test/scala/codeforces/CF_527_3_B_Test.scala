package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_527_3_B._

class CF_527_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """6
      |5 10 2 3 14 5
      |""".solveVal shouldEqual 5
  }

  test("2") {
    """2
      |1 100
      |""".solveVal shouldEqual 99
  }

}
