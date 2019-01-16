package codeforces.archive

import codeforces.archive.CF_528_2_A._
import org.scalatest.{FunSuite, Matchers}

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
