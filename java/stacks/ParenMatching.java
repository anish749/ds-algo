package stacks;


//Max number of balanced division
public class ParenMatching {

  public int solution(String S) {

    int n = 0;

    int openR = 0;
    int openL = 0;

    for (char c : S.toCharArray()) {
      if (c == 'R') {
        if (openL > 0) {
          openL--;
        } else {
          openR++;
        }
      } else if (c == 'L') {
        if (openR > 0) {
          openR--;
        } else {
          openL++;
        }
      }

      if (openL == 0 && openR == 0) {
        n++;
      }
    }

    return n;
  }

}
