

public class Driver extends DriverBase {
   public static void checkDuration(String testCase, Duration d, int hours, int minutes) {
      if (d.getHours() != hours) {
         testOutput.put(testCase, "Duration.getHours() " + d.getHours() + " != " + hours);
      } else if (d.getMinutes() != minutes) {
         testOutput.put(testCase, "Duration.getMinutes() " + d.getMinutes() + " != " + minutes);
      } else {
         // Check toString.
         String result = String.format("%02d:%02d", hours, minutes);
         if (!result.equals(d.toString())) {
            testOutput.put(testCase, "toString returned " + d.toString() + " instead of " + result);
         } else {
            // Success.
            testOutput.put(testCase, null);
         }
      }
   }

   public static void main(String[] args) {
      // Create a Duration with no-arg constructor and check hours and minutes.
      checkDoesNotThrowException("Default Constructor", () -> {
         Duration d = new Duration();
         checkDuration("Default constructor", d, 0, 0);
      });

      // Create an Duration with invalid hours
      checkThrowsException("Creating duration with negative hours", () -> new Duration(-1, 0));

      // Create a Duration with negative minutes
      checkThrowsException("Creating duration with negative minutes", () -> new Duration(0, -1));

      // Create a Duration with minutes > 59
      checkThrowsException("Creating duration with minutes > 59", () -> new Duration(0, 60));

      // Create a valid Duration and check hours and minutes
      final Duration d2 = new Duration(100, 20);
      checkDuration("Valid duration", d2, 100, 20);
   
      // Try to set negative hours
      checkThrowsException("Calling setHours with negative hours", () -> d2.setHours(-1));
      
      // Try to set negative minutes
      checkThrowsException("Calling setHours with negative minutes", () -> d2.setMinutes(-1));

      // Try to set minutes > 59
      checkThrowsException("Calling setHours with minutes > 59", () -> d2.setMinutes(60));

      // Set valid hours and check get and check toString
      d2.setHours(12);
      d2.setMinutes(25);
      checkDuration("Setting hours and minutes", d2, 12, 25);

      // Check fromString with 0 :
      checkThrowsException("fromString with no colons", () -> {
         Duration.fromString("0234");
      });
      // Check fromString with 3 :
      checkThrowsException("fromString with 2 colons", () -> {
         Duration.fromString("0:1:2");
      });
      // Check fromString with negative hours
      checkThrowsException("fromString with negative hours", () -> {
         Duration.fromString("-1:10");
      });
      // Check fromString with negative minutes
      checkThrowsException("fromString with negative minutes", () -> {
         Duration.fromString("0:-10");
      });
      // Check fromString with minutes >59
      checkThrowsException("fromString with minutes > 59", () -> {
         Duration.fromString("0:60");
      });
      // Check fromString with alphanumeric characters.
      checkThrowsException("fromString with alpha-numeric string", () -> {
         Duration.fromString("aa:bb");
      });
      // Check fromString with valid values.
      checkDoesNotThrowException("fromString with valid value", () -> {
         Duration d = Duration.fromString("10:20");
         checkDuration("fromString with valid value", d, 10, 20);
      });
      // Add a duration and check values
      checkDoesNotThrowException("Adding a duration", () -> {
         Duration d1 = new Duration(10, 20);
         d1.add(new Duration(20, 30));
         checkDuration("Adding a duration", d1, 30, 50);
      });

      // Add a duration where minutes wraps around and increments thehours.
      checkDoesNotThrowException("Adding a duration", () -> {
         Duration d1 = new Duration(10, 20);
         d1.add(new Duration(20, 40));
         checkDuration("Adding a duration that wraps around", d1, 31, 0);
      });

      printJsonOutput();
   }
}
