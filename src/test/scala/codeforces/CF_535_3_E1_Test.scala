package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_535_3_E1._

class CF_535_3_E1_Test extends FunSuite with Matchers {

  test("1") {
    """5 4
      |2 -2 3 1 2
      |1 3
      |4 5
      |2 5
      |1 3
      |""".solveStr shouldEqual """6
                                      |2
                                      |1 4""".stripMargin
  }
  test("2") {
    """5 4
      |2 -2 3 1 4
      |3 5
      |3 4
      |2 4
      |2 5
      |""".solveStr shouldEqual """2
                                  |2
                                  |3 2""".stripMargin
  }

  test("3") {
    """1 0
      |1000000
      |""".solveStr shouldEqual """0
                                  |0
                                  |""".stripMargin
  }
}
