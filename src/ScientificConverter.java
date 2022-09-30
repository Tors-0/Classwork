import java.util.Scanner;

public class ScientificConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double myNumber;
        int counter = 0;
        myNumber = input.nextDouble();
        if (myNumber >= 10) {
            while (myNumber >= 10) {
                myNumber /= 10.0;
                counter++;
            }
        }else if (myNumber <= 1) {
            while (myNumber <= 1) {
                myNumber *= 10.0;
                counter--;
            }
        }
        String finalCounter = superscript(Integer.toString(counter));
        System.out.println(myNumber + " × 10" + finalCounter);
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