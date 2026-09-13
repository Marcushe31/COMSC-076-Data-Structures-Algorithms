/**
 * Abstract base class that represents an equation.
 * @author Balaji Srinivasan
 */
abstract class Equation {
    double[] coefficients;
    
    /**
     * Creates an equation with the given coefficients. The number of
     * coefficients decides the degree of this equation (ie. 2 coefficients =
     * linear equation, 3 coefficients = quadratic equation. And coefficient[0]
     * is the coefficient of x^0. coefficient[1] is the coefficient of x^1 etc.)
     *
     * @param coefficients The coefficients of this equation.
     */
    public Equation(double[] coefficients) {
        this.coefficients = coefficients;
    }

    /**
     * Finds the solution to the equation.
     *
     * @return An array of values that are the solutions to the equation.
     * Returns null if there are no solutions.
     */
    public abstract double[] findSolution();
}
