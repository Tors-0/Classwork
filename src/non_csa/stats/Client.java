package non_csa.stats;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;

public class Client {
    public static void main(String[] args) {
        double[] arr = {62,69,36,34,50,16,54,98,28,9,45,41,100,18,78,84,70,56,6,88,35};
        ArrayStats stat = new ArrayStats(arr);
        System.out.println("5 number summary:\nmin: " + stat.min());
        System.out.println("q1: " + stat.q1());
        System.out.println("median: " + stat.median());
        System.out.println("q3: " + stat.q3());
        System.out.println("max: " + stat.max());
        System.out.println("\nother bits:\nmean: " + stat.mean());
        System.out.println("iqr: " + stat.iqr());
        System.out.println("n: " + stat.n());
        System.out.println("data: " + stat.data());
    }
}
