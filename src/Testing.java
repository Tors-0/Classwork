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
        int i = input.nextInt();
        String output;
        if (i == 1) output = "beef";
        else if (i == 2) output = "chicken";
        else if (i == 3) output = "pasta";
        else output = "fish";
        System.out.println(output);
    }
}
