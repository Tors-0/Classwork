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
}
