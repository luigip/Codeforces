package codeforces.archive

import codeforces.archive.CF_526_2_A._
import org.scalatest.{FunSuite, Matchers}

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
