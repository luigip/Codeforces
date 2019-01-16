package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_529_3_B._

class CF_529_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """4
      |1 3 3 7
      |""".solveVal shouldEqual 2
  }
  test("3") {
    """2
      |1 100000
      |""".solveVal shouldEqual 0
  }

}
