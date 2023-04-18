package recursion;

import java.util.ArrayList;

public class MergeSort {
    public static void mergeSort(ArrayList<Double> list, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;
            mergeSort(list, low, mid);
            mergeSort(list, mid+1, high);
            merge(list, low, mid, high);
        }
    }
    public static void merge(ArrayList<Double> list, int low, int mid, int high) {
        int l1 = mid - low + 1;
        int r1 = high - mid;
        Double[] left = new Double[l1];
        Double[] right = new Double[r1];
        for (int i = 0; i < l1; i++) {
            left[i] = list.get(low + i);
        }
        for (int i = 0; i < r1; i++) {
            right[i] = list.get(mid + 1 + i);
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < l1 && j < r1) {
            if (left[i] <= right[j]) {
                list.set(k, left[i]);
                k++;
                i++;
            } else {
                list.set(k, right[j]);
                k++;
                j++;
            }
        }
        while (i < l1) {
            list.set(k, left[i]);
            k++;
            i++;
        }
        while (j < r1) {
            list.set(k, right[j]);
            k++;
            j++;
        }
    }
}
