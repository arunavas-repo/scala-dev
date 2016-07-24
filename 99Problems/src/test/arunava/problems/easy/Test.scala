package test.arunava.problems.easy

/**
  * Created by arunavas on 24/7/16.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val list = 0 to 10 toList
    val duplicateList = List(0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 0, 0, 0)
    val fte = new FirstTenEasy
    println("List: %s".format(list))
    println("duplicateList: %s".format(duplicateList))
    println("1st Problem: Last Element of the list: %s".format(fte.last(list)))
    println("2nd Problem: Last Two Element of the list: %s".format(fte.lastTwo(list)))
    println("3rd Problem: K'th Element of the list: %s".format(fte.at(list, 4)))
    println("4th Problem: Length of the list: %s".format(fte.length(list)))
    println("5th Problem: Reverse of the list: %s".format(fte.reverse(list)))
    println("6th Problem: Is the list is Palindrome: %s".format(fte.isPalindrome(list)))
    println("10th Problem: Run-length encoding of the list with duplicate elements: %s".format(fte.encode(duplicateList)))
  }
}
