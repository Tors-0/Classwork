import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Object> test = new ArrayList<>();
        test.add("hello");
        test.add(54);
        test.add("world!");
        test.add(new int[]{1, 2, 3});
        for (Object o : test) {
            System.out.println(o.toString());
        }
    }
    public static double f(double x) {
        return (3 * x) + 5;
    }
}
