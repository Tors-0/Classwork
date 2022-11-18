import java.util.Scanner;

public class NthPrime {
    static Scanner scanny = new Scanner(System.in);
    protected static boolean checkIfPrime(long n) {
        // original prime checker, checks every factor of n
        long count = n - 2;
        for (long i = n; i > 0; i--) {
            if (n % i != 0) {
                count--;
            }
        }
        return count == 0;
    }
    protected static boolean fastPrimeCheck(long n) {
        // only checks factors until it finds a number that is a factor of n
        // if it doesn't find any factors it returns true, but if it finds a factor it quits the loop and returns false
        // 30.8% faster than checkIfPrime due to this innovation
        if (n <= 1) return false;
        else {
            for (long i = n-1; i > 1; i--) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    protected static boolean fasterPrimes(long n) {
      if (n<=1) return false;
      for (long i = 0; i < Math.sqrt(n); i++) {
        if (n % i == 0) return false;
      }
      return true;
    }
    public static long nthPrime(long n) {
        // check every number 1 at a time until it finds n primes, has been changed to only check odd numbers to
        // increase speed, which contributed an additional 24.1% speed-up to the seeking process
        long count = 1;
        long result = 0;
        if (n == 1) return 2;
        for (long i = 1; count < n; i+=2) {
            if (fastPrimeCheck(i)) {
                count++;
                result = i;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        // now 47.5% faster than the original code
        System.out.print("Which prime do you wish to find?\nWARNING: Primes after the 10,000th will take " +
                "exponentially longer.\nThis may take several minutes or more depending on your computer! : ");
        long n = Integer.parseInt(scanny.nextLine().replaceAll(",",""));
        double start = System.nanoTime();
        long prime = nthPrime(n);
        double end = System.nanoTime();
        String run = Functions.nsToTime(end - start);
        System.out.println("\nFound " + prime + " in ~" + run);
    }
}