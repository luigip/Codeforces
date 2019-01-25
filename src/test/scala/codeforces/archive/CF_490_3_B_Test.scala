package codeforces.archive

import codeforces.archive.CF_490_3_B._
import org.scalatest.{FunSuite, Matchers}

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
