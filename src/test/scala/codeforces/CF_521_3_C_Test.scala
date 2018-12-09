package codeforces

import codeforces.CF_521_3_C._
import org.scalatest.{FunSuite, Matchers}

class CF_521_3_C_Test extends FunSuite with Matchers {

  test("1") {
    val i = """5
              |2 5 1 2 2
              |""".stripMargin

    solve(i) shouldEqual (3, Seq(1,4,5))
  }
  test("2") {
    val i = """4
              |8 3 5 2
              |""".stripMargin

    solve(i) shouldEqual (2, Seq(1,4))
  }
  test("3") {
    val i = """5
              |2 1 2 4 3
              |""".stripMargin

    solve(i) shouldEqual (0, Seq())
  }
}
