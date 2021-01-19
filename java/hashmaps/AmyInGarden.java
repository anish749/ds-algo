package hashmaps;

import java.util.Arrays;


/**
 * type of fruit in each tree given in array. there are only two buckets. each bucket can hold only
 * one type of fruit. once a third fruit in found, you stop picking. find the max number of fruits
 * that you can pick. there is only 1 fruit per tree.
 */

public class AmyInGarden {

  public static int fruitPicker(int trees[]) {

    if (trees.length == 0) {
      return 0;
    }

    if (trees.length == 1) {
      return 1;
    }

    if (trees.length == 2) {
      return 2;
    }

    int[] dp1 = new int[trees.length]; // For sequences starting at i
    int[] dp2 = new int[trees.length]; // For sequences starting at i - 1

    for (int i = 2; i < trees.length; i++) {
      dp1[i] = 1;
      dp2[i] = 2;
    }

    dp1[0] = 1;
    dp1[1] = 1;

    dp2[0] = 0; // undefined
    dp2[1] = 2;

//    int p = 0;
    for (int i = 2; i < trees.length; i++) {

      if (trees[i] == trees[i - 1]) {
        dp1[i] = dp1[i - 1] + 1;
        dp2[i] = dp2[i - 1] + 1;
//        p = i - 1;
      } else if (trees[i] == trees[i - 2]) {
        // Can be added to both
        dp1[i] = 1;
        dp2[i] = dp2[i - 1] + 1;
      } else if (trees[i] != trees[i - 1] && dp2[i - 1] == 1) { // new bucket was started from i-1
        dp2[i] = dp2[i - 1] + 1;
      }

    }

    System.out.println("trs" + Arrays.toString(trees));
    System.out.println("dp1" + Arrays.toString(dp1));

    System.out.println("dp2" + Arrays.toString(dp2));

    int max = 0;
    for (int i = 0; i < trees.length; i++) {
      if (dp1[i] > max) {
        max = dp1[i];
      }
    }

    for (int i = 0; i < trees.length; i++) {
      if (dp2[i] > max) {
        max = dp2[i];
      }
    }

    return max;
  }

  public static void main(String[] args) {
    int[] trees = {1, 2, 1, 3, 4, 3, 5, 1, 2};
    System.out.println(fruitPicker(trees));

    int[] trees2 = {1, 2, 1, 2, 1, 2, 1};
    System.out.println(fruitPicker(trees2));

    int[] trees3 = {1, 2, 1, 3, 4, 3, 4, 5, 1, 2};
    System.out.println(fruitPicker(trees3));

    int[] trees4 = {1, 2, 1, 3, 4, 3, 4, 5, 1, 2, 1, 2, 2, 2, 2, 2, 2, 1, 5, 6};
    System.out.println(fruitPicker(trees4));

    // doesn't work on consecutives

  }

}
