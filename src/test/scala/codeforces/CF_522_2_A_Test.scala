package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_522_2_A._

class CF_522_2_A_Test extends FunSuite with Matchers {

  test("1") {
    val i = """5 2
              |1 2 2 1 3
              |"""

    solution(i) shouldEqual 1
  }

  test("2") {
    val i = """10 3
              |1 3 3 1 3 5 5 5 5 100
              |"""

    solution(i) shouldEqual 14
  }
}
