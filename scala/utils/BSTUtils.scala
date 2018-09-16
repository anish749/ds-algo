package utils

import domain.BinaryTreeNode

/**
 * Utility functions for programming with Binary Search Trees.
 *
 * Created by anish on 06/11/17.
 */
object BSTUtils {

  /**
   * Create a BST from an array
   *
   * @param arr An Array of type T, where T should have ordering defined.
   * @tparam T
   * @return Root of the created Binary Search Tree
   */
  def arrayToBST[T: Ordering](arr: Array[T]): Option[BinaryTreeNode[T]] = {
    sortedArrayToBST(arr.sorted)
  }

  /**
   * Create a BST from a sorted array and return the root
   * The element in the middle becomes the root, to keep the tree balanced.
   *
   * @param arr A sorted array of type T
   * @tparam T
   * @return Root of the created Binary Search Tree
   */
  def sortedArrayToBST[T](arr: Array[T]): Option[BinaryTreeNode[T]] = {
    def toBST(low: Int, hi: Int): Option[BinaryTreeNode[T]] = {
      val mid = (low + hi) / 2
      if (low == hi) {
        Some(BinaryTreeNode(arr(mid)))
      }
      else if (low == mid) {
        Some(BinaryTreeNode(arr(mid), left = None, right = toBST(mid + 1, hi)))
      }
      else if (hi == mid) {
        Some(BinaryTreeNode(arr(mid), left = toBST(low, mid - 1), right = None))
      }
      else if (low < hi) {
        Some(BinaryTreeNode(arr(mid), left = toBST(low, mid - 1), right = toBST(mid + 1, hi)))
      }
      else {
        None
      }
    }

    toBST(0, arr.length - 1)
  }

}
