package codeforces.archive

import codeforces.archive.C_1089_L._
import org.scalatest.{FunSuite, Matchers}

class C_1089_L_Test extends FunSuite with Matchers {

  test("1") {
    """8 7
      |1 1 3 1 5 3 7 1
      |5 7 4 8 1 3 5 2
      |""".solveVal shouldEqual 10
  }
  test("2") {
    """3 3
      |3 1 2
      |5 3 4
      |""".solveVal shouldEqual 0
  }
}
