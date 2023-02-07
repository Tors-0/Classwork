import org.jetbrains.annotations.NotNull;

public class Sphere {
    private final double radius;
    private final double diameter;
    public Sphere(double theRadius) {
        radius = theRadius;
        diameter = theRadius * 2;
    }
    public Sphere(@NotNull Circle c) {
        radius = c.getRadius();
        diameter = c.getDiameter();
    }
    public double getDiameter() {
        return diameter;
    }
    public double getRadius() {
        return radius;
    }
    public double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(radius,2);
    }
    public double getVolume() {
        return (4/3) * Math.PI * Math.pow(radius,3);
    }
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
