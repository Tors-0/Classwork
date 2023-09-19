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
            max = list.length/2;
        } else {
            max = (list.length/2) - 1;
        }
        if (max % 2 == 1) {
            return list[(int) (max / 2)];
        } else {
            return (list[(int) (max/2) - 1] + list[(int) (max/2)])/2.0;
        }
    }
    public double q3() {
        int min;
        if (list.length % 2 == 1) {
            min = list.length/2;
        } else {
            min = (list.length/2) - 1;
        }
        if ((list.length - min) % 2 == 1) {
            return list[min + (int) (min / 2)];
        } else {
            return (list[min + (int) (min/2) - 1] + list[min + (int) (min/2)])/2.0;
        }
    }
}
