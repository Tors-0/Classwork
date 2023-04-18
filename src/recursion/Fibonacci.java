package recursion;

import java.util.ArrayList;

public class Fibonacci {
    public static ArrayList<Long> main(long n) {
        ArrayList<Long> out = new ArrayList<>();
        return fiboHelper(n, 0,1, 0, out);
    }
    private static ArrayList<Long> fiboHelper(long n, long i, long prev, long prev2, ArrayList<Long> out) {
        long temp = prev + prev2;
        out.add(temp);
        prev2 = prev;
        prev = temp;
        i++;
        if (n == i) {
            return out;
        } else {
            return fiboHelper(n, i, prev, prev2, out);
        }
    }
}
