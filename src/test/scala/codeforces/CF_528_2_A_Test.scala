package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_528_2_A._

class CF_528_2_A_Test extends FunSuite with Matchers {

  test("1") {
    """ncteho
      |""".solveVal shouldEqual "techno"
  }

  test("2") {
    """erfdcoeocs
      |""".solveVal shouldEqual "codeforces"
  }
  test("3") {
    """z
      |""".solveVal shouldEqual "z"
  }
}
