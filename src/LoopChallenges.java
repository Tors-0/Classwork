import java.util.Scanner;

public class LoopChallenges {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print(fourthChallenge(3290,-1));
    }
    public static void firstChallenge() {
        String joke = "repeat";
        while (joke.equalsIgnoreCase("repeat")) {
            System.out.print("Pete and Repeat are sitting on a bridge. Pete falls off, who's left? : ");
            joke = input.nextLine();
        }
    }
    public static int secondChallenge(int n) {
        int output = 0;
        int count = 1;
        if (n >= 1) {
            while (n >= count) {
                output += count;
                count++;
            }
        } else {
            System.out.println("number greater than or equal to 1 pls");
        }
        return output;
    }
    public static void thirdChallenge(String s) {
        int i = 0;
        while (i < s.length()) {
            System.out.println(s.charAt(i));
            i++;
        }
    }
    public static boolean fourthChallenge(int pin, int score) {
        int pinSum = 0;
        String pinn = String.valueOf(pin);
        int x;
        int i = 0;
        while (i < pinn.length()) {
            x = Integer.parseInt("" + pinn.charAt(i));
            if (x % 2 == 0) {
                pinSum += x;
            } else {
                pinSum += x * 2;
            }
            i++;
        }
        if (pinSum == score) {
            return true;
        } else {
            return false;
        }
    }
    public static int intLength(int n) {
        int count = 0;
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }
}
