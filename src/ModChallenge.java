public class ModChallenge {
    public static void main(String[] args) {
        int num = 1234;
        int a = num % 10;
        int b = num % 100 - a;
        int c = num % 1000 - a - b;
        int d = num % 10000 - a - b - c;

        b /= 10;
        c /= 100;
        d /= 1000;

        System.out.println("First digit: " + d);
        System.out.println("Second digit: " + c);
        System.out.println("Third digit: " + b);
        System.out.println("Fourth digit: " + a);

    }
}
