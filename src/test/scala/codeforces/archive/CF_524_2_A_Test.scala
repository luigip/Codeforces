package codeforces.archive

import codeforces.archive.CF_524_2_A.{IO, solve}
import org.scalatest.{FunSuite, Matchers}



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
