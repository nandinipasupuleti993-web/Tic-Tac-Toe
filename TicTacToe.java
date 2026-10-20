
import java.util.Scanner;

public class TicTacToe {

    static char[][] board = new char[3][3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        char player = 'X';
        int moves = 0;

        System.out.println("Welcome to Tic-Tac-Toe!");

        while (true) {
            printBoard();

            System.out.println("Player " + player
                    + ", enter row and column (1-3):");

            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid position! Try again.");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("Position already occupied! Try again.");
                continue;
            }

            board[row][col] = player;
            moves++;

            if (checkWinner(player)) {
                printBoard();
                System.out.println("Player " + player + " wins!");
                break;
            }

            if (moves == 9) {
                printBoard();
                System.out.println("The game is a draw!");
                break;
            }

            player = (player == 'X') ? 'O' : 'X';
        }

        sc.close();
    }

    static void printBoard() {
        System.out.println("\n-------------");

        for (int i = 0; i < 3; i++) {
            System.out.print("| ");

            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }

            System.out.println("\n-------------");
        }
    }

    static boolean checkWinner(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player
                    && board[i][1] == player
                    && board[i][2] == player) {
                return true;
            }

            if (board[0][i] == player
                    && board[1][i] == player
                    && board[2][i] == player) {
                return true;
            }
        }

        return (board[0][0] == player
                    && board[1][1] == player
                    && board[2][2] == player)
                || (board[0][2] == player
                    && board[1][1] == player
                    && board[2][0] == player);
    }
}
