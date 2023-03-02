import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutoTicTacToe {
    private static final Scanner in = new Scanner(System.in); // take user's input for where to play
    private static boolean isX = false; // keep track of which players turn it is
    private static char winner = ' '; // keep track of which player is winning during checkWin
    private static int turn = 1; // keep track of what turn it currently is
    // stuff for persistent statistics
    static File myObj = new File("autoTTTdata.txt");
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
    public static void gameStats() {
        try {
            Scanner files = new Scanner(myObj);
            int xWins = 0;
            int oWins = 0;
            int ties = 0;
            while (files.hasNextLine()) {
                String data = files.nextLine();
                if (data.contains("Player X")) {
                    xWins++;
                } else if (data.contains("Player O")) {
                    oWins++;
                } else if (data.contains("Tie!")) {
                    ties++;
                }
            }
            double total = xWins + oWins + ties;
            System.out.println("X Wins: " + xWins + " (~" + (xWins/total)*100.0 + "%)");
            System.out.println("O Wins: " + oWins + " (~" + (oWins/total)*100.0 + "%)");
            System.out.println("Ties: " + ties + " (~" + (ties/total)*100.0 + "%)");
        } catch (FileNotFoundException ignored) {}
    }
    // end statistic stuff
    public static void main(String[] args) {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        do {
            isX = !isX; // switch to the other player's turn
            print(board); // print out game board
            playerTurn(board); // execute the player's turn
        } while( !checkWin(board) );
        turn = 10;
        print(board);
        System.out.println();
        if (winner == 'X' || winner == 'O') {
            String out = "Game Over!\nPlayer " + winner + " wins!";
            System.out.println(out + "\n\n");
            saveToFile(out);
            gameStats();
        } else {
            String out = "Game Over!\nTie!";
            System.out.println(out + "\n\n");
            saveToFile(out);
            gameStats();
        }
    }
    /**
     * Prints the game board
     * @param board A 3x3 array of chars, containing X, O, and other chars
     */
    public static void print(char[][] board) {
        System.out.println(
                "\n\nCurrent Board (Turn " + turn + "):\n" +
                " " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
                "~~~~~~~~~~~\n" +
                " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
                "~~~~~~~~~~~\n" +
                " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]
        );
    }
    /**
     * Execute the player's turn
     * @param board A 3x3 array of chars, containing X, O, and other chars
     */
    public static void playerTurn(char[][] board) {
        //set player to the person's turn
        char player = isX ? 'X' : 'O';

        //ask the user for the spot they want
        System.out.print("\nTurn " + turn + ": Player " + player + ", where would you like to go? > ");
        int spot = (int) (Math.random() * 9) + 1;
        System.out.println(spot);
        if (board[(spot-1) / 3][(spot - 1) % 3] != 'X' && board[(spot-1) / 3][(spot-1)%3] != 'O') {
            board[(spot - 1) / 3][(spot - 1) % 3] = player;
            turn++;
        } else {
            System.out.println("Spot taken!");
            playerTurn(board);
        }
    }
    /**
     * Check TicTacToe board for win condition
     * @param board A 3x3 array of chars, containing X, O, and other chars
     * @return boolean if win condition is present
     */
    public static boolean checkWin(char[][] board) {
        for (int row = 0; row < 3; row++) { // check each row for a win condition
            if (board[row][0] == board[row][1] &&
                board[row][1] == board[row][2] &&
                    (board[row][0] == 'X' || board[row][0] == 'O')) {
                winner = board[row][0];
                return true;
            }
        }
        for (int col = 0; col < 3; col++) { // check each column for a win condition
            if (board[0][col] == board[1][col] &&
                board[0][col] == board[2][col] &&
                    (board[0][col] == 'X' || board[0][col] == 'O')) {
                winner = board[0][col];
                return true;
            }
        }
        // check the diagonals for a win condition
        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2] &&
                (board[0][0] == 'X' || board[0][0] == 'O')) {
            winner = board[0][0];
            return true;
        }
        if (board[0][2] == board[1][1] &&
            board[1][1] == board[2][0] &&
                (board[0][2] == 'X' || board[0][2] == 'O')) {
            winner = board[0][2];
            return true;
        }
        // check if the entire board is full to prevent game from hanging after 9 turns
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == 'X' || board[row][col] == 'O') count++;
            }
        }
        return count >= 9;
    }
}