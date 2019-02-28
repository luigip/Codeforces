package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_540_3_A._

class CF_540_3_A_Test extends FunSuite with Matchers {

  test("1") {
    """4
      |10 1 3
      |7 3 2
      |1 1000 1
      |1000000000000 42 88""".solveVal shouldEqual """10
                                      |9
                                      |1000
                                      |42000000000000""".stripMargin
  }

}
