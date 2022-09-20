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
    public static int f(int x) {
        return (x*x)+(5*x);
    }
    public static int g(int x) {
        return x+3;
    }
    public static void main(String[] args) {
        int ans = g(g(-2));
        System.out.println(ans);
    }
}
