import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
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
        n = Math.floor(n * 100) / 100;
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
    public static String nsToTime(double ns) {
        String suffix = " ns";
        if (ns >= 1000) {
            double us = ns / 1000;
            suffix = " \u00b5s";
            if (us >= 1000) {
                double ms =  us / 1000;
                suffix = " ms";
                if (ms >= 1000) {
                    double s = ms / 1000;
                    suffix = " s";
                    if (s >= 60) {
                        s = Math.floor(s * 100) / 100;
                        String out = "" + s + " s)";
                        double min = s / 60;
                        min = Math.floor(min * 100) / 100;
                        return "" + min + " minutes (" + out;
                    } else {
                        s = Math.floor(s * 100) / 100;
                        return "" + s + suffix;
                    }
                } else {
                    ms = Math.floor(ms * 100) / 100;
                    return "" + ms + suffix;
                }
            } else {
                us = Math.floor(us * 100) / 100;
                return "" + us + suffix;
            }
        } else {
            ns = Math.floor(ns * 100) / 100;
            return "" + ns + suffix;
        }
    }
    public static String numToMil(double n) {
        int count = 0;
        while (n >= 1000) {
            if (count >= 10) break;
            n /= 1000.0;
            count++;
            n = Math.floor(n * 10) / 10;
        }
        if (count == 0) {
            return "" + n;
        } else if (count == 1) {
            return "" + n + "k";
        } else if (count == 2) {
            return "" + n + "m";
        } else if (count == 3) {
            return "" + n + "b";
        } else if (count == 4) {
            return "" + n + "q";
        } else if (count == 5) {
            return "" + n + "Q";
        } else if (count == 6) {
            return "" + n + "s";
        } else if (count == 7) {
            return "" + n + "S";
        } else if (count == 8) {
            return "" + n + "o";
        } else if (count == 9) {
            return "" + n + "n";
        } else if (count == 10) {
            return "" + n + "d";
        }
        return "error";
    }
    public static String avgStrings(String a, String b, String c) {
        char[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w',
                'x','y','z',' '};
        Map<Character, Integer> ints = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            ints.put(chars[i],i);
        }
        int aa = a.length();
        int bb = b.length();
        int cc = c.length();
        int len = Math.min(Math.min(aa,bb),cc);
        int aaa;
        int bbb;
        int ccc;
        String output = "";
        for (int i = 0; i < len; i++) {
            aaa = ints.get(a.charAt(i));
            bbb = ints.get(b.charAt(i));
            ccc = ints.get(c.charAt(i));
            output += "" + chars[(int) Math.round((aaa + bbb + ccc) / 3.0)];
        }
        if (aa <= len && bb <= len && cc <= len) {
            return output;
        } else {
            aa -= len;
            bb -= len;
            cc -= len;
            return output;
        }
    }
    public static void main(String[] args) {
        System.out.println("avgStrings(\"raeeeee thorf\",\"unicorndave\",\"meowhuish dnd leopard\")");
        System.out.print(avgStrings("raeeeee thorf","unicorndave","meowhuish dnd leopard"));
    }
    public static int squareArrayCount(int n) {
        int[][] square = new int[n][n];
        int count = 0;
        for (int row = 0; row < square.length; row++) {
            for (int column = 0; column < square[row].length; column++) {
                square[row][column] = (int) Math.round(Math.random() * (n*n));
            }
        }
        for (int[] z : square) {
            for (int h : z) {
                if (h % 2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
