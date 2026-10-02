class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtrack(
        List<String> result,
        StringBuilder current,
        int open,
        int close,
        int n
    ) {

        // We used all parentheses
        if (open == n && close == n) {
            result.add(current.toString());
            return;
        }

        // Add opening parenthesis
        if (open < n) {

            current.append('(');

            backtrack(result, current, open + 1, close, n);

            // Undo the choice
            current.deleteCharAt(current.length() - 1);
        }

        // Add closing parenthesis
        if (close < open) {

            current.append(')');

            backtrack(result, current, open, close + 1, n);

            // Undo the choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}