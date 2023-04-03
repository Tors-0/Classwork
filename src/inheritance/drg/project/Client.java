package inheritance.drg.project;

import java.util.Scanner;

public class Client {
    static int playerCount;
    static int hazardLevel;
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        double playerHealth = 100;
        selectDifficulty();
        GlyphidGrunt notSteeve = createEnemy();
        System.out.println(notSteeve);
        playerHealth += notSteeve.vampireKill(3);
        System.out.println(notSteeve);
        Bug test = createBug();
        Bug[] bugs = {test, notSteeve};
        for (Bug i : bugs) {
            System.out.println("Health gained: " +  i.vampireKill(3));
            System.out.println(i);
        }
    }
    public static void selectDifficulty() {
        System.out.print("Select your mission difficulty (1-5): ");
        hazardLevel = in.nextInt();
        if (hazardLevel >= 1 && 5 >= hazardLevel) {
            System.out.print("\sHow many dwarves are on this mission? (1-4): ");
            playerCount = in.nextInt();
            if (!(1 <= playerCount && playerCount <= 4)) {
                System.out.println("Invalid choice, try again...\n");
                selectDifficulty();
            }
        } else {
            System.out.println("Invalid choice, try again...\n");
            selectDifficulty();
        }
    }
    public static GlyphidGrunt createEnemy() {
        double health = 0;
        switch (hazardLevel) {
            case 1:
                health = 63;
            case 2:
                health = 90;
            case 3:
                health = 99;
            case 4, 5:
                health = 108;
        }
        double damage = 0;
        switch (hazardLevel) {
            case 1:
                damage = 2;
            case 2:
                damage = 2.4 + (0.4 * playerCount);
            case 3:
                damage = 4.4 + (0.4 * playerCount);
            case 4:
                if (playerCount == 4) damage = 10;
                else {
                    damage = 7.4 + (0.6 * playerCount);
                }
            case 5:
                damage = 10.4 + (0.8 * playerCount);
        }
        return new GlyphidGrunt(health,0,health,damage);
    }
    public static Bug createBug() {
        return new Bug(40, 0, 50, 10, -30, 30, "small");
    }
}