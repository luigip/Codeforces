package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_526_2_A._

class CF_526_2_A_Test extends FunSuite with Matchers {

  test("1") {
    val i = """3
              |0 2 1
              |"""

    i.solveVals shouldEqual 16
  }
  test("2") {
    val i = """2
              |1 1
              |"""

    i.solveVals shouldEqual 4
  }

}
