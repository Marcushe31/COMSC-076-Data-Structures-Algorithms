public class ShapeExample {
    public static void main(String[] args) {
        Shape[] shapeList = {
            new Circle(3.0,4.0,1.5),
            new Rectangle(1.5, 2.5, 4.7, 8.3)
        };
        for (Shape s: shapeList) {
            System.out.printf("%s area: %.2f perimeter: %.2f%n", 
                s, s.calcArea(), s.calcPerimeter())
        }
    }
}