public class Driver extends DriverBase {
   public static void main(String[] args) {
      // 1. Construct an invalid rectangle with 0 sides
      checkThrowsException("Rectangle with 0 width/height", () -> new Rectangle(0, 0));
      // 2. Construct an invalid rectangle with negative width
      checkThrowsException("Rectangle with negative width", () -> new Rectangle(-1, 10));
      // 3. Construct an invalid rectangle with negative height
      checkThrowsException("Rectangle with negative height", () -> new Rectangle(1, -10));
      // 4. Construct a valid rectangle and getArea and getPerimeter
      checkDoesNotThrowException("Rectangle area/perimeter", () -> {
         Rectangle rect = new Rectangle(2, 3);
         if (rect.getArea() != 6) {
            testOutput.put("Rectangle area/perimeter", "Area incorrect");
         } else if (rect.getPerimeter() != 10) {
            testOutput.put("Rectangle area/perimeter", "Perimeter incorrect");
         } else {
            testOutput.put("Rectangle area/perimeter", null);
         }
      });

      // 5. Construct an invalid triangle with negative sides
      checkThrowsException("Triangle with negative sides", () -> new Triangle(-10, 10, 10));

      // 6. Construct an invalid triangle with 0 sides.
      checkThrowsException("Triangle with 0 sides", () -> new Triangle(0, 10, 10));

      // 7. Construct an invalid triangle that two sides dont add up to > than third
      // side
      checkThrowsException("Triangle with invalid sides", () -> new Triangle(10, 2, 3));

      // 8. Construct a isoceles triangle with getArea and Perimeter
      Triangle triangle = new Triangle(2, 3, 4);
      checkDoesNotThrowException("Triangle area/perimeter", () -> {
         if ((triangle.getArea() < 2.904) || (triangle.getArea() > 2.905)) {
            testOutput.put("Triangle area/perimeter", "Area incorrect" + triangle.getArea());
         } else if (triangle.getPerimeter() != 9) {
            testOutput.put("Triangle area/perimeter", "Perimeter incorrect");
         } else {
            testOutput.put("Triangle area/perimeter", null);
         }
      });

      // 9. Construct an invalid circle with 0 radius
      checkThrowsException("Circle with 0 radius", () -> new Circle(0));
      // 10. Construct an invalid circle with negative radius
      checkThrowsException("Circle with negative radius", () -> new Circle(-10));
      // 11. Construct a valid circle and check area and perimeter
      checkDoesNotThrowException("Circle area/perimeter", () -> {
         Circle circle = new Circle(10);
         if (circle.getArea() != Math.PI * 10 * 10) {
            testOutput.put("Circle area/perimeter", "Area incorrect");
         } else if (circle.getPerimeter() != 2 * Math.PI * 10) {
            testOutput.put("Circle area/perimeter", "Perimeter incorrect");
         } else {
            testOutput.put("Circle area/perimeter", null);
         }
      });

      printJsonOutput();
   }
}
