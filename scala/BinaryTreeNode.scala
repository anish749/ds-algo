package domain

case class BinaryTreeNode[T](value: T, left: Option[BinaryTreeNode[T]] = None, right: Option[BinaryTreeNode[T]] = None) {
  /**
   * Number of children in this tree.
   * For use with augmented trees.
   */
  var childCnt: Int = _
}