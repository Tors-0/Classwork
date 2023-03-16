import java.text.DecimalFormat;
import java.util.Scanner;


//https://builtin.com/machine-learning/fastest-sorting-algorithm

public class MergeSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How long do you want the array to be? : ");
        int len = Integer.parseInt(in.nextLine());
        int[] list = new int[len];
        for (int i = 0; i < len; i++) {
            list[i] = i+1;
        }
        System.out.print("How many swaps should be performed per value? (Typical values 1-5) : ");
        int swapPerCount = Integer.parseInt(in.nextLine());
        for (int i = 0; i < len * swapPerCount; i++) {
            int index = (int) (Math.random() * list.length);
            int index2 = (int) (Math.random() * list.length);
            int temp = list[index];
            list[index] = list[index2];
            list[index2] = temp;
        }
        System.out.println("\nFinishing shuffling array with " + swapPerCount + " swaps per value.\nSorting array now...");
        double start = System.nanoTime();
        mergeSort(list, 0, list.length - 1);
        double end = System.nanoTime();
        String var = Functions.nsToTime(end - start);
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("Sorted array of " + df.format(list.length) + " values in: " + var);
        System.out.println("(dumb) average calculation time: " + Functions.nsToTime((end - start) / len) + " per element");
    }
    public static void mergeSort(int[] arr, int l, int h) {
        if (l < h) {
            int m = l + (h-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, h);
            merge(arr, l, m, h);
        }
    }
    public static void merge(int[] arr, int l, int m, int h) {
        int n1 = m-l+1;
        int n2 = h-m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for(int i = 0; i < n1; i++) {
            L[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++) {
            R[i] = arr[m+1+i];
        }
        int i = 0, j = 0, k =l;
        while(i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }
        while(i < n1) {
            arr[k++] = L[i++];
        }
        while(j < n2) {
            arr[k++] = R[j++];
        }
    }
}
