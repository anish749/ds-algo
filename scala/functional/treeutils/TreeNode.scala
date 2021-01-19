package functional.treeutils

sealed trait TreeNode[T]

case object Empty extends TreeNode[Nothing]

case class Node[T](value: T, children: Seq[TreeNode[T]]) extends TreeNode[T]


