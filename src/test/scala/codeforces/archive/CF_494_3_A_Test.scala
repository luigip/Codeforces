package codeforces.archive

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.archive.CF_494_3_A._

class CF_494_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """6
      |1 2 4 3 3 2
      |""".solveVal shouldEqual 2
  }

  test("2") {
    """1
      |100
      |""".solveVal shouldEqual 1
  }
}
