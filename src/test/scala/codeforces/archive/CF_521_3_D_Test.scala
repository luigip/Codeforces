package codeforces.archive

import codeforces.archive.CF_521_3_D._
import org.scalatest.{FunSuite, Matchers}

class CF_521_3_D_Test extends FunSuite with Matchers {

  test("1") {
    val i = """7 3
              |1 2 3 2 4 3 1
              |"""

    i.solveVals should contain theSameElementsAs """1 2 3""".split(" ").map(_.toInt)
  }
  test("2") {
    val i = """10 4
              |1 3 1 3 10 3 7 7 12 3
              |"""

    i.solveVals should contain theSameElementsAs """7 3 1 3
                                                   |""".intSeq
  }
  test("3") {
    val i = """15 2
              |1 2 1 1 1 2 1 1 2 1 2 1 1 1 1
              |"""

    i.solveVals should contain theSameElementsAs """1 1""".intSeq
  }
  test("39") {
    val i = """2 2
              |1 1
              |"""

    i.solveVals should contain theSameElementsAs """1 1""".intSeq
  }


}
