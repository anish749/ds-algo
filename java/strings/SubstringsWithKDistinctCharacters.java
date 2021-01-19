package strings;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

public class SubstringsWithKDistinctCharacters {

  static int countKDistinctSubstrings(String str, int k) {
    // Initialize result
    int res = 0;

    int n = str.length();

    // To store count of characters from 'a' to 'z'
    int cnt[] = new int[26];

    // Consider all substrings beginning with
    // str[i]
    for (int i = 0; i < n; i++) {
      int dist_count = 0;

      // Initializing count array with 0
      Arrays.fill(cnt, 0);

      // Consider all substrings between str[i..j]
      for (int j = i; j < n; j++) {
        // If this is a new character for this
        // substring, increment dist_count.
        if (cnt[str.charAt(j) - 'a'] == 0) {
          dist_count++;
        }

        // Increment count of current character
        cnt[str.charAt(j) - 'a']++;

        // If distinct character count becomes k,
        // then increment result.
        if (dist_count == k) {
          res++;
        }
      }
    }

    return res;
  }

  public static void main(String[] args) {
    assertThat(countKDistinctSubstrings("pqpqs", 2),
        is(7));
    assertThat(countKDistinctSubstrings("abafg", 2),
        is(5));
    assertThat(countKDistinctSubstrings("abc", 2),
        is(2));
  }


  static int countKDistinctSubstring(String str, int k) {
    int cnt = 0;
    int n = str.length();
    int freq[] = new int[26];

    for (int i = 0; i < n; i++) {
      int dist_count = 0;
      Arrays.fill(freq, 0);
      for (int j = i; j < n; j++) {
        if (freq[str.charAt(j) - 'a'] == 0) {
          dist_count++;
        }
        freq[str.charAt(j) - 'a']++;
        if (dist_count == k) {
          cnt++;
        }
      }
    }
    return cnt;
  }
}

