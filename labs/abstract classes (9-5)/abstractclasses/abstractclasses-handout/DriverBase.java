import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DriverBase {

   static LinkedHashMap<String, String> testOutput = new LinkedHashMap<>();
   static LinkedHashMap<String, String> extraCredit = new LinkedHashMap<>();
   static String currentTestCase;

   static void setCurrentTestCase(String testCase) {
      currentTestCase = testCase;
   }

   @FunctionalInterface
   public interface ThrowingConsumer<E extends Exception> {
      void accept() throws E;
   }

   static <T> Runnable throwingConsumerWrapper(
         ThrowingConsumer<Exception> throwingConsumer) {

      return () -> {
         try {
            throwingConsumer.accept();
         } catch (Exception ex) {
            throw new RuntimeException(ex);
         }
      };
   }

   static void checkThrowsException(Runnable r) {
      checkThrowsException(testOutput, currentTestCase, r);
   }
   static void checkThrowsException(String testCase, Runnable r) {
      checkThrowsException(testOutput, testCase, r);
   }

   static void checkThrowsException(Map<String, String> output, String testCase, Runnable r) {
      try {
         output.put(testCase, "Should throw exception.");
         r.run();
      } catch (Exception re) {
         output.put(testCase, null);
      }
   }

   static void checkDoesNotThrowException(String testCase, Runnable r) {
      checkDoesNotThrowException(testOutput, testCase, r);
   }

   static void checkDoesNotThrowException(Map<String, String> output, String testCase, Runnable r) {
      try {
	 output.put(testCase, null);
         r.run();
      } catch (Exception re) {
	      re.printStackTrace();
         output.put(testCase, "Threw an exception " + re);
      }
   }

   static void checkDoesNotThrowException(Runnable r) {
      checkDoesNotThrowException(currentTestCase, r);
   }

   static void checkListContents(String testCase, List list, Object... args) {
      checkListContents(testOutput, testCase, list, args);
   }

   static void checkListContents(List list, Object... args) {
      checkListContents(currentTestCase, list, args);
   }

   static void checkListContents(Map<String, String> output, String testCase, List list, Object... args) {
      int index = 0;
      if (list.size() != args.length) {
         output.put(testCase, "Expected size " + args.length + ", Got " + list.size());
         return;
      }
      for (Object o : list) {
         if (!o.equals(args[index])) {
            StringBuffer buff = new StringBuffer("Expected [");
            for (Object toPrint : args) {
               buff.append(toPrint.toString());
               buff.append(", ");
            }
            buff.append("]. Got [");
            for (Object toPrint : list) {
               buff.append(toPrint.toString());
               buff.append(", ");
            }
            buff.append("] at index " + index);
            buff.append(". Actual Value: " + o + ", Expected value: " + args[index]);
            output.put(testCase, buff.toString());
            return;
         }
         index++;
      }
      output.put(testCase, null);
   }

   /**
    * Sets the result of the current test to be the passed in value.
    * Pass in hint as null if you want to mark it successful.
    */
   static void setTestResult(String hint) {
      testOutput.put(currentTestCase, hint);
   }

   /**
    * Prints the json output for the given map.
    * 
    * @param testOutput
    * @return The number of failed tests.
    */
   static final int printMap(Map<String, String> testOutput, StringBuffer buffer, String tag) {
      int failedTests = 0;
      buffer.append("\t\"");
      buffer.append(tag + "\" : {\n");
      for (Map.Entry<String, String> entry : testOutput.entrySet()) {
         buffer.append("\t\t\"").append(entry.getKey()).append("\": {\n");
         buffer.append("\t\t\t\"passed\": ").append(entry.getValue() == null ? "true" : "false").append("\n");
         if (entry.getValue() != null) {
            failedTests++;
            buffer.append("\t\t\t\"hint\": \"").append(entry.getValue()).append("\"\n");
         }
         buffer.append("\t\t}\n");
      }
      buffer.append("\t}\n");
      return failedTests;
   }

   /**
    * Prints the json output for the autograder
    */
   static final void printJsonOutput() {
      int numTests = testOutput.size();
      int numExtraTests = extraCredit.size();
      StringBuffer buffer = new StringBuffer();
      buffer.append("{\n");
      int failedTests = printMap(testOutput, buffer, "Test");
      int failedExtraTests = 0;
      if (numExtraTests != 0) {
         failedExtraTests = printMap(extraCredit, buffer, "ExtraCredit");
      }
      buffer.append("}\n");
      buffer.append("{");
      buffer.append("\"scores\": {");
      buffer.append("\"Correctness\":").append((double) (numTests - failedTests) / numTests * 100);
      if (numExtraTests != 0) {
         buffer.append(",")
            .append(" \"ExtraCredit\":").append((double) (numExtraTests - failedExtraTests) / numExtraTests * 100);
      }
      buffer.append("} }");
      System.out.println(buffer.toString());
   }
}
