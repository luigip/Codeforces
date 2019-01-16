package codeforces.archive

import codeforces.archive.CF_522_2_B._
import org.scalatest.{FunSuite, Matchers}

class CF_522_2_B_Test extends FunSuite with Matchers {

  test("1") {
    solution("""tourist""") shouldEqual Output(1,7,Seq("tourist"))
  }

  test("2") {
    solution("""MyNameIsLifeIAmForeverByYourSideMyNameIsLife""") shouldEqual
      Output(3,15,Seq("MyNameIsLifeIAm","ForeverByYourSi","deMyNameIsLife*"))
  }

  test("9") {
    solution("""pwlXLWNuOVAqMrohDutmGUELcJdSWwfCyODAPBwYiPxwYERkFICVrmLBlmCMYUvKemjnySGKZeSXMfZxbuGwfClENcnYyFecN""") shouldEqual
      Output(5,20,
        Seq("pwlXLWNuOVAqMrohDutm",
            "GUELcJdSWwfCyODAPBwY",
            "iPxwYERkFICVrmLBlmC*",
            "MYUvKemjnySGKZeSXMf*",
            "ZxbuGwfClENcnYyFecN*"
      ))
  }


}
