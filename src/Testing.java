import java.util.Scanner;

public class Testing {
    static Scanner input = new Scanner(System.in);
    public static boolean array123(int[] nums) {
        for (int i = 0; i < (nums.length - 2); i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        double start = 2;
        double end = 5;
        int n = 100000;
        double total = 0;
        double width = (end - start) / n;
        for (double i = start; i <= end; i += width) {
            total += width * f(i);
        }
        System.out.println(total);
    }
    public static double f(double x) {
        return (3 * x) + 5;
    }
}
