package utils;

public class JavaHelpers {

  /**
   * Tests an expression, throwing an `IllegalArgumentException` if false. This method is taken from
   * Scala and blames the caller of the method for violating the condition.
   *
   * @param requirement the expression to test
   */
  public static void require(boolean requirement) {
    require(requirement, "requirement failed");
  }

  /**
   * Tests an expression, throwing an `IllegalArgumentException` if false. This method is taken from
   * Scala and blames the caller of the method for violating the condition.
   *
   * @param requirement the expression to test
   * @param message a String to include in the failure message
   */
  public static void require(boolean requirement, String message) {
    if (!requirement) {
      throw new IllegalArgumentException("requirement failed: " + message);
    }
  }

}
