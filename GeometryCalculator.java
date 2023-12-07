package Math;

public class GeometryCalculator {
    public static double calculateSquareArea(double side) {
        return side * side;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculateTriangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    public static void main(String[] args) {
   
        double side = 5.0;
        double length = 4.0;
        double width = 3.0;
        double radius = 6.0;
        double base = 7.0;
        double height = 8.0;

        
        double squareArea = calculateSquareArea(side);
        double rectangleArea = calculateRectangleArea(length, width);
        double circleArea = calculateCircleArea(radius);
        double triangleArea = calculateTriangleArea(base, height);

        
        System.out.println("Square Area: " + squareArea);
        System.out.println("Rectangle Area: " + rectangleArea);
        System.out.println("Circle Area: " + circleArea);
        System.out.println("Triangle Area: " + triangleArea);
    }
}

