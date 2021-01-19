package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks/editorial
 *
 * LinkedIn
 */
public class CutSticks {

  public static List<Integer> cutSticks(List<Integer> lengths) {

    int arr[] = new int[1001];
    for (int i = 0; i < lengths.size(); i++) {
      arr[lengths.get(i)] += 1;
    }

    int counter = 0;

    List<Integer> result = new ArrayList<>(lengths.size());

    for (int i = 1000; i >= 0; i--) {
      if (arr[i] > 0) {
        counter += arr[i];
        result.add(0, counter);
      }
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println(cutSticks(Arrays.asList(5, 4, 4, 2, 2, 8)));
  }

}
/*

N = input()
num = map(int, raw_input().split())

val = [0] * 1001
for i in num:
    val[i] += 1
counter = 0
val = val[::-1]
ans = []
for i in val:
    if i > 0:
        counter += i
        ans.append(counter)
ans = ans[::-1]
for i in ans:
    print i

 */