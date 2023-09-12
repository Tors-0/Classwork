package non_csa;

import java.util.Scanner;

public class coffeeMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How much coffee is needed ");
        double o = in.nextFloat();
        System.out.print("What temp is the milk ");
        double t = in.nextFloat();
        System.out.print("What temp is the coffee ");
        double c = in.nextFloat();
        System.out.print("What temp should product be ");
        double z = in.nextFloat();
        //double m = ((z * o) - (c * o)) / ((2 * z) - t - c);
        double m = o*(c-z)/(t-c);
        System.out.println("The mass (or vol) of milk needed is " + m);
        System.out.println("The mass (or vol) of coffee needed is " + (o - m));
    }
}
