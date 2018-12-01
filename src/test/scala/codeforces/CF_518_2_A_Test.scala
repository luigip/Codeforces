package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_518_2_A.{solve, IO}

class CF_518_2_A_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""20 15 2 3
                      |""".stripMargin)

    solve(io.long, io.long, io.long, io.long) shouldEqual 1
  }

  test("2") {
    val io = new IO("""10 11 2 4
                      |""".stripMargin)

    solve(io.long, io.long, io.long, io.long) shouldEqual -1
  }


}
