package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anish on 01/10/17.
 */
public class TopViewOfBinaryTree {

  private void printTopView(Node root) {

    if (root == null) {
      return;
    }
    Queue<QueueItem> toVisit = new LinkedList<QueueItem>();
    toVisit.offer(new QueueItemDelimiter());
    toVisit.offer(new QueueItem(root, 0)); // root is at offset 0

    int visExtremeLeft = 1;
    int visExtremeRight = -1;

    int level = -1;
    while (!toVisit.isEmpty()) {
      QueueItem current = toVisit.poll();

      if (current instanceof QueueItemDelimiter) {
        if (!toVisit.isEmpty()) {
          level++;
          // System.out.print("\nlevel : " + level + " -> ");
          toVisit.offer(current);
        }
      } else {
        if (current.offset <= 0
            && current.offset < visExtremeLeft) { // in left // also takes care of root
          visExtremeLeft = current.offset;
          System.out.print(current.node);
        }
        if (current.offset > 0 && current.offset > visExtremeRight) {
          visExtremeRight = current.offset;
          System.out.print(current.node);
        }

        if (current.node.left != null) {
          toVisit.offer(new QueueItem(current.node.left, current.offset - 1));
        }
        if (current.node.right != null) {
          toVisit.offer(new QueueItem(current.node.right, current.offset + 1));
        }
      }


    }


  }


  public static void main(String[] args) {

        /* Create following Binary Tree
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6
         */
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.right = new Node(4);
    root.left.right.right = new Node(5);
    root.left.right.right.right = new Node(6);

    new TopViewOfBinaryTree().printTopView(root);
  }


}

class Node {

  int value;
  Node left;
  Node right;

  public Node(int value) {
    this.value = value;
    left = right = null;
  }

  @Override
  public String toString() {
    return "Node(" + value + ") ";
  }
}

class QueueItem {

  Node node;
  int offset;

  public QueueItem(Node node, int offset) {
    this.node = node;
    this.offset = offset;
  }
}

class QueueItemDelimiter extends QueueItem {

  public QueueItemDelimiter() {
    super(new Node(0), 0);
  }
}
