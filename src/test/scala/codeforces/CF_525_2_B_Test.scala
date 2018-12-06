package codeforces

import org.scalatest.FunSuite
import org.scalatest.Matchers
import CF_525_2_B.{solve, IO}

class CF_525_2_B_Test extends FunSuite with Matchers {

  test("1") {
    val io = new IO("""3 5
                      |1 2 3
                      |""".stripMargin); import io._
    val solution = solve(int, int, {nextLine; intSeq()}.toArray)

    solution shouldEqual """1
                           |1
                           |1
                           |0
                           |0
                           |""".stripMargin.split("\n").map(_.toInt).toVector
  }
  test("2") {
    val io = new IO("""4 2
                      |10 3 5 3
                      |""".stripMargin); import io._
    val solution = solve(int, int, {nextLine; intSeq()}.toArray)

    solution shouldEqual """3
                           |2
                           |""".stripMargin.split("\n").map(_.toInt).toVector
  }
  test("3") {
    val io = new IO("""7 5
                      |5 8 10 3 6 10 8
                      |""".stripMargin); import io._
    val solution = solve(int, int, {nextLine; intSeq()}.toArray)

    solution shouldEqual
      """3
        |2
        |1
        |2
        |2
        |""".stripMargin.split("\n").map(_.toInt).toVector
  }



}
