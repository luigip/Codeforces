package codeforces.archive

import codeforces.archive.CF_527_3_B._
import org.scalatest.{FunSuite, Matchers}

class CF_527_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """6
      |5 10 2 3 14 5
      |""".solveVal shouldEqual 5
  }

  test("2") {
    """2
      |1 100
      |""".solveVal shouldEqual 99
  }

}
