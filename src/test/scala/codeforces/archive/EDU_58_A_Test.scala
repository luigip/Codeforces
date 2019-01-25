package codeforces.archive

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.archive.EDU_58_A._

class EDU_58_A_Test extends FunSuite with Matchers {

  test("1") {
    """5
      |2 4 2
      |5 10 4
      |3 10 1
      |1 2 3
      |4 6 5
      |""".solveVal shouldEqual """6
                                      |4
                                      |1
                                      |3
                                      |10""".stripMargin
  }

}
