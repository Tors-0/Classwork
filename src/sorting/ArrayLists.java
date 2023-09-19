package sorting;

import java.util.ArrayList;
import java.util.HashMap;

public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Double> g = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            g.add((double) (Math.random() * 100));
        }
        System.out.println(g);
        /*for (int i = g.size()-1; i >= 0; i--) {
            if (1 == (int) g.get(i) % 2) {
                g.remove(i);
            }
        }
        System.out.println(g);*/
        sort(g);
        System.out.println(g);
    }
    public static int indexOf(ArrayList<Object> arr, Object o) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(o)) {
                return i;
            }
        }
        return -1;
    }
    public static void sort(ArrayList<Double> arr) {
        while (!isSorted(arr)) {
            for (int i = 1; i < arr.size(); i++) {
                if (arr.get(i) < arr.get(i-1)) {
                    arr.set(i-1, arr.set(i, arr.get(i-1)));
                }
            }
            System.out.println(arr);
        }
    }
    public static boolean isSorted(ArrayList<Double> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if ((double) arr.get(i) < (double) (arr.get(i-1))) return false;
        }
        return true;
    }
    public static double mode(ArrayList<Double> arr) {
        if (arr.size() == 0) return 0;
        HashMap<Double, Double> map = new HashMap<>();
        for (double i : arr) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1d);
            }
        }
        final double[] mode = {0};
        final double[] modeNum = {0};
        map.forEach((k, v) -> {
            if (v > modeNum[0]) {
                mode[0] = k;
                modeNum[0] = v;
            }
        });
        return mode[0];
    }
}