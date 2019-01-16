package codeforces.archive

import java.util.Scanner

object CF_523_2_A extends App {
  def solve(n: Int, S: Int, count: Int = 0): Int =
    if(S==0) count else solve (n-1, S%n, count + S/n)

  val sc = new Scanner(System.in)
//  val sc = new Scanner("5 11")

  val n, S = sc.nextInt
  println(solve(n,S))
}
