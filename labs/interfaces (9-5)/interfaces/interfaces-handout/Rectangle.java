/**
 * represents a rectangle with width and height
 * @author Marcus Hernandez
 */

public class Rectangle implements GeometricObject {
    private double width;
    private double height;

    /**
     *  Creates a rectangle with the width and height
     * @param width the width of the rectangle
     * @param height the height of the rectangle
     * @throws RuntimeException if width or height isn't positive
     * 
     */

    public Rectangle(double width, double height) {
        // a side of 0 or less is NOT a real rectangle
        if (width <= 0 || height <= 0) {
            throw new RuntimeException("Width and height must both be greater than 0!");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * find the area of the rectangle
     * @return the area of the rectangle (width times height)
     */
    @Override
    public double getArea() {
        return width * height;
    }

    /**
     * find the perimeter of the rectangle
     * @return the perimeter of the rectangle (2 times width plus 2 times height)
     */
    @Override
    public double getPerimeter() {
        return 2 * width + 2 * height;
    }

    /**
     * creates a readable version of this rectangle with both numbers
     * being rounded to two decimal places
     * @return the rectangle written out with its width and height
     */
    @Override
    public String toString() {
        return String.format("Rectangle with width %.2f and height %.2f", width, height);
    }
}