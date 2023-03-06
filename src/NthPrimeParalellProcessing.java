import java.util.Arrays;
import java.util.stream.IntStream;

public class NthPrimeParalellProcessing {
    public static void main(String[] args) {
        System.out.println(findNthPrime(100_000, 12));
    }
    public static int findNthPrime(int n, int numCores) {
        if (n <= 0) throw new IllegalArgumentException("Invalid input n: " + n);
        if (numCores <= 0) throw new IllegalArgumentException("Invalid input numCores: " + numCores);

        int count = 1;
        int candidate = 1;

        while (count < n) {
            final int searchLimit = candidate + 10_000_000;
            final int numChunks = numCores * 2;

            int[] chunkSizes = new int[numChunks];
            Arrays.fill(chunkSizes, (searchLimit - candidate) / numChunks);
            for (int i = 0; i < (searchLimit - candidate) % numChunks; i++) {
                chunkSizes[i]++;
            }

            int finalCandidate = candidate;
            count += IntStream.range(0,numChunks)
                    .parallel()
                    .mapToObj( i -> {
                        int start = finalCandidate + IntStream.of(chunkSizes).limit(i).sum();
                        int end = start + chunkSizes[i] - 1;
                        return IntStream.rangeClosed(start + 1, end)
                                .filter(NthPrimeParalellProcessing::isPrime)
                                .toArray();
                    })
                    .flatMapToInt(Arrays::stream)
                    .count();

            candidate = searchLimit;
        }

        return candidate - 1;
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
