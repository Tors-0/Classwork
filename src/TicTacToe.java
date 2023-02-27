import java.util.Scanner;
public class TicTacToe {
    private static final Scanner in = new Scanner(System.in); // take user's input for where to play
    private static boolean isX = false; // keep track of which players turn it is
    private static char winner = ' '; // keep track of which player is winning during checkWin
    private static int turn = 1; // keep track of what turn it currently is
    public static void main(String[] args) {
        char[][] board = {{'1','2','3'},{'4','5','6'},{'7','8','9'}};
        do {
            isX = !isX; // switch to the other player's turn
            print(board); // print out game board
            playerTurn(board); // execute the player's turn
        } while( !checkWin(board) );
        turn = Integer.MAX_VALUE;
        print(board);
        System.out.println();
        if (winner == 'X' || winner == 'O') {
            System.out.println("Game Over!\nPlayer " + winner + " wins!");
        } else {
            System.out.println("Game Over!\nTie!");
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
        int spot = in.nextInt();

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