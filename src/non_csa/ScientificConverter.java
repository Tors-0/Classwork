package non_csa;

import java.util.Scanner;

public class ScientificConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double myNumber;
        int sigfigs;
        int counter = 0;
        System.out.print("What number would you like to convert: ");
        myNumber = input.nextDouble();
        System.out.print("How many sigfigs does your number have: ");
        sigfigs = input.nextInt();
        if (myNumber >= 10d) {
            while (myNumber >= 10d) {
                myNumber /= 10.0d;
                counter++;
            }
        }else if (myNumber <= 1d) {
            while (myNumber <= 1d) {
                myNumber *= 10.0d;
                counter--;
            }
        }
        // start factor in sigfigs
        double factor = 1;
        factor *= Math.pow(10, sigfigs-1);
        if (sigfigs != 0) {
            myNumber = (double) Math.round(myNumber * factor) / factor;
        } else {
            factor = 1_000_000_000;
            myNumber = (double) Math.round(myNumber * factor) / factor;
        }
        // end sigfig calculation
        String finalCounter = Integer.toString(counter); //superscript(Integer.toString(counter));
        System.out.println(myNumber + "e" + finalCounter + " |or| " + myNumber + " x 10" + superscript(Integer.toString(counter)));
    }
    public static String superscript(String str) {
        str = str.replaceAll("0", "⁰");
        str = str.replaceAll("1", "¹");
        str = str.replaceAll("2", "²");
        str = str.replaceAll("3", "³");
        str = str.replaceAll("4", "⁴");
        str = str.replaceAll("5", "⁵");
        str = str.replaceAll("6", "⁶");
        str = str.replaceAll("7", "⁷");
        str = str.replaceAll("8", "⁸");
        str = str.replaceAll("9", "⁹");         
        return str;
    }
}