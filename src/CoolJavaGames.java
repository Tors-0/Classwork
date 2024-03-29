import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
JAR build script: (execute in /src)
~$ jar -c -m Manifest.txt -f CoolJavaGames.jar CoolJavaGames.class LICENSE.md
 */

public class CoolJavaGames {
    static Scanner scanny = new Scanner(System.in); // scanner will be used to interpret various user choices
    static File myObj = new File("gameData.txt"); // filepath for saved game data
    // below this: static vars for blackjack vv
    static Map<Integer,Integer> deck = new HashMap<>(); // map to store the integer value of each card in the deck
    // (key), and the number of that card remaining in the deck (value). This is used to prevent the same card from
    // being drawn more than 1 time, since that would be impossible in a real deck of cards
    static int deckSize = 104; // can be used to change the size of the deck as needed. min: 52
    static int[] dealer = new int[5]; // stores the dealers hand, maxes at 5 bc of 5 card charlie rule
    static int dealerPos = 0; // stores the next blank index in dealers hand
    static int[] player = new int[5]; // stores the players hand
    static int playerPos = 0; // stores the next blank index in players hand
    // static vars for blackjack ^^
    // static vars for ticktacktoe vv
    static Map<String,Character> board = new HashMap<>(); // stores whether each space on TTT board has been played on yet
    static Map<String,Integer> boardAI = new HashMap<>(); // used by AI to store opponents moves
    // static vars for ticktacktoe ^^
    static final String ANSI_CYAN = "";
    // used for color coding of text, uncomment next line if your IDE supports ANSI color outputs in its terminal
    //ANSI_CYAN = "\u001B[36m";
    static final String ANSI_RESET = "";
    // used for color coding of text, uncomment next line if your IDE supports ANSI color outputs in its terminal
    //ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        System.out.println("What game would you like to play?: \n0 : Rock Paper Scissors \n1 : dont select" +
                "\n2 : dont select \n3 : dont select\n4 : I don't want to play a game");
        System.out.print("Your choice: ");
        String choice = scanny.nextLine();
        // Check which choice you pick
        if ((Integer.parseInt(choice) == 0) || choice.equalsIgnoreCase("ROCK PAPER SCISSORS"))   {
            // If you pick rock paper scissors
            beginRPS();
        } else if (Integer.parseInt(choice) == 1 || choice.equalsIgnoreCase("GUESS OUT OF 3")) {
            // If you pick guess3
            beginGuess3();
        } else if (Integer.parseInt(choice) == 2 || choice.equalsIgnoreCase("BLACKJACK")) {
            // If you choose Blackjack
            beginBlackjack();
        } else if (Integer.parseInt(choice) == 3) {
            // if you chose ticktacktoe
            beginTicTacToe();
        } else if (Integer.parseInt(choice) == 4 || choice.equalsIgnoreCase("I DON'T WANT TO PLAY A GAME")) {
            //If you choose not to play a game
            System.out.print("Would you like to view statistics? (y/n): ");
            choice = scanny.next();
            if (choice.charAt(0) == 'y') {
                gameStats();
            }
            System.exit(0);
        } else { // if the detected user input does not match a valid choice
            System.out.println("Invalid choice!");
            System.exit(1);
        }
    }
    private static void gameStats() { // reads gameData.txt file
        try {
            Scanner reader = new Scanner(myObj); // new scanner created for filepath
            String data;
            int BJLosses = 0; // number of losses in blackjack
            int BJWins = 0; // number of wins in blackjack
            int BJPlays = 0; // number of times blackjack was played
            int RPSWins = 0; // num of wins in rps
            int RPSNonWins = 0; // num of losses in rps
            int RPSPlays = 0; // num of total plays of rps
            while (reader.hasNextLine()) { // while there are still more line in the file
                data = reader.nextLine(); // read the next line
                if (data.contains("Blackjack")) { // if the line applies to blackjack...
                    if (data.contains("Dealer.Win")) { // ...and shows a dealer win
                        BJLosses++;
                        BJPlays++;
                    } else if (data.contains("Player.Win")) { // ...and shows a player win
                        BJWins++;
                        BJPlays++;
                    } else if (data.contains("Both.Lose")) { // ...and shows a dual loss
                        BJPlays++;
                    }
                }
                if (data.contains("RPS")) { // if the line applies to rock paper scissors...
                    if (data.contains("Player.Win")) { // ...and shows a player win
                        RPSWins++;
                        RPSPlays++;
                    } else if (data.contains("Player.NonWin")) { // ...and shows a player loss/tie
                        RPSNonWins++;
                        RPSPlays++;
                    }
                }
            }
            double winPercent = RPSWins / (double) RPSPlays * 100;
            double losePercent = RPSNonWins / (double) RPSPlays * 100;
            System.out.println("\nRock Paper Scissors Statistics:");
            System.out.println("Player Wins: " + RPSWins + " (~" + (int)winPercent + "%)");
            System.out.println("Player Losses/Ties: " + RPSNonWins + " (~" + (int)losePercent + "%)");
            System.out.println("Total plays: " + RPSPlays);
            winPercent = BJWins / (double) BJPlays * 100;
            losePercent = BJLosses / (double) BJPlays * 100;
            System.out.println("\nDefinitely not blackjack statistics:");
            System.out.println("Player wins: " + BJWins + " (~" + (int)winPercent + "%)");
            System.out.println("Dealer wins: " + BJLosses + " (~" + (int)losePercent + "%)");
            System.out.println("Total plays: " + BJPlays);
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred: " + e);
        }
    }
    static int rpsWin = 0;
    static int rpsLose = 0;
    private static void beginRPS() {
        if (rpsWin >= 2) {
            System.out.println("You have won 2 out of 3. You won overall!");
            System.exit(4534);
        } else if (rpsLose >= 2) {
            System.out.println("Computer has won 2 out of 3. You lose overall!");
            System.exit(2892);
        }
        //Generates AI hand
        int rand = (int) (Math.random() * 3);

        String hand = "";
        while (!hand.equalsIgnoreCase("rock") && !hand.equalsIgnoreCase("paper") && !(hand.equalsIgnoreCase("scissors"))) {
            System.out.println("Please pick Rock, Paper, or Scissors"); //asks which hand you would like to pick
            hand = scanny.nextLine(); //inputs your hand as a variable
        }
        //checks which hand you picked
        if ((hand.equalsIgnoreCase("ROCK")) && rand == 0) {
            System.out.println("Ai picked scissors, you win"); //Rock beats scissors so you beat the AI
            rpsWin++;
            saveToFile("RPS.Player.Win");
        } else if (hand.equalsIgnoreCase("PAPER") && rand == 1) {
            System.out.println("Ai picked rock, you win"); // paper beats rock so you beat the AI
            rpsWin++;
            saveToFile("RPS.Player.Win");
        } else if (hand.equalsIgnoreCase("SCISSORS") && rand == 2) {
            System.out.println("Ai picked paper, you win"); // scissors beat paper, so you win
            rpsWin++;
            saveToFile("RPS.Player.Win");
        } else if (!(hand.equalsIgnoreCase("ROCK") || hand.equalsIgnoreCase("PAPER") ||
                hand.equalsIgnoreCase("SCISSORS"))) {
            System.out.println("Invalid Input!");
            System.exit(1);
        }else {
            System.out.println("You lose/tie");
            rpsLose++;
            //if you lost or picked something that wasn't an option
            saveToFile("RPS.Player.NonWin");
        }
        String input = "";
        while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) {
            System.out.print("Would you like to play again? (yes/no): ");
            input = scanny.nextLine();
        }
        if (input.equalsIgnoreCase("yes")) {
            beginRPS();
        } else if (input.equalsIgnoreCase("no")) {
            System.out.println("Thanks for playing! Bye...");
            System.exit(382);
        }
    }
    private static void beginTicTacToe() {
        System.out.println("Columns (left to right) A, B, C. Rows (top to bottom) 1, 2, 3.");
        boolean victory = false;
        while (!victory) {
            TTTPlayer();
            TTTAI();
        }
    }
    private static void TTTPlayer() {
        System.out.print("Where do you want to play? (ex. b2): ");
        String select = scanny.nextLine();
        if (!board.containsKey(select.toLowerCase())) {
            board.put(select.toLowerCase(), 'x');
            TTTAI();
        } else {
            System.out.println("That space is already full! Please choose another.");
            TTTPlayer();
        }
    }
    private static void TTTAI() {
        int rand = (int) (Math.random() * 3) + 1;
        char randy = 'a';
        int rand2 = (int) (Math.random() * 3) + 1;
        if (rand == 1) {
            randy = 'a';
        } else if (rand == 2) {
            randy = 'b';
        } else if (rand == 3) {
            randy = 'c';
        }
        String choice = "" + randy + rand2;
    }

    private static void beginBlackjack() { // prints rules and draws 2 cards to each player
        for (int i = 1; i <= deckSize; i++) { // fills the deck map with default value of 1
            deck.put(i,1);
        }
        System.out.println("\nThe Game Begins...\nHouse rules:\n" + ANSI_CYAN + "\s\s\s5 Card Charlie" + ANSI_RESET +
                ": If a player reaches 5 cards without going over 21, they win automatically.\nConfiguration:\n\s\s\s" +
                " Decks currently in play: " + (deckSize/52) +"\n");
        drawCardPlayer();
        drawCardDealer();
        System.out.println("The dealer's face-up card is a(n) " + intToCard(dealer[0]));
        drawCardDealer();
        drawCardPlayer();
        continueBlackjack();
    }
    private static void continueBlackjack() { // detects if any player was delt a nat21, then continues gameplay
        if (smartCardValue(player[0],"player") + smartCardValue(player[1],"player") == 21 &&
                smartCardValue(dealer[0],"dealer") + smartCardValue(dealer[1],"dealer") == 21) {
            System.out.println("You and the dealer got a natural blackjack! Dealer wins due to tiebreaker rule!");
            endBlackjack(1);
        } else if (smartCardValue(dealer[0],"dealer") + smartCardValue(dealer[1],"dealer") == 21) {
            System.out.println("The dealer got a natural blackjack!");
            endBlackjack(1);
        } else if (smartCardValue(player[0],"player") + smartCardValue(player[1],"player") == 21) {
            System.out.println("You got a natural blackjack!");
            endBlackjack(0);
        } else {
            playerTurn();
            dealerTurn();
            endBlackjack(blackjackEval(allTotals()));
        }
    }
    private static void check5CC(int[] nums) { // checks if the 5 card charlie rule has been triggered
        int player = nums[0];
        int dealer = nums[1];
        if (playerPos >= 5 && player <= 21) {
            System.out.println("\nPlayer wins via 5 Card Charlie rule!");
            endBlackjack(0);
        } else if (dealerPos >= 5 && dealer <= 21) {
            System.out.println("\nDealer wins via 5 Card Charlie rule!");
            endBlackjack(1);
        }
    }
    private static int smartCardValue(int n, String user) { // intelligently decides if aces should count as 1 or 11
        // based on card totals
        while (n > 13) {
            n -= 13;
        }
        if (n == 1) {
            return choose1or11(user);
        } else {
            return Math.min(n, 10);
        }
    }
    private static int cardValue(int n) { // always counts aces as 1s, used to determine smart value
        while (n > 52) {
            n -= 52;
        }
        while (n > 13) {
            n -= 13;
        }
        return Math.min(n, 10);
    }
    private static int cardValue11(int n) { // always counts aces as 11s, used to determine smart value
        while (n > 52) {
            n -= 52;
        }
        while (n > 13) {
            n -= 13;
        }
        if (n == 1) {
            return 11;
        } else {
            return Math.min(10, n);
        }
    }
    private static int[] allTotals() { // returns the total value of both players hands
        int playerTotal = 0;
        int dealerTotal = 0;
        for (int i = 0; i < 5; i++) {
            playerTotal += smartCardValue(player[i],"player");
            dealerTotal += smartCardValue(dealer[i],"dealer");
        }
        int[] output = new int[2];
        output[0] = playerTotal;
        output[1] = dealerTotal;
        return output;
    }
    private static String intToCard(int n) { // returns the name value of the card from the int
        while (n > 52) {
            // if there's more than one deck in play (>52 cards) cards must be taken down into 1-52 range for counting
            n -= 52;
        }
        int count = 0;
        while (n > 13) {
            // since cards can have any value from 1-52, the must be taken down into the 1-13 range for parsing
            n -= 13;
            count++; // counts how many times the value was decremented, this decides the suit of the card
        }
        String suit;
        if (count == 0) {
            suit = "Clubs";
        } else if (count == 1) {
            suit = "Diamonds";
        } else if (count == 2) {
            suit = "Hearts";
        } else {
            suit = "Spades";
        }
        String output;
        String a;
        if (n == 1) {
            output = ANSI_CYAN + "Ace" + ANSI_RESET + " of " + suit;
        } else if (n == 11) {
            output = ANSI_CYAN + "Jack" + ANSI_RESET + " of " + suit;
        } else if (n == 12) {
            output = ANSI_CYAN + "Queen" + ANSI_RESET + " of " + suit;
        } else if (n == 13) {
            output = ANSI_CYAN + "King" + ANSI_RESET + " of " + suit;
        } else if (n == 0) {
            output = "__";
        } else {
            a = ANSI_CYAN + n + ANSI_RESET;
            output = a + " of " + suit;
        }
        return output;
    }
    private static void endBlackjack(int x) {
        // triggered when the game ends, both players' hands go face-up and the console displays who won
        String output = "Your hand:     ";
        for (int i = 0; i < 5; i++) {
            output += intToCard(player[i]) + ", ";
        }
        System.out.println(output);
        output = "Dealer's hand: ";
        for (int i = 0; i < 5; i++) {
            output += intToCard(dealer[i]) + ", ";
        }
        System.out.println(output);
        if (x == 0) {
            System.out.println("\nYou have won the game!");
            saveToFile("Blackjack.Player.Win");
            System.exit(0);
        } else if (x == 1) {
            System.out.println("\nYou lost the game!");
            saveToFile("Blackjack.Dealer.Win");
            System.exit(0);
        } else {
            System.out.println("\nBoth player and dealer bust! Nobody wins.");
            saveToFile("Blackjack.All.Lose");
            System.exit(0);
        }
    }
    private static void playerTurn() {
        // the player's turn, shows the player their full hand, then asks if they hit or stand
        check5CC(allTotals());
        String output = "Your hand: ";
        for (int i = 0; i < 5; i++) {
            output += intToCard(player[i]) + ", ";
        }
        System.out.println("\n" + output);
        System.out.print("Do you choose to stand or hit (s/h): ");
        String userChoice = scanny.nextLine();
        if (userChoice.equalsIgnoreCase("stand") || userChoice.equalsIgnoreCase("s")) {
            System.out.println("You end your turn. Dealer begins playing...\n");
        } else if (userChoice.equalsIgnoreCase("hit") || userChoice.equalsIgnoreCase("h")) {
            drawCardPlayer();
            playerTurn();
        } else {
            System.out.println("You picked an invalid option. Try again.");
            playerTurn();
        }
    }
    private static void dealerTurn() {
        // calculates the total of the dealer's hand but doesn't display it, then decides whether to draw or not
        check5CC(allTotals());
        int total = 0;
        for (int i = 0; i < 5; i++) {
            total += smartCardValue(dealer[i],"dealer");
        }
        if (total < 17) {
            drawCardDealer();
            dealerTurn();
        } else if (total > 21) {
            System.out.println("Dealer busts!\n");
        }else {
            System.out.println("Dealer has finished her turn, awaiting results...\n");
        }
    }
    private static int choose1or11(String user) { // decides whether aces should count as 1s or 11s for the given user
        int total = 0; // total with ace valued at 1
        int total11 = 0; // total with ace valued at 11
        if (user.equals("player")) {
            for (int i = 0; i < 5; i++) {
                total += cardValue(player[i]);
                total11 += cardValue11(player[i]);
            }
        } else if (user.equals("dealer")) {
            for (int i = 0; i < 5; i++) {
                total += cardValue(dealer[i]);
                total11 += cardValue11(dealer[i]);
            }
        }
        int diff = 21 - total; // how much headroom is left before 21 using 1 for aces
        int diff11 = 21 - total11; // how much headroom is left before 21 using 11 for aces
        if (diff11 < 0) {
            return 1;
        } else if (diff11 < diff) {
            return 11;
        } else {
            return 1;
        }
    }
    private static void drawCardDealer() { // draws a card from the deck to the dealers hand
        int choice = (int) (Math.random() * deckSize) + 1;
        if (deck.get(choice) > 0) {
            dealer[dealerPos] = choice;
            dealerPos++;
            deck.put(choice, 0); // decrements the value of that card in the deck to 0, so it can't be drawn again
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total += cardValue(player[i]);
            }
            if (total == 21) {
                endBlackjack(1);
            } else if (total > 21) {
                endBlackjack(0);
            }
        } else {
            drawCardDealer();
        }
    }
    private static void drawCardPlayer() { // draws a card from the deck to the players hand
        int choice = (int) (Math.random() * deckSize) + 1;
        if (deck.get(choice) > 0) {
            player[playerPos] = choice;
            playerPos++;
            deck.put(choice, 0); // decrements the value of that card in the deck to 0, so it can't be drawn again
            int total = 0;
            for (int i = 0; i < 5; i++) {
                total += smartCardValue(player[i],"player");
            }
            if (total == 21) {
                endBlackjack(0);
            } else if (total > 21) {
                System.out.println();
                endBlackjack(1);
            }
        } else {
            drawCardPlayer();
        }
    }
    public static int blackjackEval(int[] input) {  // method that returns which value wins the
        // game, ‘0’ if player wins, ‘1’ if dealer wins, returns '2' if both values are over 21
        int distPlayer = 21 - input[0];
        int distDealer = 21 - input[1];
        if (distPlayer < 0 && distDealer < 0) {
            return 2;
        } else if (distPlayer < 0) {
            return 1;
        } else if (distDealer < 0) {
            return 0;
        } else if (distPlayer < distDealer) {
            return 0;
        } else {
            return 1;
        }
    }
    private static void beginGuess3() {
        //Generates ai number
        int rand = (int) (Math.random() * 3) + 1;
        //asks you to pick a number
        System.out.println("Please pick a number between 1 and 3, inclusive");
        String pick = scanny.nextLine(); //inputs your hand as a variable
        //checks which number you picked
        if ((Integer.parseInt(pick)) == rand) {
            System.out.println("Computer picked " + rand + ". You Win!");
            //if you picked the same thing as the computer then you win
        } else {
            System.out.println("Computer picked " + rand + ". \nYou lose (or picked an invalid input)");
            //if you didn't pick the same number as the computer or picked something that wasn't an option
            System.exit(1);
        }
    }
    private static void saveToFile(String data) {
        try {
            FileWriter myWriter = new FileWriter(myObj,true);
            String text = "\n";
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                text += "// This file is for Statistical tracking and debugging purposes, please do not " +
                        "edit, delete, or move this file //";
            } else {
                System.out.println("Save file already exists.");
            }
            myWriter.append(text);
            myWriter.append(data);
            System.out.println("Successfully saved game data.");
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
        }
    }
}
