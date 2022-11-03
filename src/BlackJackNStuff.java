import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BlackJackNStuff {

    static Scanner scanny = new Scanner(System.in);

    static Map<Integer,Integer> deck = new HashMap<>(); // map to store the integer value of each card in the deck (key), and the number of that card remaining in the deck (value)
    static int cards = 52; // stores the number of cards left in the deck
    static int[] dealer = new int[5]; // stores the dealers hand
    static int dealerPos = 0; // stores the next blank index in dealers hand
    static int[] player = new int[5]; // stores the players hand
    static int playerPos = 0; // stores the next blank index in players hand

    public static void main(String[] args) {
        System.out.println("What game would you like to play?:" +
                "\n0 : Rock Paper Scissors" +
                "\n1 : Guess out of 3" +
                "\n2 : Blackjack" +
                "\n3 : I don't want to play a game");
        String choice = scanny.nextLine();

        // Check which choice you pick
        if ((Integer.parseInt(choice) == 0) || choice.toUpperCase().equals("ROCK PAPER SCISSORS"))   {
            // If you pick rock paper scissors
            beginRPS();
        } else if (Integer.parseInt(choice) == 1 || choice.toUpperCase().equals("GUESS OUT OF 3")) {
            // If you pick guess3
            beginGuess3();
        } else if (Integer.parseInt(choice) == 2 || choice.toUpperCase().equals("BLACKJACK")) {
            // If you choose Blackjack
            beginBlackjack();
        } else if (Integer.parseInt(choice) == 3 || choice.toUpperCase().equals("I DON'T WANT TO PLAY A GAME")) {
            //If you choose not to play a game
            System.exit(-1);
        } else {
            System.out.println("Invalid choice!");
            System.exit(0);
        }
    }

    private static void beginRPS() {
        //Generates ai hand
        int rand = (int) (Math.random() * 3);

        System.out.println("Please pick a symbol, Rock, Paper, or scissors"); //asks which hand you would like to pick
        String hand = scanny.nextLine(); //inputs your hand as a variable

        //checks which hand you picked
        if ((hand.toUpperCase().equals("ROCK")) && rand == 0) {
            System.out.println("Ai picked scissors, you win"); //Rock beats scissors so you beat the ai
        } else if (hand.toUpperCase().equals("PAPER") && rand == 1) {
            System.out.println("Ai picked rock, you win"); // paper beats rock so you beat the ai
        } else if (hand.toUpperCase().equals("SCISSORS") && rand == 2) {
            System.out.println("Ai picked paper, you win"); // scissors beat paper, so you win
        } else {
            System.out.println("You lose (or picked an invalid input)"); //if you lost or picked something that wasn't an option
            System.exit(1);
        }
    }
    public static void beginBlackjack() {
        for (int i = 0; i <= 13; i++) { // fills the deck map with default value of 4
            deck.put(i,4);
        }
        drawCardPlayer();
        drawCardDealer();
        drawCardPlayer();
        drawCardDealer();
        System.out.println("The dealer's face-up card is a " + intToCard(dealer[0]));
        System.out.println("Your cards are a " + intToCard(player[0]) + " and a " + intToCard(player[1]));
        if (cardValue(player[0]) + cardValue(player[1]) == 21) {
            System.out.println("You have a natural 21! You win!");
            System.exit(0);
        }

    }
    private static int cardValue(int n) {
        return Math.min(n, 10);
    }
    private static String intToCard(int n) {
        String output;
        if (n == 1) {
            output = "Ace";
        } else if (n == 11) {
            output = "Jack";
        } else if (n == 12) {
            output = "Queen";
        } else if (n == 13) {
            output = "King";
        } else if (n == 0) {
            output = "Empty Slot";
        } else {
            output = String.valueOf(n);
        }
        return output;
    }
    private static void endBlackjack(boolean x) {
        String output = "Your hand: ";
        for (int i = 0; i < 5; i++) {
            output += intToCard(player[i]) + ", ";
        }
        System.out.println(output);
        output = "Dealer's hand: ";
        for (int i = 0; i < 5; i++) {
            output += intToCard(dealer[i]) + ", ";
        }
        if (x) {
            System.out.println("You have won the game!");
        } else {
            System.out.println("You lost the game!");
        }
    }
    private static void playerTurn() {
        System.out.print("Do you choose to stand or hit : ");
        String userChoice = scanny.nextLine();
        if (userChoice.toLowerCase().equals("stand")) {
            System.out.println("You end your turn. Dealer begins playing.");
        } else if (userChoice.toLowerCase().equals("hit")) {
            drawCardPlayer();
        }
    }
    private static void drawCardDealer() { // draws a card from the deck to the dealers hand
        int choice = (int) (Math.random() * 13) + 1;
        if (deck.get(choice) > 0) {
            dealer[dealerPos] = choice;
            dealerPos++;
            cards--;
            deck.put(choice, deck.get(choice)+1);
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total += cardValue(player[i]);
            }
            if (total == 21) {
                endBlackjack(false);
            } else if (total > 21) {
                endBlackjack(true);
            }
        } else {
            drawCardDealer();
        }
    }
    private static void drawCardPlayer() { // draws a card from the deck to the players hand
        int choice = (int) (Math.random() * 13) + 1;
        if (deck.get(choice) > 0) {
            player[playerPos] = choice;
            playerPos++;
            cards--;
            deck.put(choice, deck.get(choice)+1);
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total += cardValue(player[i]);
            }
            if (total == 21) {
                endBlackjack(true);
            } else if (total > 21) {
                endBlackjack(false);
            } else {
                playerTurn();
            }
        } else {
            drawCardPlayer();
        }
    }
    public static boolean blackjack(int a, int b) {  // method that returns which value wins the game, ‘true’ if player wins, ‘false’ if dealer wins, returns null if both values are over 21
        int distA = 21 - a;
        int distB = 21 - b;
        if (distA < 0 && distB < 0) {
            return null;
        } else if (distA < 0) {
            return 'false';
        } else if (distB < 0) {
            return 'true';
        } else if (distA < distB) {
            return 'true';
        } else {
            return 'false';
        }
    }
    private static void beginGuess3() {
        //Generates ai number
        int rand = (int) (Math.random() * 3);

        System.out.println("Please pick a number between 1 and 3, inclusive"); //asks you to pick a number
        String pick = scanny.nextLine(); //inputs your hand as a variable

        //checks which number you picked
        if ((Integer.parseInt(pick)) == rand) {
            System.out.println("Computer picked " + rand + " You Win!"); //if you picked the same thing as the computer then you win
        } else {
            System.out.println("You lose (or picked an invalid input)"); //if you didn't pick the same number as the computer or picked something that wasn't an option
            System.exit(1);
        }
    }
}
