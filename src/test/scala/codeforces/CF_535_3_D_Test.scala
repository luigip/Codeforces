package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_535_3_D._

class CF_535_3_D_Test extends FunSuite with Matchers {

  test("1") {
    """9
      |RBGRRBRGG
      |""".solveVal shouldEqual "2\nRBGRGBRGR"
  }

  test("2") {
    """8
      |BBBGBRRR
      |""".solveVal shouldEqual "2\nBRBGBRGR"
  }

  test("3") {
    """13
      |BBRRRRGGGGGRR
      |""".solveVal shouldEqual "6\nBGRBRBGBGBGRG"
  }
}
