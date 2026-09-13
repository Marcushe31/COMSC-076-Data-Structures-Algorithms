/**
 * A class that encapsulates a LinearEquation.
 * @author Balaji Srinivasan
 */
public class LinearEquation extends Equation {
    /**
     * Creates a linear equation with the given coefficients
     * @param a The coefficient of x^1.
     * @param b The constant in the equation.
     */
    public LinearEquation(double a, double b) {
        this(new double[] {b, a});
    }

    /**
     * Creates a linear equation with two coefficients.
     * 
     * @param coeff The coefficients of this linear equation.
     * @throws IllegalArgumentException if the number of coefficients is not 2.
     */
    public LinearEquation(double[] coeff) throws IllegalArgumentException {
        super(coeff);   
        if (coeff.length != 2) {
            throw new IllegalArgumentException("Number of coefficients = " + coeff.length + ". Should be 2");
        }
    }

    /**
     * Finds the solution for the linear equation.
     * @return An array of 1 element with the solution.
     */
    @Override
    public double[] findSolution() {
        double []solution = new double[1];
        solution[0] = -1.0 * coefficients[0] / coefficients[1];
        return solution;
    }

    /**
     * @return string representation of this equation
     */
    @Override
    public String toString() {
        return coefficients[1] + "x + " + coefficients[0];
    }
}