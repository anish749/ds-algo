package hashmaps

import org.scalatest.Matchers

import scala.collection.mutable

/**
 * Given a list of integers (or other types), return a new list with distinct values from
 * the old list. For a duplicate value, keep the first one.
 * The ordering of the list should be same as the orginal list.
 *
 * @ Spotify
 */
object DedupList extends Matchers {

  def dedup[T](list: List[T]): List[T] = {
    val distinctElems = mutable.HashSet[T]()
    list.flatMap { elem =>
      if (distinctElems.contains(elem)) {
        None
      } else {
        distinctElems.add(elem)
        Some(elem)
      }
    }
  }

  //scalastyle:off magic.number
  def main(args: Array[String]): Unit = {
    dedup(List(1, 1, 1, 2, 3, 4)) shouldBe List(1, 2, 3, 4)
    dedup(List(4, 1, 5, 2, -1, 5, 5)) shouldBe List(4, 1, 5, 2, -1)
  }

  //scalastyle:on magic.number
}
