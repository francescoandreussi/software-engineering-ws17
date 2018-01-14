// minimal Assertion handler example, based on https://github.com/junit-team/junit4/blob/master/src/main/java/org/junit/Assert.java

package TinyTestJ;

public class Assert {

  protected Assert() {} // protect constructor since it is a static only class

  // assertXYZ methods

  public static void assertEquals(String message, double expected, double actual, double delta) {
    if (doubleIsDifferent(expected, actual, delta)) {
      failNotEquals(message, Double.valueOf(expected), Double.valueOf(actual));
    }
  }

  public static void assertEquals(double expected, double actual, double delta) {
     assertEquals(null, expected, actual, delta);
  }

  // helper methods to format strings etc.

  public static void fail(String message) {
    if (message == null) {
      throw new AssertionError();
    }
    throw new AssertionError(message);
  }

  public static void fail() {
    fail(null);
  }

  static String format(String message, Object expected, Object actual) {
    String formatted = "";
    if (message != null && !"".equals(message)) {
      formatted = message + " ";
    }
    String expectedString = String.valueOf(expected);
    String actualString = String.valueOf(actual);
    if (equalsRegardingNull(expectedString, actualString)) {
      return formatted + "expected: "
             + formatClassAndValue(expected, expectedString)
             + " but was: " + formatClassAndValue(actual, actualString);
    } else {
      return formatted + "expected: <" + expectedString + "> but was: <"
             + actualString + ">";
    }
  }

  private static String formatClass(Class<?> value) {
    String className = value.getCanonicalName();
    return className == null ? value.getName() : className;
  }

  private static String formatClassAndValue(Object value, String valueString) {
    String className = value == null ? "null" : value.getClass().getName();
    return className + "<" + valueString + ">";
  }

  private static boolean equalsRegardingNull(Object expected, Object actual) {
    if (expected == null) {
      return actual == null;
    }
    return isEquals(expected, actual);
  }

  private static boolean isEquals(Object expected, Object actual) {
    return expected.equals(actual);
  }

  private static void failEquals(String message, Object actual) {
    String formatted = "Values should be different. ";
    if (message != null) {
      formatted = message + ". ";
    }
    formatted += "Actual: " + actual;
    fail(formatted);
  }

  private static void failNotEquals(String message, Object expected, Object actual) {
    fail(format(message, expected, actual));
  }
  
  private static boolean doubleIsDifferent(double d1, double d2, double delta) {
    if (Double.compare(d1, d2) == 0) {
      return false;
    }
    if ((Math.abs(d1 - d2) <= delta)) {
      return false;
    }
    return true;
  }

}
