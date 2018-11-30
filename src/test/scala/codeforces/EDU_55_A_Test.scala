package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import EDU_55_A.{solve, IO}

class EDU_55_A_Test extends FunSuite with Matchers {

  val io = new IO("""3
                    |10 4 5 2
                    |5 1 3 4
                    |20 4 19 3
                    |""".stripMargin)

  io.nextLine

  test("1") {

    solve(io.intSeq) shouldEqual 4
  }

  test("2") {

    solve(io.intSeq) shouldEqual -1
  }

  test("3") {

    solve(io.intSeq) shouldEqual 5
  }

}
