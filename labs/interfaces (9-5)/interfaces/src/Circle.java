public class Circle implements GeometricObject {
    private double radius;

    public Circle(double radius) {
	if (radius <=0) {
		throw new RuntimeException("Invalid circle.");
        }
	this.radius = radius;
    }

    public double getPerimeter() {
	return 2*Math.PI*radius;
    }

    public double getArea() {
	return Math.PI * radius * radius;
    }
}
