package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_490_3_B._

class CF_490_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """10
      |rocesfedoc
      |""".solveVal shouldEqual "codeforces"
  }
  test("2") {
    """16
      |plmaetwoxesisiht
      |""".solveVal shouldEqual "thisisexampletwo"
  }
  test("3") {
    """1
      |z
      |""".solveVal shouldEqual "z"
  }
}
