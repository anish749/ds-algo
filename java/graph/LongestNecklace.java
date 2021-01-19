package graph;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

// Longest connected component in an undirected graph
public class LongestNecklace {

  // Path is from index of array to the value
  static int longestNecklace(int A[]) {
    int maxSoFar = Integer.MIN_VALUE;

    boolean visited[] = new boolean[A.length];

    Arrays.fill(visited, false);

    for (int i = 0; i < A.length; i++) {
      if (!visited[i]) {
        int l = lengthOfNecklace(A, i, visited);
        if (l > maxSoFar) {
          maxSoFar = l;
        }
      }
    }
    return maxSoFar;
  }

  private static int lengthOfNecklace(int A[], int startIndex, boolean visited[]) {
    int len = 0;

    int visiting = startIndex;
    do {
      visited[visiting] = true;
      len++;
      visiting = A[visiting];
    } while (visiting != startIndex);

    return len;
  }

  public static void main(String[] args) {
    int A[] = {5, 4, 0, 3, 1, 6, 2};
    assertThat(longestNecklace(A), is(4));
  }

}
