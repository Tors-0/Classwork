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
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
        System.out.print((int) ((Math.random() * 3) + 1));
    }
}
