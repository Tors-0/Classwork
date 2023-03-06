import java.util.stream.IntStream;

public class Paralellization {
    public static void main(String[] args) {

    }
    public static boolean isPrime(long x) {
        int[] candidates = new int[(int) Math.sqrt(x)];
        for (int i = 0; i < (int) Math.sqrt(x); i++) {
            candidates[i] = i + 1;
        }
        long t = IntStream.of(candidates)
                .parallel()
                .filter(n -> x % n == 0 && n != 1 && n != x)
                .count();
        return t == 0;
    }
}
