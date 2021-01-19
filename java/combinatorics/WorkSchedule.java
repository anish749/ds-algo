package combinatorics;

import java.util.List;

public class WorkSchedule {

  public static List<String> findSchedules(int workHours, int dayHours, String pattern) {
    // Write your code here

    int unk = 0;
    int hoursWorked = 0;
    for (int i = 0; i < pattern.length(); i++) {
      if (pattern.charAt(i) == '?') {
        unk++;
      } else {
        hoursWorked += (pattern.charAt(i) - '0');
      }
    }

    int hoursLeft = workHours - hoursWorked;

    // distribute hoursLeft into unk buckets with no more than dayHours

    int radix = dayHours + 1; // can also work 0 hours
    // Permutations of unk numbers in base radix that add up to hoursLeft

    int arr[] = new int[unk];
    findCombinationsUtil(arr, 0, hoursLeft, hoursLeft);

    return null;
  }

  static void findCombinations(int n) {
    // array to store the combinations
    // It can contain max n elements
    int arr[] = new int[n];

    // find all combinations
    findCombinationsUtil(arr, 0, n, n);
  }

  static void findCombinationsUtil(int arr[], int index,
      int num, int reducedNum) {
    // Base condition
    if (reducedNum < 0) {
      return;
    }

    // If combination is
    // found, print it
    if (reducedNum == 0) {
      for (int i = 0; i < index; i++) {
        System.out.print(arr[i] + " ");
      }
      System.out.println();
      return;
    }

    // Find the previous number
    // stored in arr[]. It helps
    // in maintaining increasing
    // order
    int prev = (index == 0) ?
        1 : arr[index - 1];

    // note loop starts from
    // previous number i.e. at
    // array location index - 1
    for (int k = prev; k <= num; k++) {
      // next element of
      // array is k
      arr[index] = k;

      // call recursively with
      // reduced number
      findCombinationsUtil(arr, index + 1, num,
          reducedNum - k);
    }
  }

  public static void main(String[] args) {
    findSchedules(56, 8, "???8???");
//    findCombinations(5);
  }
}
