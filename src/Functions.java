import java.util.Scanner;

public class Functions {
    public static String modChallenge(int num) {
        int a = num % 10;
        int b = num % 100 - a;
        int c = num % 1000 - a - b;
        int d = num % 10000 - a - b - c;
        b /= 10;
        c /= 100;
        d /= 1000;
        return("First: " + d + "\nSecond: " + c + "\nThird: " + b + "\nFourth: " + a);
    }
    public static String modChallengeLoop(long num) {
        String output = "";
        long step;
        int stepNum = 1;
        while (num > 0) {
            if (stepNum == 11) {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "th: " + step + output;
                stepNum++;
            } else if (stepNum == 12) {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "th: " + step + output;
                stepNum++;
            } else if (stepNum == 13) {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "th: " + step + output;
                stepNum++;
            } else if (stepNum % 10 == 1) {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "st: " + step + output;
                stepNum++;
            } else if (stepNum % 10 == 2) {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "nd: " + step + output;
                stepNum++;
            } else if (stepNum % 10 == 3) {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "rd: " + step + output;
                stepNum++;
            } else {
                step = num % 10;
                num /= 10;
                output = "\n" + stepNum + "th: " + step + output;
                stepNum++;
            }
        }
        return output;
    }
    public static int f(int x) {
        return 2 * (x*x) - 3;
    }
    public static int g(int x) {
        return x+3;
    }
    public static String BirthdayChallenge() {
        Scanner input = new Scanner(System.in);
        System.out.println("Whose birthday is it: ");
        String name = input.nextLine();
        return part2() + "\n" + part2() + "\n" + part1(name) + "\n" + part2();
    }
    public static String part1(String name) {
        return "Happy birthday dear " + name;
    }
    public static String part2() {
        return "Happy birthday to you!";
    }
    public static int compare(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    public static void main(String[] args) {
        System.out.println((int)(Math.random()*6)+1);
    }
}
