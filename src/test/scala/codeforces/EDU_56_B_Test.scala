package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import EDU_56_B._

class EDU_56_B_Test extends FunSuite with Matchers {

  test("1") {
    """3
      |aa
      |abacaba
      |ddx
      |""".solveStr shouldEqual """-1
                                      |aaaabbc
                                      |ddx""".stripMargin
  }

}
