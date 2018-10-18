package array;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

/**
 * Given a set of commands (LEFT, RIGHT, UP, DOWN) and a square matrix, find the last position of
 * the Rover, assuming we start at 0. Matrix of 4 means 0  1  2  3 4  5  6  7 8  9  10 11 12 13 14
 * 15
 *
 * More example in test case.
 */
public class MovingInMars {

  public static int roverMove(int matrixSize, List<String> cmds) {

    int pos = 0;

    for (String cmd : cmds) {
      switch (cmd) {
        case "LEFT":
          pos = left(matrixSize, pos);
          break;
        case "RIGHT":
          pos = right(matrixSize, pos);
          break;
        case "UP":
          pos = up(matrixSize, pos);
          break;
        case "DOWN":
          pos = down(matrixSize, pos);
          break;
      }
    }

    return pos;
  }

  private static int left(int matrixSize, int pos) {
    if (pos % matrixSize == 0) {
      return pos;
    } else {
      return pos - 1;
    }
  }

  private static int right(int matrixSize, int pos) {
    if (pos % matrixSize == matrixSize - 1) {
      return pos;
    } else {
      return pos + 1;
    }
  }

  private static int up(int matrixSize, int pos) {
    if (pos < matrixSize) {
      return pos;
    } else {
      return pos - matrixSize;
    }
  }

  private static int down(int matrixSize, int pos) {
    if (pos + matrixSize >= matrixSize * matrixSize) {
      return pos;
    } else {
      return pos + matrixSize;
    }
  }

  public static void main(String[] args) {
    assertThat(
        roverMove(4,
            asList("RIGHT",
                "UP",
                "DOWN",
                "LEFT",
                "LEFT",
                "DOWN"
            )), is(8));

  }
}
