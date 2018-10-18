package strings;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

/**
 * The minimal number of operations required to have no consecutive characters for a string. Eg: aab
 * with 1 operation become gab abb with 1 op become aba aaa with 1 op become aga
 */
public class NoConsecutiveChars {

  public static List<Integer> minimalOperations(List<String> words) {

    List<Integer> operations = new ArrayList<>(words.size());

    int c;
    int ops;
    for (String word : words) {
      word += " "; // So that we can detect zz at the end
      c = 1;
      ops = 0;
      for (int i = 1; i < word.length(); i++) {
        if (word.charAt(i) == word.charAt(i - 1)) {
          c++;
        } else {
          ops += c / 2;
          c = 1;
        }
      }

      operations.add(ops);
    }

    return operations;
  }

  public static void main(String[] args) {
    assertThat(minimalOperations(asList("abb", "abb", "aaa", "abaaa")),
        is(asList(1, 1, 1, 1)));
  }

}
