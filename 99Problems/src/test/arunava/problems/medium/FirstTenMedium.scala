package test.arunava.problems.medium

import test.arunava.problems.easy.FirstTenEasy

import scala.annotation.tailrec

/**
  * Created by arunavas on 24/7/16.
  */
class FirstTenMedium {
  lazy val util = new FirstTenEasy
  // Flatten a nested list structure. (medium)
  /*
  // Without tailrec
  final def flatten[A](list: List[List[A]]): List[A] = list match {
    case Nil => Nil
    case h :: t => (flatten(t) foldLeft(h))(_ :+ _)
  }*/
  final def flatten[A](list: List[List[A]]): List[A] = {
    @tailrec
    def aux(lst: List[List[A]], flatList: List[A]): List[A] = lst match {
      case Nil => flatList
      case h :: t => aux(t, (flatList foldRight (h))(_ :: _))
    }
    aux(list, Nil)
  }

  // Eliminate consecutive duplicates of list elements. (medium)
  /*
  //Without telrec
  final def compress[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case h :: t => h :: compress(list dropWhile(_ == h))
  }*/
  final def compress[A](list: List[A]): List[A] = {
    @tailrec
    def doCompress(lst: List[A], compressedList: List[A]): List[A] = lst match {
      case Nil => compressedList
      case h :: t => doCompress(lst dropWhile(_ == h), h :: compressedList)
    }
    util.reverse(doCompress(list, Nil))
  }

  // Pack consecutive duplicates of list elements into sublists. (medium)
  final def pack[A](list: List[A]): List[List[A]] = {
    @tailrec
    def doPack(lst: List[A], packedList: List[List[A]]): List[List[A]] = lst match {
      case Nil => packedList
      case h :: t => doPack(lst dropWhile(_ == h), lst.takeWhile(_ == h) :: packedList)
    }
    util.reverse(doPack(list, Nil))
  }
}
