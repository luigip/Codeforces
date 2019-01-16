package codeforces.archive

import codeforces.archive.CF_524_2_B.{IO, solve}
import org.scalatest.{FunSuite, Matchers}

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
