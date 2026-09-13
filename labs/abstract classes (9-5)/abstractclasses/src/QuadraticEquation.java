/**
 * Encapsulates a QuadraticEquation.
 * @author Balaji Srinivasan
 */
public class QuadraticEquation extends Equation {
    /**
     * Creates a quadratic equation (ax^2 + bx + c = 0) with the given coefficients
     * @param a The coefficient of x^2
     * @param b The coefficient of x^1
     * @param c The coefficient of x^0
     */
    public QuadraticEquation(double a, double b, double c) {
        this(new double[] {c, b, a});
    }

    /**
     * Creates a quadratic equation with three coefficients.
     * 
     * @param coeff The coefficients of the equation.
     * @throws IllegalArgumentException if number of coefficients is not 3.
     */
    public QuadraticEquation(double[] coeff) {
        super(coeff);
        if (coeff.length != 3) {
            throw new IllegalArgumentException("QuadraticEquation constructed with " + coeff.length + " coefficients. Expected 3");
        }
    }

    /** 
     * Uses the quadratic formulat to find the roots of the equation.
     * @throws IllegalArgumentException if the equation doesnt have real-roots.
     */
    @Override
    public double[] findSolution() {
        double a = coefficients[2];
        double b = coefficients[1];
        double c = coefficients[0];
        // (-b +/- sqrt(b^2 - 4ac))/2a
        double discriminant = b*b - 4.0 * a * c;
        if (discriminant < 0) {
            throw new IllegalArgumentException("Equation " + toString() + " does not have a solution.");
        }

        double []solutions = new double[2];
        solutions[0] = (-1.0 * b + Math.sqrt(discriminant))/(2*a);
        solutions[1] = (-1.0 * b - Math.sqrt(discriminant))/(2*a);
        if (solutions[0] == solutions[1]) {
            // Its a perfect square. So just return one of the solutions.
            return new double[]{solutions[0]};
        }
        return solutions;
    }

    /**
     * @return string representation of this equation
     */
    @Override
    public String toString() {
        return coefficients[2] + "x\u00b2 " + 
               (coefficients[1] > 0 ? "+ " : "- ") + Math.abs(coefficients[1]) + "x " +
                (coefficients[0] > 0 ? "+ " : "- ") + Math.abs(coefficients[0]);
    }
}
