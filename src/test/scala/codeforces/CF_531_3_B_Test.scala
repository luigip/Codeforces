package codeforces

import codeforces.CF_531_3_B._
import org.scalatest.{FunSuite, Matchers}

class CF_531_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """4 2
      |1 2 2 3
      |""".solveStr shouldEqual """YES
                                      |1 1 2 2
                                      |""".stripMargin
  }

  test("2") {
    """5 2
      |3 2 1 2 3
      |""".solveStr shouldEqual """YES
                                  |2 1 1 2 1
                                  |""".stripMargin
  }

  test("3") {
    """5 2
      |2 1 1 2 1
      |""".solveStr shouldEqual """NO
                                  |""".stripMargin
  }

}
