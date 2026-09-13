/**
 * Represents a linear equation that has the form of ax + b = 0
 * @author Marcus Hernandez
 */
public class LinearEquation extends Equation {
    /**
     * Creates a linear equation with the given coefficients
     * @param a The coefficient of the x term
     * @param b The constant term
     */
    public LinearEquation(double a, double b) {
        // The array is ordered by power, which means that the constant b goes into slot 0.
        this(new double[] {b, a});
    }

    /**
     * Creates a linear equation with two coefficients
     * coefficients[0] is the constant term and coefficients[1] is the
     * coefficient of x.
     * @param coefficients The coefficients of this equation
     * @throws IllegalArgumentException if there aren't exactly 2 coefficieints
     */
    public LinearEquation(double[] coefficients) {
        super(coefficients);
        if (coefficients.length!= 2){
            throw new IllegalArgumentException("coefficient length must be 2!");
        }
    }

   
    /**
     * Solves ax + b = 0 for x
     * @return an array holding the SINGLE solution, as a linear
     * equation will always have exactly one root
     */
    @Override
    public double[] findSolution() {
            double a = coefficients[1];
            double b = coefficients[0];
            return new double[] {-b / a};
        }

  
    /**
     * builds a readable version of this equation with both numbers
     * being rounded to two decimal places
     * @return This equation written out in the form ax + b = 0
     */
    @Override
    public String toString() {
        return String.format("%.2fx + %.2f = 0", coefficients[1], coefficients[0]);
    }
}