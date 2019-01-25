package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import codeforces.CF_535_3_B._

class CF_535_3_B_Test extends FunSuite with Matchers {

  test("1") {
    """10
      |10 2 8 1 2 4 1 20 4 5
      |""".solveVal shouldEqual "20 8"
  }

}
