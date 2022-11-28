import java.lang.Math;

public class MathWrapper {
    public static int gcf(int a,int b) {
        int start = Math.min(a,b);
        for (int i = start; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }
        return 1;
    }
}