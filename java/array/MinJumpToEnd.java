package array;

public class MinJumpToEnd {

  public static int powerJump(String game) {

    char last = game.charAt(game.length() - 1);

    int maxPow = 1;

    int pow = 1;
    for (int i = 0; i < game.length(); i++) {

      char c = game.charAt(i);

      if (last == c) {
        if (pow > maxPow) {
          maxPow = pow;
        }
        pow = 1;
      } else {
        pow++;
      }
    }

    return maxPow;


  }
}
