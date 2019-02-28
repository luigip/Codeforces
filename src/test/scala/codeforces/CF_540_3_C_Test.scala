package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_540_3_C._

class CF_540_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """4
      |1 8 8 1 2 2 2 2 2 2 2 2 1 8 8 1
      |""".solveStr shouldEqual "YES\n1 2 2 1\n8 2 2 8\n8 2 2 8\n1 2 2 1"
  }

  test("2") {
    """3
      |1 1 1 1 1 3 3 3 3
      |""".solveStr shouldEqual "YES\n1 3 1\n3 1 3\n1 3 1"
  }
  test("3") {
    """4
      |1 2 1 9 8 4 3 8 8 3 4 8 9 2 1 1
      |""".solveStr shouldEqual "NO"
  }
  test("4") {
    """1
      |10
      |""".solveStr shouldEqual "YES\n10"
  }
}
