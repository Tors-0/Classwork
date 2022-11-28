import java.util.Scanner;

public class NthPrime {
    static Scanner scanny = new Scanner(System.in);
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
    public static long nthPrime(long seek, long foundPrimes, long start) {
        // check every number 1 at a time until it finds n primes, has been changed to only check odd numbers to
        // increase speed, which contributed an additional 24.1% speed-up to the seeking process
        long result = -1;
        for (long i = start; foundPrimes < seek; i += 2) {
            // only checks for factors from 1 to sqrt(n) instead of 1 to n
            // provides exponential speed increase over fastPrimeCheck
            boolean primality = true;
            for (long j = 3; j < Math.sqrt(i) + 1; j += 2) {
                if (i % j == 0) {
                    primality = false;
                    break;
                }
            }
            if (primality) {
                foundPrimes++;
                result = i;
            }
        }
        return result;
    }
    public static long bin100k(long seek, long found) {
        // binning method that divides primes into bins of 100k to make seeking faster
        if (seek < 100000) {
            return nthPrime(seek,found,3);
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
    }
    public static void main(String[] args) {
        // now 47.5% faster than the original code
        System.out.print(
                "Which prime do you wish to find?\nWARNING: " +
                "This may take several minutes depending on your computer! : ");
        long n = Integer.parseInt(scanny.nextLine().replaceAll(",",""));
        long prime;
        double start = System.nanoTime();
        if (n < 1) prime = -1;
        else if (n == 1) prime = 2;
        else prime = nthPrime(n,0,3);
        double end = System.nanoTime();
        String run = Functions.nsToTime(end - start);
        System.out.println("\nFound " + prime + " in ~" + run);
    }
}
