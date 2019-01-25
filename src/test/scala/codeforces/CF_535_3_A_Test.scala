package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_535_3_A._

class CF_535_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """5
      |1 2 1 2
      |2 6 3 4
      |2 4 1 3
      |1 2 1 3
      |1 4 5 8
      |""".solveStr shouldEqual """2 1
                                      |3 4
                                      |3 2
                                      |1 2
                                      |3 7
                                      |""".stripMargin
  }

}
