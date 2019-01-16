package codeforces.archive

import codeforces.archive.CF518_2_B.{IO, solve}
import org.scalatest.{FunSuite, Matchers}

class CF518_2_B_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""1""".stripMargin)

    solve(io.long()) shouldEqual 1
  }
  test("2") {
    val io = new IO("""2""".stripMargin)

    solve(io.long()) shouldEqual 2
  }

  test("8") {
    val io = new IO("""7169516929
                      |""".stripMargin)

    solve(io.long()) shouldEqual 3
  }

}
