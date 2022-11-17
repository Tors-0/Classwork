import java.util.Arrays;
import java.util.Scanner;

public class Functions {
  static Scanner scanny = new Scanner(System.in);
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
    public static int findMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
    public static String coinFlip() { //simulate a game of coin toss, telling the user if they guesses correctly or not
        Scanner input = new Scanner(System.in);
        boolean guess;
        System.out.print("Type your guess (heads / tails): ");
        String user = input.nextLine();
        if (user.toLowerCase().equals("heads")) {
            guess = true;
        } else if (user.toLowerCase().equals("tails")) {
            guess = false;
        } else {
            return "Error: User input invalid range. Don't use spaces in your answer!";
        }
        int coin = (int) (Math.random()*2);
        if (guess && coin == 1) {
            return "Coin lands on heads! You win!";
        } else if (!guess && coin == 0) {
            return "Coin lands on tails! You win!";
        } else if (guess && coin == 0) {
            return "Coin lands on tails! You lose!";
        } else {
            return "Coin lands on heads! You lose!";
        }
    }
    public static int[] front11(int[] a, int[] b) {
        int[] c;
        if (a.length == 0) {
            if (b.length == 0) {
                c = new int[] {};
            } else {
                c = new int[] {b[0]};
            }
        } else if (b.length == 0) {
            c = new int[] {a[0]};
        } else {
            c = new int[] {a[0],b[0]};
        }
        return c;
    }
    public static String baseX() {
        Scanner input = new Scanner(System.in);
        System.out.print("What base would you like to know about? (ints 1-62): ");
        int n = input.nextInt();
        String[] ans = new String[n];
        if (n > 62) {
            return "Error: Value out of range! 1-62";
        }
        for (int i = 0; i < 10 && i < n; i++) {
            ans[i] = String.valueOf(i);
        }
        if (n > 10) {
            char[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
            for (int i = 0; i + 10 < n; i++) {
                ans[i + 10] = ""+alpha[i];
            }
        }
        return "Values used in base " + n + ": " + Arrays.toString(ans);
    }
    public static String toScientific(double n) {
        int count = 0;
        if (n >= 10) {
            while (n >= 10) {
                n /= 10;
                count++;
            }
        } else if (n < 1) {
            while (n < 1) {
                n *= 10;
                count--;
            }
        }
        return n + "e" + count;
    }
    public static double f(double x) {
        return x * x;
    }
    public static double g(double x) {
        return -2 * x + 8;
    }
    public static double h(double x) {
        if (f(x) <= 0 || g(x) <= 0) {
            return 0.0;
        }
        return Math.min(f(x), g(x));
    }
    public static boolean checkIfPrime(int n) {
        int count = n - 2;
        for (int i = n; i > 0; i--) {
            if (n % i != 0) {
                count--;
            }
        }
        if (count == 0) {
            return true;
        } else return false;
    }
    public static boolean fastPrimeCheck(int n) {
        int count = n - 2;
        if (n <= 1) return false;
        else {
            for (int i = n-1; i > 1; i--) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    public static int nthPrime(int n) { // now 36% faster due to skipping even numbers
        int count = 1;
        int result = 0;
        if (n == 1) return 2;
        for (int i = 1; count < n; i+=2) {
            if (fastPrimeCheck(i)) {
                count++;
                result = i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.print("Which prime do you wish to find: ");
        int n = scanny.nextInt();
        double start = System.nanoTime();
        int prime = nthPrime(n);
        double end = System.nanoTime();
        double run = (end - start) / 1000000000;
        System.out.println("Found " + prime + " in " + run + "s");
    }
}
