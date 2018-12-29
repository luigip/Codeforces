package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_527_3_A._

class CF_527_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """3
      |7 3
      |4 4
      |6 2
      |""".solveStr shouldEqual """cbcacab
                                      |abcd
                                      |baabab
                                      |""".stripMargin
  }

}
