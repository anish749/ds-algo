package stack

import org.scalatest.Matchers

import scala.collection.mutable

/**
 * Finding the next greater element for each element in an array in O(n) time.
 * A next greater element may or may not exist
 *
 * Created by anish on 04/11/17.
 */
object NextGreaterElement extends Matchers {

  private def nextGreater[T](a: Array[T])(implicit ev: T => Ordered[T]): List[Option[T]] = {

    require(a.length > 1, "At least 1 element expected")

    // TODO mutable.Stack is deprecated, try with a list assigned to a var.
    val stack = mutable.Stack(a.head)

    val nextGreaterElem: mutable.ListBuffer[(T, Option[T])] =
      a.drop(1).foldLeft(mutable.ListBuffer[(T, Option[T])]()) { (ng, ai) =>
        while (stack.nonEmpty && stack.top < ai) {
          ng += ((stack.pop(), Some(ai)))
        }
        stack.push(ai)
        ng
      }

    while (stack.nonEmpty) {
      nextGreaterElem += ((stack.pop(), None))
    }

    nextGreaterElem.map(_._2).toList
  }

  // scalastyle:off magic.number
  def main(args: Array[String]): Unit = {
    nextGreater(Array(1, 2, 3, 4)) shouldBe List(Some(2), Some(3), Some(4), None)

    nextGreater(Array(1, 5, 2, 7, 1)) shouldBe List(Some(5), Some(7), Some(7), None, None)

    nextGreater(Array(1, 5, 6, 7, 3, 2, 1)) shouldBe List(Some(5), Some(6), Some(7), None, None, None, None)
  }

  // scalastyle:on magic.number

}
