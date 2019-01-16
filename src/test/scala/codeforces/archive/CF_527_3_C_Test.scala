package codeforces.archive

import codeforces.archive.CF_527_3_C._
import org.scalatest.{FunSuite, Matchers}

class CF_527_3_C_Test extends FunSuite with Matchers {

  test("1") {
    """5
      |ba
      |a
      |abab
      |a
      |aba
      |baba
      |ab
      |aba
      |""".solveVal shouldEqual "SPPSPSPS"
  }
  test("2") {
    """3
      |a
      |aa
      |aa
      |a
      |""".solveVal shouldEqual "PPSS"
  }
  test("3") {
    """2
      |a
      |c
      |""".solveVal shouldEqual "PS"
  }
}
