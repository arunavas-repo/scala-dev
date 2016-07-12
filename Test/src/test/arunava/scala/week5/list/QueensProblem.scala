package test.arunava.scala.week5.list

import scala.annotation.tailrec

object QueensProblem {
  
  val empty = ". "
  val queen = "Y "
  
  def main(args: Array[String]): Unit = {
    solveWithMap(4)
    //solveWithFor(12)
  }
  
  def solveWithMap(n: Int) = {
    val startTime = System.currentTimeMillis()
    val solution = solveNQueenProblem(n)
    val endTime = System.currentTimeMillis()
    println("Time Taken: " + ((endTime - startTime) / 1000) + " seconds, " + ((endTime - startTime) % 1000))
    //representVisually(solution)
    println("With Map: " + solution)
    solution map (printSolution(_))
  }
  
  def solveWithFor(n: Int) = {
    val startTime = System.currentTimeMillis()
    val solution = solveQueenProblem(n)
    val endTime = System.currentTimeMillis()
    println("Time Taken: " + ((endTime - startTime) / 1000) + " seconds, " + ((endTime - startTime) % 1000))
    //representVisually(solution)
    println("With For: " + solution.size)
    solution take 1 map (printSolution(_))
  }

  def representVisually(solution: Set[List[Int]]) = {
    solution.foreach {
      list =>
        list.foreach {
          i => println(Vector.fill(list.length)(empty).updated(i, queen).mkString)
        }
        println()
    }
  }
  
  def printSolution(solution: List[Int]) = {
    val line = for {
      c <- solution
    } yield Vector.fill(solution.length)(empty).updated(c, queen).mkString
    println(line mkString("\n"))
    println()
  }

  def solveQueenProblem(n: Int): Set[List[Int]] = {
    def placeQueens(k: Int): Set[List[Int]] = {
      if (k == 0) Set(List())
      else for (q <- placeQueens(k - 1); c <- List.range(0, n) if (!q.contains(c) && isSafe(c, q))) yield c :: q
    }
    placeQueens(n)
  }
  
  def solveNQueenProblem(n: Int): Set[List[Int]] = {
    def placeQueens(q: Int): Set[List[Int]] = {
      if (q == 0) Set(List())
      else placeQueens(q - 1).flatMap (e => List.range(0, n).filter (c => !e.contains(c) && isSafe(c, e) ) map (_ :: e))
    }
    placeQueens(n)
  }
  
  def isSafe(col: Int, queens: List[Int]): Boolean = {
    val row = queens.length
    val queensWithAxis = row - 1 to 0 by -1 zip queens
    queensWithAxis forall {
      case (r, c) => Math.abs(col - c) != row - r
    }
  }
}