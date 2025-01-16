import java.util.Scanner;

public class tictactoe {

    private static void initializeBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ' ;
            }
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
                if (j < board[i].length - 1) System.out.print("|");
            }
            System.out.println();
            if (i < board.length - 1) {
                System.out.println("-----");
            }
        }
    }

    private static boolean checkWin(char[][] board,
                                    char player) {
// Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1]
                    == player && board[i][2] == player) {
                return true;
            }
        }
// Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i]
                    == player && board[2][i] == player) {
                return true;
            }
        }
// Check diagonals
        if (board[0][0] == player && board[1][1] ==
                player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] ==
                player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in) ;
        char[][] board = new char[3][3] ;
        char currentPlayer = 'X' ;
        boolean gameWon = false ;
        int totalMoves = 0 ;

        while (!gameWon && totalMoves < 9) {
            printBoard(board) ;

            System.out.println("Player " + currentPlayer + ", enter your move (row and column, 0-2): ");

                int row = scnr.nextInt() ;
                int col = scnr.nextInt() ;

            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ' ) {
                System.out.println("Invalid move. Try again.") ;
                continue ;
            }
            board[row][col] = currentPlayer;
                totalMoves++ ;

            if (checkWin(board, currentPlayer)) {
                printBoard(board) ;
                System.out.println("Player " + currentPlayer + " wins!") ;
                gameWon = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X' ;
            }
        }

        if (!gameWon) {
            printBoard(board) ;
            System.out.println("It's a draw!");
        }
        scnr.close() ;
    }
}
