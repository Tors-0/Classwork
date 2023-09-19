package non_csa.stats;

import java.util.Arrays;

public class ArrayStats {
    private double[] list;
    public ArrayStats(double[] list) {
        Arrays.sort(list);
        this.list = list;
    }
    public double median() {
        double med;
        med = list.length % 2 == 1
                ? list[(int) (list.length / 2)]:
                (list[(int) (list.length/2) - 1] + list[(int) (list.length/2)])/2.0;
        return med;
    }
    private double median(double[] arr) {
        return arr.length % 2 == 1
                ? arr[(int) (arr.length / 2)]:
                (arr[(int) (arr.length/2) - 1] + arr[(int) (arr.length/2)])/2.0;
    }
    public double mean() {
        double mean = 0;
        for (double d : list) {
            mean += d;
        }
        return mean / (double)list.length;
    }
    public double min() {
        return list[0];
    }
    public double max() {
        return list[list.length-1];
    }
    public double q1() {
        int max;
        if (list.length % 2 == 1) {
            // odd length case
            max = list.length/2;
        } else {
            // even length case
            max = (list.length/2);
        }
        double[] h1 = Arrays.copyOfRange(list,0,max);
        return median(h1);
    }
    public double q3() {
        int min;
        if (list.length % 2 == 1) {
            min = (list.length/2) + 1;
        } else {
            min = (list.length/2);
        }
        double[] h2 = Arrays.copyOfRange(list,min,list.length);
        return median(h2);
    }
}
