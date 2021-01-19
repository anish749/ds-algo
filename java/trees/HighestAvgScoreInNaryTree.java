package trees;

import java.util.ArrayList;

public class HighestAvgScoreInNaryTree {

  static class NaryNode {

    public int value;
    public ArrayList<NaryNode> children;

    public NaryNode() {
      this.children = new ArrayList<>();
    }

    public NaryNode(int value) {
      this.value = value;
      this.children = new ArrayList<>();
    }

    @Override
    public String toString() {
      return "N(" + value + ")";
    }
  }

  private static double calculateAverage(NaryNode root, double maxAvg) {
    double sum = 0;
    int count = 0;
    if (root.children.size() == 0) {
      return root.value;
    }
    for (NaryNode cc : root.children) {
      if (cc.children.size() > 0) {
        double tmp = calculateAverage(cc, maxAvg);
        if (tmp > maxAvg) {
          maxAvg = tmp;
        }
      }
      sum += cc.value;
      count++;
    }
    sum = sum / count;
    if (sum > maxAvg) {
      maxAvg = sum;
    }
    return maxAvg;
  }

  static class NodeWithAvg {

    NaryNode naryNode;
    int sum;
    int count;

    public static NodeWithAvg initNode(NaryNode naryNode) {
      return new NodeWithAvg(naryNode, 0, 0);
    }

    public NodeWithAvg(NaryNode naryNode, int sum, int count) {
      this.naryNode = naryNode;
      this.sum = sum;
      this.count = count;
    }

    public double avgOrZero() {
      if (count == 0) {
        return 0;
      } else {
        return (double) sum / (double) count;
      }
    }

    public boolean gt(NodeWithAvg other) {
      return this.avgOrZero()> other.avgOrZero();
    }

    @Override
    public String toString() {
      return "N(" + naryNode.toString() + ", " + sum + ", " + count + ")";
    }
  }

  private static NodeWithAvg nodeWithMaxAvgValue(NaryNode root, NodeWithAvg maxAvg) {
    int sum = root.value;
    int count = 1; // root is always there
    if (root.children.size() == 0) {
      return maxAvg;
    }
    for (NaryNode cc : root.children) {
      if (cc.children.size() > 0) {
        NodeWithAvg tmp = nodeWithMaxAvgValue(cc, maxAvg);
        if (tmp.gt(maxAvg)) {
          maxAvg = tmp;
        }
      }
      sum += cc.value;
      count++;
    }

    NodeWithAvg self = new NodeWithAvg(root, sum, count);

    if (self.gt(maxAvg)) {
      maxAvg = self;
    }
    return maxAvg;
  }

  public static void main(String[] args) {
    NaryNode root = new NaryNode(1);
    NaryNode mid = new NaryNode(2);
    NaryNode leaf = new NaryNode(3);
    mid.children.add(leaf);
    root.children.add(mid);

    System.out.println(nodeWithMaxAvgValue(root, NodeWithAvg.initNode(root)));
  }
}
