package trees;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

public class HuffmanDecoding {

  public static String decode(List<String> codes, String encoded) {

    return decodeWithTree(encoded, createHuffmanTree(codes));

  }

  private static class Node {

    public char data;
    public Node left, right;

    @Override
    public String toString() {
      return "(" + data + ")";
    }
  }

  private static String decodeWithTree(String S, Node root) {
    StringBuilder output = new StringBuilder();
    Node c = root;
    for (int i = 0; i < S.length(); i++) {
      c = S.charAt(i) == '1' ? c.right : c.left;
      if (c.left == null && c.right == null) {
        output.append(c.data);
        c = root;
      }
    }
    return output.toString();
  }

  private static Node createHuffmanTree(List<String> codes) {
    Node root = new Node();

    for (String code : codes) {
      String t = code.split("\t")[0];
      Node leaf;
      if (t.equals("[newline]")) {
        leaf = new Node();
        leaf.data = '\n';
      } else {
        leaf = new Node();
        leaf.data = t.charAt(0);
      }

      String encode = code.split("\t")[1];
      Node current = root;
      int i = 0;
      for (; i < encode.length() - 1; i++) {
        char c = encode.charAt(i);
        if (c == '0') {
          if (current.left == null) {
            current.left = new Node();
          }
          current = current.left;
        } else {
          if (current.right == null) {
            current.right = new Node();
          }
          current = current.right;
        }
      }
      if (encode.charAt(i) == '0') {
        current.left = leaf;
      } else {
        current.right = leaf;
      }
    }

    return root;

  }

  public static void main(String[] args) {
    assertThat(
        decode(asList(
            "a	100100",
            "b	100101",
            "c	110001",
            "d	100000",
            "[newline]	111111",
            "p	111110",
            "q	000001"
        ), "111110000001100100111111100101110001111110"),
        is("pqa\nbcp"));

  }

}


