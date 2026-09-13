public class Triangle implements GeometricObject {
    private double one, two, three;

    public Triangle(double one, double two, double three) {
	if ((one <=0) || (two <= 0) || (three <= 0) ||
             (one + two <= three) || (one + three <= two) || (two + three <= one)) {
		throw new RuntimeException("Invalid triangle");
	}

	this.one = one;
	this.two = two;
        this.three = three;
    }

    public double getPerimeter() {
	return one + two + three;
    }

    public double getArea() {
	double s = getPerimeter() / 2;
 	return Math.sqrt(s * (s - one) * (s - two) * (s - three));
    }
}
