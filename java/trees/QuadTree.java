package trees;

import static utils.JavaHelpers.require;

public class QuadTree {

  // A Node contains either 4 children or values.
  static class Node<T> {

    T value;
    Node<T>[] children = new Node[4];

    private Node() {
    }

    public boolean isValueNode() {
      return value != null;
    }

    public static <V> Node<V> valueNode(V value) {
      Node<V> n = new Node<V>();
      n.value = value;
      return n;
    }

    public static <V> Node<V> withChildNodes(Node<V>... children) {
      require(children.length == 4);
      Node<V> n = new Node<V>();
      n.value = null;
      n.children = children;
      return n;
    }
  }


  static Node<Boolean> or(Node<Boolean> tree1, Node<Boolean> tree2) {
    if (tree1 == null || tree2 == null) {
      return null;
    } else if (tree1.isValueNode() && tree2.isValueNode()) {
      return Node.valueNode(tree1.value || tree2.value);
    } else if (!tree1.isValueNode() && !tree2.isValueNode()) {
      return Node.<Boolean>withChildNodes(
          or(tree1.children[0], tree2.children[0]),
          or(tree1.children[1], tree2.children[1]),
          or(tree1.children[2], tree2.children[2]),
          or(tree1.children[3], tree2.children[3])
          );
    } else {
      // comparing null and boolean or value node and children node,
      // (two un-related types, producing undefined result)
      return null;
    }

  }

  static Node<Boolean> and(Node<Boolean> tree1, Node<Boolean> tree2) {
    if (tree1 == null || tree2 == null) {
      return null;
    } else if (tree1.isValueNode() && tree2.isValueNode()) {
      return Node.valueNode(tree1.value && tree2.value);
    } else if (!tree1.isValueNode() && !tree2.isValueNode()) {
      return Node.<Boolean>withChildNodes(
          and(tree1.children[0], tree2.children[0]),
          and(tree1.children[1], tree2.children[1]),
          and(tree1.children[2], tree2.children[2]),
          and(tree1.children[3], tree2.children[3])
          );
    } else {
      // comparing null and boolean or value node and children node,
      // (two un-related types, producing undefined result)
      return null;
    }

  }

  static void test() {

    Node<Boolean> inner1 = Node.withChildNodes(
        Node.valueNode(true),
        Node.valueNode(false),
        Node.valueNode(true),
        Node.valueNode(true)
    );
    Node<Boolean> inner2 = Node.withChildNodes(
        Node.valueNode(true),
        Node.valueNode(true),
        Node.valueNode(false),
        Node.valueNode(true)
    );

    Node<Boolean> outer1 = Node.withChildNodes(
        inner1,
        Node.valueNode(true),
        inner2,
        Node.valueNode(true)
    );

  }


  static class Utils {

    static <T> String displayString(Node<T> root) {
      return root.toString();
    }
  }
}
