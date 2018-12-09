package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_521_3_A._

class CF_521_3_A_Test extends FunSuite with Matchers {

  test("1") {
    val i = """6
              |5 2 3
              |100 1 4
              |1 10 5
              |1000000000 1 6
              |1 1 1000000000
              |1 1 999999999
              |""".stripMargin

    solution(i) shouldEqual """8
                              |198
                              |-17
                              |2999999997
                              |0
                              |1""".stripMargin
  }

}
