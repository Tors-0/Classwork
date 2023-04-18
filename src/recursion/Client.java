package recursion;

import java.text.DecimalFormat;
import java.util.ArrayList;
import tools.*;

public class Client {
    private static final int length = 1_000_000;
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.000");
        System.out.print("Creating randomised list... ");
        double start = System.nanoTime();
        ArrayList<Double> test = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            test.add(Math.random() * 100);
        }
        System.out.print("Done in " + Functions.nsToTime(System.nanoTime() - start) + "\nSorting list... ");
        start = System.nanoTime();
        MergeSort.mergeSort(test,0,length);
        System.out.println("Done in " + Functions.nsToTime(System.nanoTime() - start) + "\nSorted list: (*not included as it would overflow the terminal*)");
    }
}
