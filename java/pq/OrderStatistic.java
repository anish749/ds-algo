package pq;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static utils.JavaHelpers.require;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * In statistics, the kth order statistic of a statistical sample is equal to its kth-smallest
 * value.
 */
public class OrderStatistic<T extends Comparable> {

  public T kMin(List<T> sample, int k) {
    require(k <= sample.size(), "k must be less than the size of sample.");
    require(k > 0, "k cannot be negative");
    require(sample.size() > 0, "sample cannot be empty");

    PriorityQueue<T> kSmall = new PriorityQueue<>(k,
        Comparator.reverseOrder()); // Use a reverse Comparator to make it behave like max heap

    for (T element : sample) {

      if (kSmall.size() == k && element.compareTo(kSmall.peek()) < 0) {
        // peek() would give max value because of inverse comparator
        kSmall.poll(); // Discard max element.
      }

      if (kSmall.size() < k) {
        kSmall.add(element);
      }
    }

    return kSmall.peek();
  }


  public static void main(String[] args) {
    // Examples
    // Max Heap using priority queue
    // Reverse order comparator
    PriorityQueue<Integer> kSmall = new PriorityQueue<>(5, Comparator.reverseOrder());
    kSmall.add(6);
    kSmall.add(4);
    kSmall.add(8);

    assertThat(kSmall.peek(), is(8));

    OrderStatistic<Integer> orderStatistic = new OrderStatistic<>();

    // Test cases
    assertThat(orderStatistic.kMin(Arrays.asList(5, 4, 9, 2, 7, 3, 6, 8, 6, 4), 5), is(5));
    assertThat(orderStatistic.kMin(Arrays.asList(5, 4, 9, 2, 7, 3, 6, 8, 6, 4), 1), is(2));
    assertThat(orderStatistic.kMin(Arrays.asList(5), 1), is(5));
    assertThat(orderStatistic.kMin(Arrays.asList(1, 2, 3, 4), 4), is(4));

  }
}
