import java.util.Scanner;

public class Testing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to be parsed: ");
        long number = Long.parseLong(input.nextLine());
        System.out.println(Functions.modChallengeLoop(number));
    }
}
