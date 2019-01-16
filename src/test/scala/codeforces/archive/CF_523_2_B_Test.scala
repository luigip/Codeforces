package codeforces.archive

import codeforces.archive.CF_523_2_B.{IO, solve}
import org.scalatest.{FunSuite, Matchers}

class CF_523_2_B_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""5 6
                      |3 3 3 3 3
                      |""".stripMargin)
    io.int(); io.int()
    solve(io.intSeq()) shouldEqual 10
  }

  test("2") {
    val io = new IO("""3 5
                      |1 2 4
                      |""".stripMargin)
    io.int(); io.int()
    solve(io.intSeq()) shouldEqual 3
  }
  test("3") {
    val io = new IO("""5 5
                      |2 3 1 4 4
                      |""".stripMargin)
    io.int(); io.int()
    solve(io.intSeq()) shouldEqual 9
  }
  test("4") {
    val io = new IO("""1 1000
                      |548
                      |""".stripMargin)
    io.int(); io.int()
    solve(io.intSeq()) shouldEqual 0
  }
  test("5") {
    val io = new IO("""3 3
                      |3 1 1
                      |""".stripMargin)
    io.int(); io.int()
    solve(io.intSeq()) shouldEqual 1
  }


}
