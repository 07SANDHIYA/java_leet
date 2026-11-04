
class Solution {
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word,
                           int row, int col, int index) {

        // All characters are matched
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and character match
        if (row < 0 || col < 0 ||
            row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        // Store the current character
        char temp = board[row][col];

        // Mark the cell as visited
        board[row][col] = '#';

        // Search in all four directions
        boolean found =
            search(board, word, row + 1, col, index + 1) ||
            search(board, word, row - 1, col, index + 1) ||
            search(board, word, row, col + 1, index + 1) ||
            search(board, word, row, col - 1, index + 1);

        // Restore the original character
        board[row][col] = temp;

        return found;
    }
}
