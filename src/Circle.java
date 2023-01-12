public class Circle {
    private double radius;
    private double diameter;
    private double centerX;
    private double centerY;
    /**
     * Constructs a Circle object
     * Precondition: radius must be a non-negative value
     * Postcondition: every instance variable has a non-null value
     * @param radius double to initialize instance variable radius
     * @param centerX double to initialize instance variable centerX
     * @param centerY double to initialize instance variable centerY
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public Circle(double radius, double centerX, double centerY) {
        this.radius = radius;
        diameter = radius * 2;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Constructs a Circle object
     * <br>Precondition: radius must be a non-negative value
     * <br>Postcondition: every instance variable has a non-null value, center coordinates default to 0,0
     * @param radius double to initialize instance variable radius
     * @author Rae Johnston
     * {@code @Date} 2023.01.04
     */
    public Circle(double radius) {
        this.radius = radius;
        diameter = radius * 2;
        centerX = 0;
        centerY = 0;
    }

    /**
     * Getter for radius
     * Precondition: Circle object must be not null
     * @return double radius for Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Getter for diameter
     * <br>Precondition: Circle object must be not null
     * @return double diameter of Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Getter for area
     * <br>Precondition: Circle object must be not null
     * @return double area of Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    /**
     * Getter for circumference
     * <br>Precondition: Circle object must be not null
     * @return double circumference of Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Getter for center coordinates
     * <br>Precondition: Circle object must be not null
     * @return double[] coordinates of Circle object's center
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double[] getCenter() {
        double[] out = new double[2];
        out[0] = centerX;
        out[1] = centerY;
        return out;
    }

    /**
     * Getter for edge coordinates of Circle object
     * <br>Precondition: Circle object must be not null
     * @param radians should be double from 0 to 2 * PI
     * @return double[] coordinates at given angle
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double[] coordsOfAngle(double radians) { // assumes top right quadrant is x+,y+
        double[] out = new double[2];
        out[0] = radius * Math.cos(radians);
        out[1] = radius * Math.sin(radians);
        out[0] += centerX;
        out[1] += centerY;
        return out;
    }

    /**
     * Returns a string representation of a circle
     * @return String "This circle has a center at X, Y a radius of R and a diameter of D
     */
    public String toString() {
        return "This circle has a center at " + centerX + ", " + centerY + " a radius of " + radius + " and a diameter of " + diameter;
    }

    /**
     * Deletes the passed Circle object
     * @param circle Circle object to be deleted
     */
    public static void delete(Circle circle) {
        circle = null;
        System.gc();
    }


}