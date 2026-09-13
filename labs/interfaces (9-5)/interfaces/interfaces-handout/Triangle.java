/**
 * represents a triangle that is built out of its 3 side lengths
 * @author Marcus Hernandez
 */

public class Triangle implements GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    /**
     * creates a triangle with the 3 given sides
     * @param side1 the length of the first side of the triangle
     * @param side2 the length of the second side of the triangle
     * @param side3 the length of the third side of the triangle
     * @throws RuntimeException if any of the sides are less than or equal to 0
     */

    public Triangle(double side1, double side2, double side3) {
        if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
            throw new RuntimeException("All sides must be greater than 0!");
        }
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new RuntimeException("These 3 sides do NOT make a triangle!");
        }
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * finds the area of this triangle 
     * @return the area of the triangle
     */

    @Override
    public double getArea() {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }

    /**
     * finds the perimeter of this triangle
     * @return the perimeter of the triangle
     */
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    /**
     * creates a readable version of this triangle
     * @return the triangle with its 3 sides
     */

    @Override
    public String toString() {
        return String.format("Triangle with sides %.2f, %.2f, and %.2f", side1, side2, side3);
    }
}