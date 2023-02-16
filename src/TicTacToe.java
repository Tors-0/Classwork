import java.util.Scanner;

public class TicTacToe
{
    private static final Scanner in = new Scanner(System.in);
    private static boolean isX = false;
    private static char winner = ' ';
    public static void main(String[] args) {
        char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};

        do {
            isX = !isX;

            print(board);
            playerTurn(board);

        } while( !checkWin(board) );
        if (winner == 'X' || winner == 'O') {
            System.out.println("Player " + winner + " wins!");
        } else {
            System.out.println("Tie!");
        }
    }

    public static void print(char[][] board) {
        System.out.println(
                " " + board[0][0] + " | " + board[0][1] + " | " + board[0][2] + "\n" +
                "~~~~~~~~~~~\n" +
                " " + board[1][0] + " | " + board[1][1] + " | " + board[1][2] + "\n" +
                "~~~~~~~~~~~\n" +
                " " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]
        );
    }

    public static void playerTurn(char[][] board) {
        //set player to the person's turn
        char player = isX ? 'X' : 'O';

        //ask the user for the spot they want
        System.out.print("Player " + player + ", where would you like to go? > ");
        int spot = in.nextInt();

        if (board[(spot - 1) / 3][(spot - 1) % 3] == ' ') {
            board[(spot - 1) / 3][(spot - 1) % 3] = player;
        } else {
            System.out.println("Spot taken!");
            playerTurn(board);
        }
    }

    public static boolean checkWin(char[][] board) {
        //TODO: check for win
        for (int row = 0; row < 3; row++) {
            if (board[row][0] == board[row][1] &&
                board[row][1] == board[row][2] &&
                board[row][0] != ' ') {
                winner = board[row][0];
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] == board[1][col] &&
                board[0][col] == board[2][col] &&
                board[0][col] != ' ') {
                winner = board[0][col];
                return true;
            }
        }
        if (board[0][0] == board[1][1] &&
            board[1][1] == board[2][2] &&
            board[0][0] != ' ') {
            winner = board[0][0];
            return true;
        }
        if (board[0][2] == board[1][1] &&
            board[1][1] == board[2][0] &&
            board[0][2] != ' ') {
            winner = board[0][2];
            return true;
        }
        int count = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] != ' ') count++;
            }
        }
        if (count >= 9) return true;
        return false;
    }
}