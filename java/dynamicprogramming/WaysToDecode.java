package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a=1, b=2, c=3 ... z = 26. In how many ways can a string of numbers [0-9] be decoded?
 */
public class WaysToDecode {

  public static int decode(String s) {
    if (s.length() == 0) {
      return 1;
    }
    // Cannot start with 0
    if (s.startsWith("0")) {
      return 0;
    }

    int ways[] = new int[s.length()];
    ways[0] = 1; // can be decoded in at least one way

    for (int i = 1; i < s.length(); i++) {

      if (Integer.parseInt(s.substring(i - 1, i + 1)) <= 26) {
        ways[i] = ways[i - 1] * 2;
      } else {
        ways[i] = ways[i - 1];
      }
    }

    return ways[s.length() - 1];
  }

  public static void main(String[] args) {
//    decodeRecur("");
//    assertThat(decode("0"), is(0));
//    assertThat(decode("01"), is(0));
//    assertThat(decode(""), is(1));
//    assertThat(decode("1"), is(1));
//    assertThat(decode("12"), is(2));
//    assertThat(decode("111"), is(3));
//
//    System.out.println(decode("1111"));

  }

  public static int decodeRecur(String s) {

    String arr[][] =
        {{"Nord", "Nord", "Holm", "Holm", "Berg"},
            {"Berg", "Fred", "Fred", "Fred", "Fred"}};

    int count = 0;
    for (int i = 0; i < arr[0].length; i++) {
      if (arr[1][i].equals("Fred")) {
        System.out.println(i + " " + arr[1][i]);
        count++;
      }
    }

    System.out.println("Total is " + count);

    return 1;
  }


  static List<Integer> beHappy(double sightRadius, List<List<Integer>> eventsGrid) {

    double prodX = 1.0;
    double prodY = 1.0;
    double prodW = 1.0;

    for (List<Integer> event : eventsGrid) {
      int x = event.get(0);
      int y = event.get(1);
      int w = event.get(2);

      prodX *= (x + 1) * w;
      prodY *= (y + 1) * w;
      prodW *= w;


    }
    double meX = Math.pow(prodX, 1.0 / (eventsGrid.size() * prodW));
    double meY = Math.pow(prodY, 1.0 / (eventsGrid.size() * prodW));

    List<Integer> x = new ArrayList<Integer>();
    x.add((int) meX);
    x.add((int) meY);

    return x;

  }

  /**
   * London Eye with 4 gondolas. 4 shifts for one complete rotation. customers stay for 4 shifts.
   * customers only get up or get down when the gondola in the lowest point
   *
   * Find the most optimal number of shifts to maximize profit.
   */

  static int closing_time(List<Integer> queue, double admission, double runningCost) {

    double costSoFar = 0.0;
    double earningSoFar = 0.0;
    int waiting = 0;

    double profitSoFar = 0.0;

    int i = 0;
    for (; i <= queue.size(); i++) {
      waiting += qleft(queue.get(i));
      earningSoFar += (queue.get(i) % 4) * admission;
      costSoFar += runningCost;

      if (profitSoFar <= (earningSoFar - costSoFar)) {
        break;
      }

      profitSoFar = earningSoFar - costSoFar;
      waiting = waiting > 4 ? waiting - 4 : 0;
    }

    i += waiting / 4;

    if (profitSoFar < 0) {
      return -1;
    }

    return i;

  }

  static int qleft(int s) {
    return s - 4 < 0 ? 0 : s - 4;
  }


}
