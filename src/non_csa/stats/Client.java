package non_csa.stats;

public class Client {
    public static void main(String[] args) {
        double[] arr = {68,72,61,62,63,63,64,64,59,62,61,60,65,62,57,77,62,71,65,62,70};
        ArrayStats stat = new ArrayStats(arr);
        System.out.println("min: " + stat.min());
        System.out.println("q1: " + stat.q1());
        System.out.println("median: " + stat.median());
        System.out.println("mean: " + stat.mean());
        System.out.println("q3: " + stat.q3());
        System.out.println("max: " + stat.max());
    }
}
