import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number to be parsed: ");
        int num = input.nextInt();
        System.out.println(Functions.modChallengeLoop(num));
    }
}
