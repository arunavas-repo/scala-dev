package test.arunava.scala.week5.list

object ForAllExists {
  def main(args: Array[String]): Unit = {
    println(isPrimeForAll(9))
    println(isPrimeExists(9))
    println(isPrimeForAll(7))
    println(isPrimeExists(7))
    
    val list = List.range(-5, 6)
    println(list)
    println(list filter (_ >= 0))
    
    println(forAllFilter(list)(_ >= 0))
    println(existsFilter(list)(_ <= 0))
    println(forAllFilter(list)(_ >= -10))
    println(existsFilter(list)(_ <= -10))
  }
  
  def isPrimeForAll(num: Int): Boolean = List.range(2, num) forall(num % _ != 0)
  def isPrimeExists(num: Int): Boolean = !(List.range(2, num) exists(num % _ == 0))
  
  def forAllFilter[T](list: List[T])(op: T => Boolean): Boolean = (list filter op).length == list.length
  def existsFilter[T](list: List[T])(op: T => Boolean): Boolean = (list filter op).length > 0
  
}