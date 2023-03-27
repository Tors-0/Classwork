package writingClasses;

public class Circle {
    private double radius;
    private double diameter;
    private double centerX;
    private double centerY;
    private static int numCircles;
    /**
     * Constructs a writingClasses.Circle object
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
        numCircles++;
    }

    /**
     * Constructs a writingClasses.Circle object
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
        numCircles++;
    }

    /**
     * Getter for radius
     * Precondition: writingClasses.Circle object must be not null
     * @return double radius for writingClasses.Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Getter for diameter
     * <br>Precondition: writingClasses.Circle object must be not null
     * @return double diameter of writingClasses.Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Getter for area
     * <br>Precondition: writingClasses.Circle object must be not null
     * @return double area of writingClasses.Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getArea() {
        return Math.PI * (radius * radius);
    }

    /**
     * Getter for circumference
     * <br>Precondition: writingClasses.Circle object must be not null
     * @return double circumference of writingClasses.Circle object
     * @author Rae Johnston
     * {@code @date} 2023.01.04
     */
    public double getCircumference() {
        return Math.PI * diameter;
    }

    /**
     * Getter for center coordinates
     * <br>Precondition: writingClasses.Circle object must be not null
     * @return double[] coordinates of writingClasses.Circle object's center
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
     * Getter for edge coordinates of writingClasses.Circle object
     * <br>Precondition: writingClasses.Circle object must be not null
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
     * Deletes the passed writingClasses.Circle object <br>
     * !! NOT WORKING !!
     * @param circle writingClasses.Circle object to be deleted
     */
    public static void delete(Circle circle) {
        circle.centerX = 0;
        circle.centerY = 0;
        circle.radius = 0;
        circle.diameter = 0;
        numCircles--;
        circle = null;
        System.gc();
    }

    /**
     * Gets number of writingClasses.Circle objects
     * @return int number of Circles
     */
    public static int getNumCircles() {
        return numCircles;
    }

    /**
     * Sets radius to a new double value <br>
     * Precondition: value must be greater than 0
     * @param radius double radius
     */
    public void setRadius(double radius) {
        if (radius >= 0) {
            this.radius = radius;
            diameter = radius * 2;
        } else {
            System.out.println("Error at writingClasses.Circle.setRadius.radius: Invalid input, use a number greater than 0");
        }
    }

    /**
     * Sets diameter to a new double value <br>
     * Precondition: value must be greater than 0
     * @param diameter double diameter
     */
    public void setDiameter(double diameter) {
        if (diameter >= 0) {
            this.diameter = diameter;
            radius = diameter / 2;
        } else {
            System.out.println("Error at writingClasses.Circle.setDiameter.diameter: Invalid input, use a number greater than 0");
        }
    }

    /**
     * Changes the center coordinates of the circle
     * @param centerX double coordinate X
     * @param centerY double coordinate Y
     */
    public void setCenter(double centerX, double centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    /**
     * Compares two writingClasses.Circle objects based on area
     * @param other writingClasses.Circle object to compare to
     * @return <0.0 if this is larger than other<br>0.0 if equal<br>>0.0 if this is smaller than other
     */
    public double compareTo(Circle other) {
        return this.getArea() - other.getArea();
    }

    /**
     * Checks two writingClasses.Circle objects based on all params
     * @param other writingClasses.Circle object to compare against
     * @return true / false
     */
    public boolean equals(Circle other) {
        if (this == other) return true;
        if (!(this.radius == other.radius)) {
            return false;
        } else if (!(this.centerX == other.centerX)) {
            return false;
        } else if (!(this.centerY == other.centerY)) {
            return false;
        } else {
            return true;
        }
    }
}