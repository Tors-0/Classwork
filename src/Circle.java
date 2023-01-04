public class Circle {
    private final double radius;
    private final double diameter;
    public Circle(double theRadius) {
        radius = theRadius;
        diameter = theRadius * 2;
    }
    public double getRadius() {
        return radius;
    }
    public double getDiameter() {
        return diameter;
    }
    public double getArea() {
        return Math.PI * (radius * radius);
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}