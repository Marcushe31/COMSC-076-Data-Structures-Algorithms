public class Circle extends Shape {
    private double radius;

    public Circle (double x, double y, double radius) {
        super(x,y);
        this.radius = radius;
    }
    
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double calcArea() {
      return (Math.PI * (this.radius * this.radius));      
    }

    public double calcPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    public String toString() {
        return String.format("Circle: %s [radius %.1f]", super.toString(), this.radius);
    }
}