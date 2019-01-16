package codeforces.archive

import codeforces.archive.CF_527_3_A._
import org.scalatest.{FunSuite, Matchers}

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
