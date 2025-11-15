import java.util.Scanner;

public class NQueens {

    static boolean isSafe(int[][] board, int row, int col, int n) {

        for (int i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static boolean solve(int[][] board, int row, int n) {

        if (row == n)
            return true;

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {

                board[row][col] = 1;

                if (solve(board, row + 1, n))
                    return true;

                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of board: ");
        int n = sc.nextInt();

        int[][] board = new int[n][n];

        System.out.print("Enter first queen row and column: ");
        int firstRow = sc.nextInt();
        int firstCol = sc.nextInt();

        board[firstRow][firstCol] = 1;

        if (solve(board, firstRow + 1, n)) {
            System.out.println("\nFinal N-Queens Matrix:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(board[i][j] + " ");
                System.out.println();
            }
        } else {
            System.out.println("No solution exists.");
        }

        sc.close();
    }
}
