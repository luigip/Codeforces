package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_494_3_C._

class CF_494_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """4 3
      |3 4 1 2
      |""".solveVal shouldEqual 2.666666666666667 +- 1e-6
  }

}
