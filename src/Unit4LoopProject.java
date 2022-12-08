import java.util.Scanner;

public class Unit4LoopProject {
    static boolean playAgain = false;
    static Scanner input = new Scanner(System.in);
    static String userIn = "";
    static String hand = "";
    static String cont;
    public static void main(String[] args) {
        play();
        while (playAgain) {
            int rand = (int) ((Math.random() * 3) + 1);


            while (!hand.equalsIgnoreCase("rock") && !hand.equalsIgnoreCase("paper") && !hand.equalsIgnoreCase("scissors")) {
                System.out.println("Please pick a hand, rock, paper, or scissors.");
                hand = input.nextLine();
            }


            if ((hand.equalsIgnoreCase("ROCK")) && rand == 0) {
                System.out.println("Ai picked scissors, you win"); //Rock beats scissors so you beat the ai
            } else if (hand.equalsIgnoreCase("PAPER") && rand == 1) {
                System.out.println("Ai picked rock, you win"); // paper beats rock so you beat the ai
            } else if (hand.equalsIgnoreCase("SCISSORS") && rand == 2) {
                System.out.println("Ai picked paper, you win"); // scissors beat paper, so you win
            } else if ((hand.equalsIgnoreCase("ROCK") && rand == 1) || (hand.equalsIgnoreCase("PAPER") && rand == 2) || (hand.equalsIgnoreCase("SCISSORS") && rand == 0)) {
                System.out.println("Ai picked the same choice as you, Tie");
                System.out.print("Would you like to play again? (y/n): ");
                String cont = input.nextLine();
                if (cont.equals("n")) {
                    System.exit(0);
                } else if(cont.equals("y")) { //loops until you lose, then asks if you would like to play again
                    cont = null;
                    hand = null;
                    rand = 0;
                    main(new String[0]);
                } else {
                    System.out.println("invalid input");
                }
            } else {
                System.out.println("You lose"); //if you lost
                System.out.println("Would you like to play again? (y/n)");
                cont = input.nextLine();
                if (cont.equals("n")) {
                    System.exit(0);
                } else if(cont.equals("y")) { //loops until you lose, then asks if you would like to play again
                    cont = null;
                    hand = null;
                    rand = 0;
                } else {
                    System.out.println("invalid input");
                    cont = null;
                    hand = null;
                    rand = 0;
                }
            }
        }
    }
    public static void play() {
        while (!userIn.equalsIgnoreCase("yes") && !userIn.equalsIgnoreCase("no")) {
            System.out.flush();
            System.out.println("Would you like to play a game? (yes/no) ");
            userIn = input.nextLine();
            if (userIn.equalsIgnoreCase("yes")) {
                playAgain = true;
            } else if (userIn.equalsIgnoreCase("no")) {
                playAgain = false;
            }
        }
    }
}