package codeforces.archive

import codeforces.archive.CF_525_2_A.{IO, solve}
import org.scalatest.{FunSuite, Matchers}

class CF_525_2_A_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""10""".stripMargin); import io._

    Set(Some(6, 3), Some(4,4)) should contain (solve(int))
  }

  test("2") {
    val io = new IO("""1""".stripMargin); import io._

    solve(int) shouldEqual None
  }

}
