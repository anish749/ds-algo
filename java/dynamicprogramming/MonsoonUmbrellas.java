package dynamicprogramming;

import java.util.Arrays;
import java.util.List;

/**
 * Very similar to min coins for a given change
 *
 * https://www.geeksforgeeks.org/find-minimum-number-of-coins-that-make-a-change/
 *
 * @LinkedIn
 */
public class MonsoonUmbrellas {

  public static int getMinUmbrella(int n, // people to cover
      List<Integer> availableUmbrellas) {

    // table[i] will be storing
    // the minimum number of coins
    // required for i value. So
    // table[V] will have result
    int table[] = new int[n + 1];

    // Base case (If given value V is 0)
    table[0] = 0;

    // Initialize all table values as Infinite
    for (int i = 1; i <= n; i++) {
      table[i] = Integer.MAX_VALUE;
    }

    // Compute minimum coins required for all
    // values from 1 to V
    for (int i = 1; i <= n; i++) {
      // Go through all coins smaller than i
      for (int j = 0; j < availableUmbrellas.size(); j++) {
        if (availableUmbrellas.get(j) <= i) {
          int sub_res = table[i - availableUmbrellas.get(j)];
          if (sub_res != Integer.MAX_VALUE
              && sub_res + 1 < table[i]) {
            table[i] = sub_res + 1;
          }


        }
      }

    }
    return availableUmbrellas.get(n);
  }

  public static int getUmbrellas(int n,
      List<Integer> p) {

    int table[] = new int[n + 1];
    Arrays.fill(table, Integer.MAX_VALUE);
    table[0] = 0;

    for (int i = 1; i <= n; i++) {
      for (Integer aP : p) {
        if (aP <= i) {
          int sub_res = table[i - aP];
          if (sub_res != Integer.MAX_VALUE
              && sub_res + 1 < table[i]) {
            table[i] = sub_res + 1;
          }
        }
      }
    }
    for (int i = 1; i <= n; i++) {
      if (table[i] == Integer.MAX_VALUE) {
        table[i] = -1;
      }
    }

    return table[n];
  }

  public static void main(String[] args) {
    System.out.println(getUmbrellas(2, Arrays.asList(2, 4)));
    System.out.println(getUmbrellas(1, Arrays.asList(2)));
  }

}
