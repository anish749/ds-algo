package loops;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PerfectSquaresInRange {

  public static int numPerfSquares(int A, int B) {
    int lowerBound = (int) Math.sqrt(A);

    int upperBound = (int) Math.sqrt(B);

    return upperBound - lowerBound + 1;

  }


  public static int numPerfSquareLoop(int A, int B) {

    int cnt = 0;
    for (int i = A; i <= B; i++) {
      if (isPerfSquare(i)) {
        cnt++;
      }
    }

    return cnt;

  }

  static boolean isPerfSquare(int a) {
    int sqrt = (int) Math.sqrt(a);
    return sqrt * sqrt == a;
  }

  public static void main(String[] args) {
    assertThat(numPerfSquareLoop(4, 17), is(3));
    assertThat(numPerfSquareLoop(4, 16), is(3));
    assertThat(numPerfSquareLoop(1, 2), is(1));
    assertThat(numPerfSquareLoop(-4, 6), is(3));

    assertThat(numPerfSquareLoop(19, 21), is(0));
  }

}
