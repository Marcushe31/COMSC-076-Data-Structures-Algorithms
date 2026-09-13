/**
 * represents a circle with a given radius
 * @author Marcus Hernandez
 */

public class Circle implements GeometricObject {
    private double radius;

    /**
     * Creates a circle using the radius
     * 
     * @param radius the radius of the circle
     * @throws RuntimeException if radius isn't positive
     */
    public Circle(double radius) {
        if (radius <= 0) {
            throw new RuntimeException("The radius must be greater than0!");
        }
        this.radius = radius;
    }

    /**
     * finds the area of this circle using pi times the radius squared
     * @return the area of the circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
}
    /**
     * find the permieter of this circle (which is really just the circumference)
     * @return the perimeter of the circle
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    /**
     * creates a version of this circle that is readable and 
     * the radius is rounded to two decimal places
     * @return the circle written out with its radius
     */
    @Override
    public String toString() {
        return String.format("Circle with radius: %.2f", radius);
    }
}