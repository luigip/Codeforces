package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_526_2_B._

class CF_526_2_B_Test extends FunSuite with Matchers {

  test("1") {
    val i = """3 3
              |4 3 5
              |"""

    i.solveVals shouldEqual 3
  }

  test("2") {
    val i = """3 4
              |5 3 4
              |"""

    i.solveVals shouldEqual 2
  }
  test("3") {
    val i = """3 7
              |1 2 3
              |"""

    i.solveVals shouldEqual -1
  }
}
