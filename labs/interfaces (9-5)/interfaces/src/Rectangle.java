public class Rectangle implements GeometricObject {
    private double width, height;

    public Rectangle(double width, double height) {
	if (width <=0 || height <= 0) {
		throw new RuntimeException("Invalid rectangle.");
        }
	this.width = width;
	this.height = height;
    }

    public double getPerimeter() {
	return 2*width + 2*height;
    }

    public double getArea() {
	return width*height;
    }
}
