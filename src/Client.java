public class Client {
    public static void main(String[] args) {
        Circle alpha = new Circle(5);
        Circle beta = new Circle(8);
        System.out.println(alpha.compareTo(beta)); // -122.52211349000193
        System.out.println(alpha.equals(beta)); // false
        alpha.setRadius(9);
        System.out.println(alpha.compareTo(beta)); // 53.40707511102647
        System.out.println(alpha.equals(beta)); // false
        beta.setRadius(9);
        System.out.println(alpha.compareTo(beta)); // 0.0
        System.out.println(alpha.equals(beta)); // true
        alpha.setCenter(4,5);
        System.out.println(alpha.compareTo(beta)); // 0.0
        System.out.println(alpha.equals(beta)); // false
    }
}
