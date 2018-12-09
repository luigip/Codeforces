package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_521_3_B._

class CF_521_3_B_Test extends FunSuite with Matchers {

  test("1") {
    solution("""10
               |1 1 0 1 1 0 1 0 1 0
               |""".stripMargin) shouldEqual 2
  }

  test("2") {
    solution("""5
               |1 1 0 0 0
               |""".stripMargin) shouldEqual 0
  }

  test("3") {
    solution("""4
               |1 1 1 1
               |""".stripMargin) shouldEqual 0
  }

}
