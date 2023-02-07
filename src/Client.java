public class Client {
    public static void main(String[] args) {
        Circle circla = new Circle(8);
        Circle circlb = new Circle(4);
        Circle circlc = new Circle(9);
        Circle circld = new Circle(10);
        Circle circle = new Circle(6);
        Circle[] circles = {circla,circlb,circlc,circld,circle};
        // array traversal (find max (area))
        Circle max = circles[0];
        for (int i = 0; i < circles.length; i++) {
            if (circles[i].compareTo(max) > 0) {
                max = circles[i];
            }
        }
        System.out.println("The largest circle has the following properties:\n" + max);
    }
}
