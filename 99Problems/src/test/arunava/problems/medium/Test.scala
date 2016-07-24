package test.arunava.problems.medium

/**
  * Created by arunavas on 24/7/16.
  */
object Test {
  def main(args: Array[String]): Unit = {
    val ftm = new FirstTenMedium

    val listOfList = List(List.range(0, 5), List.range(5, 10))
    val list = List(0, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 0, 0, 0)
    println("List Of List: %s".format(listOfList))
    println("list: %s".format(list))
    println("7th Problem: Flattened listOfList: %s".format(ftm.flatten(listOfList)))
    println("8th Problem: Eliminate consecutive duplicates from the list: %s".format(ftm.compress(list)))
    println("9th Problem: Pack consecutive duplicates into sublists from the list: %s".format(ftm.pack(list)))
  }
}
