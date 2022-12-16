import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class EnglishProject {
    static Scanner input = new Scanner(System.in);
    static double rand = Math.random()+1;
    private static int @NotNull [] seed(int n) {
        int[] out = new int[3];
        out[0] = (int) (Math.pow(n,rand) * n + 0.5) % 10;
        out[1] = (int) (n * rand + 0.5) % 10;
        out[2] = (int) (Math.sqrt(n) / rand + 0.5) % 10;
        return out;
    }
    public static void clear() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void waitForEnter() {
        System.out.print("Press [Enter] to continue ->");
        try {
            System.in.read();
        } catch (Exception ignored) {}
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Civil War town simulator! \u00a9 2022 by Rae Johnston.");
        waitForEnter();
        System.out.println("You'll be playing as a character in a small town in Delaware during the civil war.\n" +
                "You can interact with the townspeople and walk around in town.\nYou'll be starting " +
                "your journey at the rail station, where you first arrive in town.");
        waitForEnter();
        railStation();
    }

    public static void townSquare() {
        clear();
        //
        System.out.println("You are now in the Town Square. From here you can read the Bounty Board (0), enter City " +
                "Hall (1), enter the Tavern (2), go to East Main St (3), go to First St (4), or go to West Main St " +
                "(5)");
        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5) {
            System.out.print("Environment: What would you like to do (0/1/2/3/4/5) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            bountyBoard();
        } else if (choice == 1) {
            cityHall();
        } else if (choice == 2) {
            tavern();
        } else if (choice == 3) {
            mainStreetE();
        } else if (choice == 4) {
            firstStreet();
        } else {
            mainStreetW();
        }
    }

    private static void mainStreetW() {
        clear();
        // go to church or town square
        System.out.println("You are now on West Main St. From here you can enter the Church (0) or go to Town Square " +
                "(1)");
        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2) {
            System.out.print("Environment: What would you like to do (0/1/2) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            church();
        } else {
            townSquare();
        }
    }

    public static void bountyBoard() {
        clear();
        // return to town square after end dialogue
        System.out.println("Bounty Board:\nAny Persons found to be Aiding in the Escape of Slaves :" +
                " $50\nAny Slave that has been discovered Fleeing from their Owner : $100\n");

        System.out.println("Looks like that's all the bounties for today.");
        waitForEnter();
        townSquare();
    }

    public static void firstStreet() {
        clear();
        // connections: library, general store, town square
        System.out.println("You are now on First Street. From here you can go to Town Square (0), the Library (1), or" +
                " the General Store (2)");
        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2) {
            System.out.print("Environment: What would you like to do (0/1/2) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            townSquare();
        } else if (choice == 1) {
            library();
        } else {
            generalStore();
        }
    }

    public static void library() {
        clear();
        // talk to librarian, exit to first st
        System.out.println("You are now in the Library. You can talk to the Librarian (0) or exit to First Street (1)");
        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2) {
            System.out.print("Environment: What would you like to do (0/1/2) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            librarian();
        } else {
            firstStreet();
        }
    }

    public static void librarian() {
        clear();
        // talk to librarian, exit to library after convo finishes

        System.out.print("Now returning to library, ");
        waitForEnter();
        library();
    }

    public static void cityHall() {
        clear();
        // talk to mayor
        char choice = ' ';
        while (choice != 'y' && choice != 'n') {
            System.out.print("Environment: Would you like to talk to the mayor? (y/n) -> ");
            choice = input.next().charAt(0);
            System.out.println();
        }
        if (choice == 'y') {
            mayor();
        } else {
            System.out.println("Now exiting City Hall");
            waitForEnter();
            townSquare();
        }
    }

    public static void mayor() {
        clear();
        // talk to the mayor
        System.out.println("Mayor: Hello! I'm terribly busy now.");

        waitForEnter();
        cityHall();
    }

    public static void railStation() {
        clear();
        // talk to station master, read national news, or exit to e main st
        // news from across the country found here
        System.out.println("You are in the Rail Station.\nFrom here you can go to East Main St (0), read national " +
                "news (1), or talk to the station master (2)");
        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2) {
            System.out.print("Environment: What would you like to do (0/1/2) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            mainStreetE();
        } else if (choice == 1) {
            nationalNews();
        } else {
            stationMaster();
        }
    }
    static int stationMasterInt = 0;
    public static void stationMaster() {
        clear();
        // talk to station master, exits to rail station when convo ends
        // TODO: 12/9/22 station master what are your political views
        stationMasterInt += Math.random() * 3;
        int interaction = seed(stationMasterInt)[(int)(Math.random() * 3)];

        waitForEnter();
        railStation();
    }

    public static void nationalNews() {
        clear();
        // read national news, exits to rail station when dialogue ends
        System.out.println("National News:\n(looks like theres nothing here yet)");
        // TODO: 12/9/22 display news events based on number of times interacted with
        // news board
        System.out.println("\nLooks like that's all the news for today!");
        waitForEnter();
        railStation();
    }

    public static void mainStreetE() {
        clear();
        // enter rail station, enter post office, enter town square
        System.out.println("You are now on East Main Street. From here you can go to Rail Station (0), Town Square " +
                "(1), or enter Post Office (2)");

        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2) {
            System.out.print("Environment: What would you like to do (0/1/2) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            railStation();
        } else if (choice == 1) {
            townSquare();
        } else {
            postOffice();
        }
    }

    public static void tavern() {
        clear();
        // travelers from many places stop here
        // talk to bartender or patrons
        System.out.println(
                "Would you like to talk to the Bartender (0), the Bar Patrons (1), or exit to Town Square (2)");
        int choice = 9;
        while (choice != 0 && choice != 1 && choice != 2) {
            System.out.print("Environment: What would you like to do (0/1/2) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            bartender();
        } else if (choice == 1) {
            barPatrons();
        } else {
            townSquare();
        }
    }
    public static void bartender() {
        clear();
        // talk to bartender, exits to tavern when convo ends

        
    }

    public static void barPatrons() {
        clear();
        // talk to bar patrons, exits to tavern when convo ends
        // TODO 12/13/2022 decide which patrons are present on a given day
        

    }

    public static void postOffice() {
        clear();
        // news from nearby towns comes here first
        // read newspapers or read mail

    }

    public static void generalStore() {
        clear();
        // nothing here yet, cosmetic building

    }
    public static void church() {
        clear();
        // talk to pastor or exit to west main st
        
    }
}