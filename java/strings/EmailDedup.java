package strings;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @Google
 */
public class EmailDedup {

  public static int dedup(String[] emails) {

    HashMap<String, Integer> deDupEmails = new HashMap<>(emails.length);

    for (String email : emails) {
      String localAddress = email.split("@")[0];
      String baseLocalEmail = localAddress.split("\\+")[0].replaceAll("\\.", "");
      String baseEmail = baseLocalEmail + "@" + email.split("@")[1];

      deDupEmails.putIfAbsent(baseEmail, 0);
      deDupEmails.put(baseEmail, deDupEmails.computeIfPresent(baseEmail, (s, integer) -> integer + 1));
    }

    int count = 0;
    for (Entry<String, Integer> stringIntegerEntry : deDupEmails.entrySet()) {
      if (stringIntegerEntry.getValue() > 1) {
        count++;
      }
    }

    return count;
  }

  public static void main(String[] args) {
    String[] emails = {"a.b@example.com", "ab+1@example.com", "ab@exam.ple.com"};
    System.out.println(dedup(emails));
  }

}
