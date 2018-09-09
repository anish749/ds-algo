package stacks;

import static common.JavaHelpers.require;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Stack;


/**
 * Finding the next greater element for each element in an array in O(n) time. A next greater
 * element may or may not exist
 *
 * Created by anish on 08/09/18.
 */
public class NextGreaterElement {

  public static <T extends Comparable<T>> List<Optional<T>> nextGreaterElement(T[] a) {
    require(a.length > 0, "At least 1 element expected");

    List<Optional<T>> nextGreater = new ArrayList<>(a.length);

    // Using Deque<T> stack = new ArrayDeque<T>(); is a better idea.
    Stack<T> stack = new Stack<>();

    // Add first element.
    stack.push(a[0]);

    // Loop from second element
    for (int i = 1; i < a.length; i++) {
      while (!stack.isEmpty() && stack.peek().compareTo(a[i]) < 0) {
        stack.pop();
        nextGreater.add(Optional.of(a[i]));
      }
      stack.push(a[i]);
    }

    while (!stack.isEmpty()) {
      stack.pop();
      nextGreater.add(Optional.empty());
    }

    return nextGreater;

  }

  public static void main(String[] args) {
    assertThat(nextGreaterElement(new Integer[]{1, 2, 3, 4}),
        is(Arrays.asList(Optional.of(2), Optional.of(3), Optional.of(4), Optional.empty())));

    assertThat(nextGreaterElement(new Integer[]{1, 5, 2, 7, 1}),
        is(Arrays.asList(Optional.of(5), Optional.of(7), Optional.of(7), Optional.empty(),
            Optional.empty())));

    assertThat(nextGreaterElement(new Integer[]{1, 5, 6, 7, 3, 2, 1}),
        is(Arrays.asList(Optional.of(5), Optional.of(6), Optional.of(7), Optional.empty(),
            Optional.empty(), Optional.empty(), Optional.empty())));

  }
}
