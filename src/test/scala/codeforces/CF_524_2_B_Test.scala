package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_524_2_B.{solve, IO}

class CF_524_2_B_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""5
                      |1 3
                      |2 5
                      |5 5
                      |4 4
                      |2 3
                      |""".stripMargin)

    val lines = io.int()
    io.sc.nextLine()
    def s2r(xs: Seq[Int]) = xs(0) to xs (1)
    val input = Vector.fill(lines)(io.intSeq()).map(s2r)
    val exp = """-2
                |-2
                |-5
                |4
                |-1""".stripMargin
    solve(input) shouldEqual exp
  }

}
