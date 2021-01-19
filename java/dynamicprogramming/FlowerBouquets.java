package dynamicprogramming;

import java.util.Arrays;

public class FlowerBouquets {

  public static int flowerBouquets(int p, int q, String s) {

    // 3 consecutive 0 = value p
    // 10 or 10 = value q

    // Write your code here

    if (s.length() <= 1) {
      return 0;
    }

    int dp[] = new int[s.length()];
    Arrays.fill(dp, 0);

    dp[0] = 0; // Cannot make a bouquet.

    if ((s.charAt(0) == '0' && s.charAt(1) == '1') || (s.charAt(0) == '1' && s.charAt(1) == '0')) {
      dp[1] = q;
    }

    if (s.length() == 2) {
      return dp[1];
    }

    if ((s.charAt(1) == '0' && s.charAt(2) == '1') || (s.charAt(1) == '1' && s.charAt(2) == '0')) {
      dp[2] = Math.max(dp[1], q);
    }

    if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2)
        && s.charAt(0) == '0') {
      dp[2] = Math.max(dp[1], p);
    }

    // Special case for 011 and 100
    if (s.charAt(1) != s.charAt(0) && s.charAt(1) == s.charAt(2)) {
      dp[2] = dp[1];
    }

    for (int i = 3; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i - 1) == s.charAt(i - 2)
          && s.charAt(i) == '0') {
        dp[i] = Math.max(dp[i - 1], p + dp[i - 3]);
      } else if ((s.charAt(i) == '0' && s.charAt(i - 1) == '1') ||
          (s.charAt(i) == '1' && s.charAt(i - 1) == '0')) {
        dp[i] = Math.max(dp[i - 1], q + dp[i - 2]);
      } else {
        dp[i] = dp[i - 1];
      }
    }

    System.out.println(Arrays.toString(s.toCharArray()));
    System.out.println(Arrays.toString(dp));

    return dp[s.length() - 1];

  }

  public static void main(String[] args) {
    System.out.println(flowerBouquets(2, 3, "0001000"));

    System.out.println(flowerBouquets(2, 3, "001101011"));
    System.out.println(flowerBouquets(2, 3, "101001011"));
    System.out.println(flowerBouquets(2, 3, "100001011"));
    System.out.println(flowerBouquets(2, 3, "011001011"));
  }
}
