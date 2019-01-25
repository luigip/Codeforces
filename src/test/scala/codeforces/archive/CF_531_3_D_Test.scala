package codeforces.archive

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.archive.CF_531_3_D._

class CF_531_3_D_Test extends FunSuite with Matchers {

  test("1") {
    """3
      |121
      |""".solveVal shouldEqual "021"
  }

  test("2") {
    """6
      |000000
      |""".solveVal shouldEqual "001122"
  }
  test("3") {
    """6
      |211200
      |""".solveVal shouldEqual "211200"
  }
  test("4") {
    """6
      |120110
      |""".solveVal shouldEqual "120120"
  }

}
