package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class RecentlyAccessedLog {

  static List<String> recentlyAccessedLog(List<String> eids, int buffer_size) {

    HashSet<String> seen = new HashSet<>(eids.size());

    List<String> recentlyAccessed = new ArrayList<>(buffer_size);
    int cnt = 0;

    List<String> invalidOutput = new ArrayList<>(1);
    invalidOutput.add("Not Allowed");
    boolean isInvalid = false;

    for (int i = eids.size() - 1; i >= 0; i--) {
      String eid = eids.get(i);

      if (eid == null || eid.length() == 0) {
        isInvalid = true;
      }

      if (!seen.contains(eid) && cnt < buffer_size) {
        recentlyAccessed.add(eid);
        cnt++;
      }

      seen.add(eid);
    }

    if (isInvalid) {
      return invalidOutput;
    } else {
      return recentlyAccessed;
    }
  }

  public static void main(String[] args) {
    System.out.println(recentlyAccessedLog(Arrays.asList("Erika"), 1));
  }

}
