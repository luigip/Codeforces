package codeforces.archive

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.archive.CF_529_3_C._

class CF_529_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """9 4
      |""".solveVal shouldEqual """YES
                                      |1 2 2 4""".stripMargin
  }

  test("2") {
    """8 1""".solveVal shouldEqual """YES
                                     |8""".stripMargin
  }
  test("3") {
    """5 1""".solveVal shouldEqual """NO""".stripMargin
  }
  test("4") {
    """3 7""".solveVal shouldEqual """NO""".stripMargin
  }

}
