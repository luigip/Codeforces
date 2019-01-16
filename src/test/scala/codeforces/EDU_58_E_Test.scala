package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.EDU_58_E._

class EDU_58_E_Test extends FunSuite with Matchers {

  test("1") {
    """9
      |+ 3 2
      |+ 2 3
      |? 1 20
      |? 3 3
      |? 2 3
      |+ 1 5
      |? 10 10
      |? 1 5
      |+ 1 1
      |""".solveStr shouldEqual """NO
                                      |YES
                                      |YES
                                      |YES
                                      |NO""".stripMargin
  }

}
