package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TopologicalSort {


  static class Node implements Comparable {

    int value;

    public Node(int value) {
      this.value = value;
    }

    @Override
    public int compareTo(Object o) {
      Node other = (Node) o;
      return this.value - other.value;
    }

    @Override
    public int hashCode() {
      return value;
    }

    @Override
    public boolean equals(Object obj) {
      return this.value == ((Node) obj).value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  static Set<Node> visited = new HashSet<>();
  static Deque<Node> stack = new ArrayDeque<>();
  static TreeMap<Node, SortedSet<Node>> g = new TreeMap<>();


  public static void sortUtil(Node n) {
    if (!visited.contains(n)) {
      visited.add(n);
      if (g.containsKey(n)) {
        for (Node no : g.get(n)) {
          sortUtil(no);
        }
      }
      stack.push(n);
    }
  }


  private static String findOrder(int numVertex, int[][] edges) {
    // edge node 0 comes before 1

    for (int[] edge : edges) {
      Node from = new Node(edge[0]);

      if (!g.containsKey(from)) {
        g.put(from, new TreeSet<Node>());
      }
      g.get(from).add(new Node(edge[1]));
    }

    for (Node z : g.descendingKeySet()) {
      if (!visited.contains(z)) {
        sortUtil(z);
      }
    }

    if (visited.size() < numVertex) {
      return "Invalid";
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop()).append(" ");
    }

    return sb.toString();
  }

  public static void main(String[] args) {
//    int[][] edges = {{0, 1},
//        {2, 1}};
//    System.out.println(findOrder(3, edges));

    int[][] edges = {{1, 0},
        {0, 1}};
    System.out.println(findOrder(3, edges));


  }

}
