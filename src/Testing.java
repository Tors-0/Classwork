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
        String str = "a";
        boolean isVowel;
        switch (str) {
            case "a","e","i","o","u":
                isVowel = true;
                break;
            default:
                isVowel = false;
                break;
        }
        System.out.println(isVowel);
    }
    public static double f(double x) {
        return (3 * x) + 5;
    }
}
