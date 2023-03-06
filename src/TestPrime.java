import java.util.stream.IntStream;

public class TestPrime {
    public static void main(String[] args) {
        System.out.println(findNthPrime(100_000, 4));
    }
    public static int findNthPrime(int n, int numCores) {
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid input n: " + n);
        }

        if (numCores <= 0) {
            throw new IllegalArgumentException("Invalid input numCores: " + numCores);
        }

        int count = 1; // count starts at 1 because 2 is already included
        final int[] candidate = {1};
        int batchSize = 10_000_000;

        while (count < n) {
            final int searchLimit = candidate[0] + batchSize; // adjust search limit as needed

            count += IntStream.iterate(candidate[0] + 1, i -> i + 2)
                    .limit(batchSize / 2)
                    .parallel()
                    .filter(TestPrime::isPrime)
                    .peek(prime -> candidate[0] = prime)
                    .count();

            candidate[0] = searchLimit;
        }

        return candidate[0];
    }
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if ( n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
