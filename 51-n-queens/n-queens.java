class Solution {

    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        // Fill with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        int[] col = new int[n];
        int[] diag1 = new int[2 * n];
        int[] diag2 = new int[2 * n];

        backtrack(0, board, col, diag1, diag2, n);

        return answer;
    }

    private void backtrack(int row,
                           char[][] board,
                           int[] col,
                           int[] diag1,
                           int[] diag2,
                           int n) {

        // All queens placed
        if (row == n) {

            List<String> current = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                current.add(new String(board[i]));
            }

            answer.add(current);
            return;
        }

        // Try every column
        for (int c = 0; c < n; c++) {

            int d1 = row + c;
            int d2 = row - c + n;

            // Not safe
            if (col[c] == 1 ||
                diag1[d1] == 1 ||
                diag2[d2] == 1) {
                continue;
            }

            // Place queen
            board[row][c] = 'Q';
            col[c] = 1;
            diag1[d1] = 1;
            diag2[d2] = 1;

            // Next row
            backtrack(row + 1, board, col, diag1, diag2, n);

            // Backtrack
            board[row][c] = '.';
            col[c] = 0;
            diag1[d1] = 0;
            diag2[d2] = 0;
        }
    }
}