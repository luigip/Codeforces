package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_490_3_C._

class CF_490_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """15 3
      |cccaabababaccbc
      |""".solveVal shouldEqual "cccbbabaccbc"
  }
  test("2") {
    """15 9
      |cccaabababaccbc
      |""".solveVal shouldEqual "cccccc"
  }
  test("3") {
    """1 1
      |u
      |""".solveVal shouldEqual ""
  }
}
