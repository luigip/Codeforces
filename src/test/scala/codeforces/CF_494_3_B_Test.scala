package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_494_3_B._

class CF_494_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """2 2 1""".solveVal shouldEqual "1100"
  }

  test("2") {
    """3 3 3""".solveVal shouldEqual "101100"
  }

  test("3") {
    """5 3 6""".solveVal shouldEqual "01010100"
  }

}
