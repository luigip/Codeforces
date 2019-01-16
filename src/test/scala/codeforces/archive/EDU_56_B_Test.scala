package codeforces.archive

import codeforces.archive.EDU_56_B._
import org.scalatest.{FunSuite, Matchers}

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
