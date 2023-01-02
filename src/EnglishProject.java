import java.util.Scanner;

public class EnglishProject {
    static Scanner input = new Scanner(System.in);
    public static void clear() { // done
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static void waitForEnter() { // done
        System.out.print("Press [Enter] to continue ->");
        try {
            System.in.read();
        } catch (Exception ignored) {}
        System.out.println();
    }

    public static void main(String[] args) { // done
        System.out.println("Welcome to the Civil War town simulator! \u00a9 2022 by Rae Johnston.");
        waitForEnter();
        System.out.println("You'll be playing as a character in a small town in Delaware during the civil war.\n" +
                "You can interact with the townspeople and walk around in town.\nYou'll be starting " +
                "your journey at the rail station, where you first arrive in town.");
        waitForEnter();
        railStation();
    }
    public static void townSquare() { // done
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

    private static void mainStreetW() { // done
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

    public static void bountyBoard() { // done
        clear();
        // return to town square after end dialogue
        System.out.println("Bounty Board:\nAny Persons found to be Aiding in the Escape of Slaves :" +
                " $50\nAny Slave that has been discovered Fleeing from their Owner : $100\n");

        System.out.println("Looks like that's all the bounties for today.");
        waitForEnter();
        townSquare();
    }

    public static void firstStreet() { // done
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

    public static void library() { // done
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

    public static void librarian() { // done
        clear();
        // talk to librarian, exit to library after convo finishes
        System.out.println("Librarian: If someone you know ever needs a place to shelter from a certain bounty, just " +
                "send them this way and I'll make sure they're in good hands.\n");
        stationMasterInt++;
        System.out.print("Now returning to library, ");
        waitForEnter();
        library();
    }

    public static void cityHall() { // done
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

    public static void mayor() { // done
        clear();
        // talk to the mayor
        System.out.println("Mayor: Hello! I'm afraid I'm terribly busy right now.");
        waitForEnter();
        cityHall();
    }

    public static void railStation() { // done
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
    public static void stationMaster() { // done
        clear();
        // talk to station master, exits to rail station when convo ends
        System.out.println("Station Master: The next train out of here isn't for another hour...");
        if (stationMasterInt >= 1) {
            System.out.println("\nStation Master: I see you've met my friend the Librarian. I guess that means you " +
                    "know" +
                    " our secret...\n\nStation Master: Well I guess it wouldn't hurt to show you the way out of here " +
                    "then...\n\nEnvironment: The Station Master pulls a lever on the station's control panel and a hatch " +
                    "opens in the wall next to it, it leads to a dark train car.\n\nYou: Whoa-wha- the train is " +
                    "leaving already?\n\n\t\t\t\tTHE END...");
            System.exit(0);
        }
        waitForEnter();
        railStation();
    }

    public static void nationalNews() { // done
        clear();
        // read national news, exits to rail station when dialogue ends
        System.out.println("National News:\nOn January 31, 1865, the 13th Amendment was passed by congress;.");
        // news board
        waitForEnter();
        railStation();
    }

    public static void mainStreetE() { // done
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

    public static void tavern() { // done
        clear();
        // travelers from many places stop here
        // talk to bartender or patrons
        System.out.println(
                "You are now in the Tavern.\nWould you like to talk to the Bartender (0), the Bar Patrons (1), or " +
                        "exit to Town Square (2)");
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
    public static void bartender() { // done
        clear();
        // talk to bartender, exits to tavern when convo ends
        System.out.println("You are now talking to the bartender:");
        System.out.println("Bartender: Howdy. I see you eyeing those other patrons over there, lemme tell ya, they're" +
                " a gossiping bunch, but they all seem to have the same story.");
        waitForEnter();
        tavern();
    }
    public static void barPatrons() { // done
        clear();
        // talk to bar patrons, exits to tavern when convo ends
        int rand = (int) (Math.random() * 3) + 1;
        String patron;
        if (rand == 1) {
            patron = "Jonathan";
        } else if (rand == 2) {
            patron = "Elisabeth";
        } else {
            patron = "Georg";
        }
        int randy = (int) (Math.random() * 3) + 1;
        String story;
        if (randy == 1) {
            story = "I hear that old Gertrude has been telling some nasty tales about how dangerous those black " +
                    "folk are.";
        } else if (randy == 2) {
            story = "Did ya know? Seems a lot of folk are complaining about having the Africans out in public now.";
        } else {
            story = "I've heard that there's a movement in the town hall to pass a new law to make slavery legal again.";
        }
        System.out.println("Now talking to " + patron);
        System.out.println(patron + ": " + story);
        waitForEnter();
        tavern();
    }

    public static void postOffice() { // done
        clear();
        // news from nearby towns comes here first
        // read newspapers or read mail
        System.out.println("You are now in the Post Office.");
        System.out.println("Newspaper: Today, December 6, 1865, the 13th amendment to the American Constitution is " +
                "ratified by a 3/4 majority of the states.");
        waitForEnter();
        mainStreetE();
    }

    public static void generalStore() { // done
        clear();
        // nothing here yet, cosmetic building
        System.out.println("You are in the General Store.\nThis is a cosmetic building. If you had brought money " +
                "maybe you could buy some bread and milk...");
        waitForEnter();
        firstStreet();
    }
    public static void church() { // done
        clear();
        // talk to pastor or exit to west main st
        System.out.println("You are now in the Church. You can listen to the Pastor (TW: racism, white supremacist " +
                "talk) (0) or exit to West Main Street (1)");
        int choice = 9;
        while (choice != 0 && choice != 1) {
            System.out.print("Environment: What would you like to do (0/1) -> ");
            choice = input.nextInt();
            System.out.println();
        }
        if (choice == 0) {
            pastor();
        } else {
            mainStreetW();
        }
    }
    public static void pastor() { // done
        clear();
        System.out.println("You are now talking to the Pastor.");
        System.out.println("Pastor: We must eradicate the danger facing our nation. We all, gathered here today, we " +
                "know that the Blacks invading our country are dangerous to us, because though they aren't real " +
                "citizens, they do take away very real jobs and poison the minds of those they talk to with their " +
                "ideas of racial equality.");
        waitForEnter();
        church();
    }
}