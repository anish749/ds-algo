package strings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Search for a pattern in a given string, in O(m + n) time.
 *
 * Created by anish on 06/08/18.
 */
public class KMPSearch {

  private static int[] getLppTable(String pattern) {
    int[] lppTable = new int[pattern.length()];
    lppTable[0] = 0;
    int j = 0;

    for (int i = 1; i < pattern.length(); ) {
      if (pattern.charAt(i) == pattern.charAt(j)) {
        lppTable[i++] = ++j; // lppTable[i] = j+1 ; j++ ; i ++
      } else if (j == 0) {
        lppTable[i++] = 0;
      } else {
        j = lppTable[j - 1];
      }
    }

    return lppTable;
  }


  public static boolean KMPpatSearch(String text, String pattern) {
    int[] lppTable = getLppTable(pattern);

    int j = 0;
    for (int i = 0; i < text.length() && j < pattern.length(); ) {
      if (text.charAt(i) == pattern.charAt(j)) { // There is a match
        i++;
        j++;
      } else if (j == 0) { // There is no match and we haven't found any partial matches yet.
        i++;
      } else {
        j = lppTable[j - 1]; // There has been a partial match till i-1, we move the pattern by the
        // same length as the longest prefix which is also the suffix of the pattern till j - 1
      }
    }

    return j == pattern.length();
  }

  public static void main(String[] args) {

    assertTrue(KMPpatSearch("ABABABCABABABCABABABC", "ABABAB"));
    assertFalse(KMPpatSearch("ABABABCABABABCABA", "ABABAXXB"));
  }
}
