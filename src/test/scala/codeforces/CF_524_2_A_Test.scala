package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_524_2_A.{IO, solve}



class CF_524_2_A_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""3 5""".stripMargin)

    solve(io.int, io.int) shouldEqual 10
  }
  test("2") {
    val io = new IO("""15 6""".stripMargin)

    solve(io.int, io.int) shouldEqual 38
  }
}
