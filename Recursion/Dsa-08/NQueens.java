
import java.util.*;

public class NQueens {

    public boolean isSafe(char[][] board, int row, int col, int n) {

        // Horizontal check
        for (int i = 0; i < n; i++) {
            if (board[row][i] == 'Q') {
                return false;
            }
        }

        // Vertical check
        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Left diagonal
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Right diagonal
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void backTrack(char[][] board, int row, int n,
                          List<List<String>> result) {

        // Base case: all rows have a queen
        if (row == n) {
            List<String> temp = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        // Try every column in the current row
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                board[row][col] = 'Q';

                backTrack(board, row + 1, n, result);

                // Backtrack: remove the queen
                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        backTrack(board, 0, n, result);

        return result;
    }

    public static void main(String[] args) {

        NQueens solution = new NQueens();

        int n = 4;

        List<List<String>> result = solution.solveNQueens(n);

        System.out.println(result);
    }
}
