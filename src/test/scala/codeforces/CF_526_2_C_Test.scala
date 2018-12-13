package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_526_2_C._

class CF_526_2_C_Test extends FunSuite with Matchers {

  test("1") {
    "abbaa".solveVals shouldEqual 5
  }

  test("2") {
    "baaaa".solveVals shouldEqual 4
  }

  test("3") {
    "agaa".solveVals shouldEqual 3
  }

  test("4") {
    "aaaaabb".solveVals shouldEqual 5
  }

  test("5") {
    "aabaaaa".solveVals shouldEqual 14
  }
}
