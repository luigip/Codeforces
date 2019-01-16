package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.EDU_58_B._

class EDU_58_B_Test extends FunSuite with Matchers {

  test("1") {
    """|[a:b:|]
       |""".solveVal shouldEqual 4
  }
  test("2") {
    """||]:[|:]
       |""".solveVal shouldEqual -1
  }
}
