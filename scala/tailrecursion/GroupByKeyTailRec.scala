package tailrecursion

import org.scalatest.Matchers

import scala.annotation.tailrec

object GroupByKeyTailRec extends Matchers {

  /**
   * Group By key implemented with tail recursion
   */
  @tailrec
  final def groupByKey[K, V](kvPairs: Seq[(K, V)],
                             m: Map[K, Seq[V]] = Map[K, Seq[V]]()): Map[K, Seq[V]] = {
    kvPairs match {
      case Nil => m
      case (a, b) :: tail =>
        groupByKey(
          tail,
          m + m.get(a)
            .map(l => (a, l :+ b))
            .getOrElse((a, Seq(b)))
        )
    }
  }

  def main(args: Array[String]): Unit = {

    groupByKey(
      List((1, "a"), (1, "b"),
        (2, "x"), (3, "a"),
        (2, "y"), (3, "c"))
    ) shouldBe
      Map(1 -> List("a", "b"),
        2 -> List("x", "y"),
        3 -> List("a", "c"))

    groupByKey(List()) shouldBe Map()
  }
}
