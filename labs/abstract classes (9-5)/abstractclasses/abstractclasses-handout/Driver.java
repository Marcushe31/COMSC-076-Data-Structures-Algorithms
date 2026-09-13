
import java.util.Arrays;



public class Driver extends DriverBase {
   private static void checkEquation(String testCase, Equation eq, double... expectedSolutions) {
      double[] solutions = eq.findSolution();
      if (solutions.length != expectedSolutions.length) {
         testOutput.put(testCase, "Incorrect number of solutions for equation " + 
                        eq.toString() + ". Expected " +
                        expectedSolutions.length + ", Got " + solutions.length);
         return;
      }
      for (double expectedSolution : expectedSolutions) {
         // Check if solution exists in returned solution.
         int index;
         for (index = 0; index < solutions.length; index++) {
            if (expectedSolution == solutions[index]) {
               break;
            }
         }
         if (index >= solutions.length) {
            // Did not find the solution.
            testOutput.put(testCase, "Did not find expected solution " + expectedSolution + 
                           " in " + Arrays.toString(solutions) + " for equation " + eq.toString());
            return;
         }
      }
      testOutput.put(testCase, null);
   }

   public static void main(String[] args) {
      // Create a linear equation with wrong number of coefficients
      checkThrowsException("LinearEquation with wrong number of coefficients (3)", () -> new LinearEquation(new double[3]));;
      checkThrowsException("LinearEquation with wrong number of coefficients (1)", () -> new LinearEquation(new double[1]));;
      // Create a linear equation with the non-array constructor. Solve and check results
      checkDoesNotThrowException("LinearEquation with non-array constructor", () -> {
         Equation eq = new LinearEquation(2, 3);
         checkEquation("LinearEquation with non-array constructor", eq, -1.5);
      });

      // Create a linear equation with the array version of constructor. Solve and check results
      checkDoesNotThrowException("LinearEquation with array constructor", () -> {
         Equation eq = new LinearEquation(new double[] {3, 2});
         checkEquation("Linear equation with array constructor", eq, -1.5);
      });
      // Create a quadratic equation with wrong number of coefficients.
      checkThrowsException("QuadraticEquation with wrong number of coefficients (4)", () -> new QuadraticEquation(new double[4]));;
      checkThrowsException("QuadraticEquation with wrong number of coefficients (2)", () -> new QuadraticEquation(new double[2]));;
      // Create a quadratic equation with the non-array constructor. Solve and check results
      checkDoesNotThrowException("QuadraticEquation with non-array constructor", () -> {
         Equation eq = new QuadraticEquation(1, 5, 6);
         checkEquation("QuadraticEquation with non-array constructor", eq, -2, -3);
      });
      // Create a quadratic equation with array constructor. Solve and check results
      checkDoesNotThrowException("QuadraticEquation with array constructor", () -> {
         Equation eq = new QuadraticEquation(new double[]{6, 5, 1});
         checkEquation("QuadraticEquation with array constructor", eq, -2, -3);
      });
      // Create a quadratic equation that has imaginary roots only and check it throws exception
      checkThrowsException("QuadraticEquation with imaginary roots throws exception", () -> {
         Equation eq = new QuadraticEquation(new double[]{12, 5, 1});
         eq.findSolution();
      });
      // Create a perfect square (should get only one root)
      checkDoesNotThrowException("QuadraticEquation of a perfect square", () -> {
         Equation eq = new QuadraticEquation(new double[]{4, -4, 1});
         checkEquation("QuadraticEquation of a perfect square", eq, 2);
      });

      printJsonOutput();
   }
}
