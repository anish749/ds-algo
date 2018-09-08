package strings;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given two strings a and b, check if any anagram of b is a substring of a.
 *
 * @ Booking.com
 *
 * Created by anish on 06/10/17.
 */
public class AnagramSubstring {

  /*
  The solution is to sort of the second string using the ordering defined by the
  characters in the first string.
  If the first string contains the sorted string, then it is found.
   */

  private static String sortWith(final String dict, String toSort) {

    // Convert String to a Character Array
    Character[] stringAsCharArray = new Character[toSort.length()];
    for (int i = 0; i < toSort.length(); i++) {
      stringAsCharArray[i] = toSort.charAt(i);
    }

    // Sort using dict.idexOf(character) as a comparator
    Arrays.sort(stringAsCharArray, Comparator.comparingInt(dict::indexOf));

    // Convert back to string and return
    StringBuilder sorted = new StringBuilder(toSort.length());
    for (Character c : stringAsCharArray) {
      sorted.append(c);
    }

    return sorted.toString();

  }

  public static boolean anagramSubstring(String str, String substr) {
    return str.contains(sortWith(str, substr));
  }

  public static void main(String[] args) {
    assertTrue(anagramSubstring("acting", "cat"));
  }

}
