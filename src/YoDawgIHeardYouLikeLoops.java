public class YoDawgIHeardYouLikeLoops {
    public static void main(String[] args) {
        starTriangle();
    }
    public static void numberTriangle() {
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void numberSquare() {
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void starTriangle() {
        for (int i = 1; i < 6; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
