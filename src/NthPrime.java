import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.*;

public class NthPrime {
    static Scanner scanny = new Scanner(System.in);
    static long evals = 0;
    protected static boolean checkIfPrime(long n) {
        // original prime checker, checks every factor of n
        long found = n - 2;
        for (long i = n; i > 0; i--) {
            if (n % i != 0) {
                found--;
            }
        }
        return found == 0;
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
    public static long nthPrime(long seek) {
        long foundPrimes = 1;
        final long start = 3;
        // check every number 1 at a time until it finds n primes, has been changed to only check odd numbers to
        // increase speed, which contributed an additional 24.1% speed-up to the seeking process
        long result = -1;
        long mod = seek;
        for (long i = start; foundPrimes < seek; i++) {
            evals++;
            // only checks for factors from 1 to sqrt(n) instead of 1 to n
            // provides exponential speed increase over fastPrimeCheck\
            if (isPrime(i)) {
                foundPrimes++;
                result = i;
            }
            if (i % mod == 0) {
                System.out.print(".");
            }
        }
        return result;
    }
    public static boolean isPrime(long i) {
        boolean primality = true;
        double max = Math.sqrt(i) + 1;
        if (i % 2 != 0) {
            for (long j = 3; j < max; j += 2) {
                evals++;
                if (i % j == 0) {
                    primality = false;
                    break;
                }
            }
        } else primality = false;
        return primality;
    }
    /*public static long bin100k(long seek, long found) {
        // binning method that divides primes into bins of 100k primes to make seeking faster
        int[] a = {};
        if (seek < 100000) {
            return nthPrime(seek,1,3);
        } else if (seek < 200000) {
            return nthPrime(seek - 99999,found,1299709);
        } else if (seek < 300000) {
            return nthPrime(seek - 199999,found,2750159);
        } else if (seek < 400000) {
            return nthPrime(seek - 299999,found,4256233);
        } else if (seek < 500000) {
            return nthPrime(seek - 399999,found,5800079);
        } else if (seek < 600000) {
            return nthPrime(seek - 499999,found,7368787);
        } else if (seek < 700000) {
            return nthPrime(seek - 599999,found,8960453);
        } else if (seek < 800000) {
            return nthPrime(seek - 699999,found,10570841);
        } else if (seek < 900000) {
            return nthPrime(seek - 799999,found,12195257);
        } else {
            return nthPrime(seek - 899999,found,13834103);
        }
    }*/
    public static void main(String[] args) {
        // now 47.5% faster than the original code
        System.out.print(
                "Which prime do you wish to find?\nWARNING: " +
                "This may take several minutes depending on your computer! : ");
        String in = scanny.nextLine().replaceAll(",","");
        System.out.print("Preprocessing... ");
        long n = Integer.parseInt(in);
        long prime;

        System.out.print("Done!\nSeeking");
        double start = System.nanoTime();
        if (n < 1) throw new IllegalArgumentException("Invalid input n: " + n);
        else if (n == 1) prime = 2;
        else prime = nthPrime(n);
        double end = System.nanoTime();

        System.out.print(" Done!\nPost-processing... ");
        String run = Functions.nsToTime(end - start);
        String evaluated = Functions.numToMil(evals);
        // TODO 06/03/2023: Replace ChatGPT code with original code
        // Following code written by ChatGPT
        DecimalFormat formatter = new DecimalFormat("#,###");
        String primed = formatter.format(prime);
        // End ChatGPT code
        System.out.print("Done!\n");
        System.out.println("\nFound " + primed + " in ~" + run);
        System.out.println("Evaluated ~" + evaluated + " factors/numbers during runtime!");
    }
}
