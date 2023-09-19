package non_csa.stats;

public class Client {
    public static void main(String[] args) {
        double[] arr = {0,1,2,3,4,5,6,7,8,9,10};
        ArrayStats stat = new ArrayStats(arr);
        System.out.println("5 number summary:\nmin: " + stat.min());
        System.out.println("q1: " + stat.q1());
        System.out.println("median: " + stat.median());
        System.out.println("q3: " + stat.q3());
        System.out.println("max: " + stat.max());
        System.out.println("other bits:\nmean: " + stat.mean());
    }
}
