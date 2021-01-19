package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxAttendanceStreak {

  public static int maxStreak(int m, List<String> data) {

    int c = 0;
    List<Integer> cnts = new ArrayList<>();
    for (int i = 0; i < data.size(); i++) {
      int ai = data.get(i).replaceAll("N", "").length();
      if (ai == m) {
        c++;
      } else {
        cnts.add(c);
        c = 0;
      }
    }

    cnts.add(c);

    System.out.println(cnts);

    int max = 0;
    for (int i : cnts) {
      if (i > max) {
        max = i;
      }
    }
    return max;
  }

  public static void main(String[] args) {
    System.out.println(maxStreak(4, Arrays.asList("YNYY", "YYYY", "YYYY", "YYNY", "NYYN")));

    System.out.println(maxStreak(4, Arrays.asList("YNYY", "YYYY", "YYYY", "YYYY", "NYYN")));
    System.out.println(maxStreak(3, Arrays.asList("YYY", "YYY", "YYY", "YYY", "YYY")));
    System.out.println(maxStreak(2, Arrays.asList("YN", "NN")));
  }

}
