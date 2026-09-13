/**
 * Represents a quadratic equation with the form ax^2 + bx + c = 0
 * 
 * @author Marcus Hernandez
 */

public class QuadraticEquation extends Equation {

    /**
     * Creates a quadratic equation of the form ax^2 + bx + c = 0
     * 
     * @param a the coefficient of x squared
     * @param b the coefficient of x
     * @param c the constant term
     */
    public QuadraticEquation(double a, double b, double c) {
        // the array is ordered by power, so the constant c goes in slot 0
        this(new double[] { c, b, a });
    }

    /**
     * Creates a quadratic equation from an array of coefficients
     * coefficients[0] is the constant term, coefficients[1] is the
     * coefficient of x and coefficients[2] is the coefficient of x squared
     * 
     * @param coefficients The coefficients of this equation
     * @throws IllegalArgumentException If there are not exactly 3 coefficients
     */
    public QuadraticEquation(double[] coefficients) {
        super(coefficients);
        if (coefficients.length != 3) {
            throw new IllegalArgumentException("A quadratic equation needs EXACTLY 3 coefficients");
        }
    }

    /**
     * solves ax^2 + bx + c = 0 using the quadratic formula
     * 
     * @return an array of length two holding both of the roots when
     *         the discriminant is positive, OR an array of length one holding
     *         the repeated root when the discriminant is zero.
     * @throws ArithmeticException if the discriminant is negative
     *                             since there are no real roots in that case
     */
    @Override
    public double[] findSolution() {
        double a = coefficients[2];
        double b = coefficients[1];
        double c = coefficients[0];

        // the discriminant tells us how many real roots the equation has!
        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {
            throw new ArithmeticException("This equation has no real solutions!");
        }
        if (discriminant == 0) {
            return new double[] { -b / (2 * a) };
        }

        double root = Math.sqrt(discriminant);
        return new double[] {(-b + root) / (2 * a), (-b - root) / (2 * a)};

    }

  
    /**
     * Builds a readable version of this equationw ith all 3 numbers
     * being rounded to two decimal places
     * @return This equation written out in the form ax^2 + bx + c = 0
     */
    @Override
    public String toString() {
        return String.format("%.2fx\u00b2 + %.2fx + %.2f = 0", 
        coefficients[2], coefficients[1], coefficients[0]);
    }
}
