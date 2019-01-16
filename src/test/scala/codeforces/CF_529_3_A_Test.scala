package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_529_3_A._

class CF_529_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """6
      |baabbb
      |""".solveVal shouldEqual "bab"
  }

}
