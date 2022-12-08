public class YoDawgIHeardYouLikeLoops {
    public static void main(String[] args) {
        blocks();
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
    public static void blocks() {
        for (int x = 0; x < 3; x++) { // traverses x rows
            for (int y = 0; y < 3; y++) { // traverses y rows
                for (int z = 0; z < 3; z++) { // traverses z (vertical) columns
                    System.out.print("" + x + "," + y + "," + z + "\t"); // place block at x y z
                }
                System.out.println();
            }
            System.out.println();
        }
    }

}
