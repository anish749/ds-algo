package hashmaps;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of integers (or other types), return a new list with distinct values from the old
 * list. For a duplicate value, keep the first one.
 *
 * Created by anish on 08/09/18.
 */
public class DedupList {

  /**
   * Deduping using HashSet
   */
  public static <T> List<T> dedupHSet(List<T> list) {
    Set<T> distinctElems = new HashSet<>(list.size());

    List<T> ret = new ArrayList<>(list.size());

    for (T elem : list) {
      // If we haven't seen this before, we add it.
      if (!distinctElems.contains(elem)) {
        distinctElems.add(elem);
        ret.add(elem);
      }
      // Else we ignore
    }

    return ret;
  }


  /**
   * Deduping using LinkedHashSet
   */
  public static <T> List<T> dedupLSet(List<T> list) {
    Set<T> distinctElems = new LinkedHashSet<>(list.size());

    distinctElems.addAll(list);

    List<T> ret = new ArrayList<>(list.size());
    ret.addAll(distinctElems);

    return ret;
  }


  public static void main(String[] args) {

    assertThat(dedupHSet(Arrays.asList(1, 1, 1, 2, 3, 4)), is(Arrays.asList(1, 2, 3, 4)));
    assertThat(dedupHSet(Arrays.asList(4, 1, 5, 2, -1, 5, 5)), is(Arrays.asList(4, 1, 5, 2, -1)));

    assertThat(dedupLSet(Arrays.asList(1, 1, 1, 2, 3, 4)), is(Arrays.asList(1, 2, 3, 4)));
    assertThat(dedupLSet(Arrays.asList(4, 1, 5, 2, -1, 5, 5)), is(Arrays.asList(4, 1, 5, 2, -1)));

  }
}


