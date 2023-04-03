import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Testing {
    static Scanner input = new Scanner(System.in);
    public static boolean array123(int[] nums) {
        for (int i = 0; i < (nums.length - 2); i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        /*ArrayList<Object> test = new ArrayList<>();
        test.add("hello");
        test.add(54);
        test.add("world!");
        test.add(new int[]{1, 2, 3});
        for (Object o : test) {
            System.out.println(o.toString());
        }*/
        SheRa[] superheros = { new Skeletor(), new HeMan(), new SheRa(), new
                BattleCat() };
        for (int i = 0; i < superheros.length; i++) {
            superheros[i].train();
            System.out.println();
            superheros[i].attack();
            System.out.println();
            System.out.println(superheros[i]);
            System.out.println();
        }

    }
    public static double f(double x) {
        return (3 * x) + 5;
    }
}
class HeMan extends Skeletor {
    public void attack() {
        super.attack();
        System.out.print("heman-A   ");
    }

    public String toString() {
        return "heman!";
    }
}
class SheRa {
    public void attack() {
        System.out.print("shera-A   ");
    }

    public void train() {
        System.out.print("shera-T   ");
    }

    public String toString() {
        return "shera!";
    }
}

class BattleCat extends HeMan {
    public void attack() {
        System.out.print("battlecat-A   ");
    }
    public void train() {
        attack();
        System.out.print("battlecat-T   ");
    }
}
class Skeletor extends SheRa {
    public void train() {
        System.out.print("skeletor-T   ");
        attack();
    }
}
