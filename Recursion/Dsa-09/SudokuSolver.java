
public class SudokuSolver {

    public boolean isSafe(char[][] board, int row, int col, char num) {

        // Horizontal check
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Vertical check
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == num) {
                return false;
            }
        }

        // Small 3x3 grid check
        int nRow = (row / 3) * 3;
        int nCol = (col / 3) * 3;

        for (int i = nRow; i <= nRow + 2; i++) {
            for (int j = nCol; j <= nCol + 2; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solveSudoku(char[][] board, int row, int col) {

        // Base case
        if (row == 9) {
            return true;
        }

        int newCol = col + 1;
        int newRow = row;

        if (newCol == 9) {
            newRow = row + 1;
            newCol = 0;
        }

        // Skip already-filled cells
        if (board[row][col] != '.') {
            return solveSudoku(board, newRow, newCol);
        }

        // Try digits 1 to 9
        for (char i = '1'; i <= '9'; i++) {

            if (isSafe(board, row, col, i)) {

                board[row][col] = i;

                if (solveSudoku(board, newRow, newCol)) {
                    return true;
                }

                // Backtracking
                board[row][col] = '.';
            }
        }

        return false;
    }

    public static void main(String[] args) {

        SudokuSolver solution = new SudokuSolver();

        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };

        solution.solveSudoku(board, 0, 0);

        // Print solved Sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
