package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_535_3_C._

class CF_535_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """3
      |BRB
      |""".solveVal shouldEqual "1\nGRB"
  }

  test("2") {
    """7
      |RGBGRBB
      |""".solveVal shouldEqual "3\nRGBRGBR"
  }

}
