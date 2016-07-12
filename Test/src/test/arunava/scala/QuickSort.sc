package test.arunava.scala

import java.util.Arrays

object QuickSort {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  def sort(arr: Array[Int]): Array[Int] = {
  	if(arr.length == 1) arr
  	else {
  		val pivot = arr(arr.length / 2)
  		Array.concat(arr filter (pivot >), arr filter (pivot ==), arr filter { x => pivot < x })
  	}
  }                                               //> sort: (arr: Array[Int])Array[Int]
  
  val arr = Array(2, 0, 4)                        //> arr  : Array[Int] = Array(2, 0, 4)
  println(Arrays.toString(sort(arr)))             //> [0, 2, 4]
  val x = 10.+(10)                                //> x  : Int = 20
  
}