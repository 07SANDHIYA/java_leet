
class Solution {
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        Boolean[][][] dp = new Boolean[n][n][n + 1];

        return check(s1, s2, 0, 0, n, dp);
    }

    boolean check(String s1, String s2, int i, int j, int len,
                  Boolean[][][] dp) {

        // If both substrings are exactly equal
        if (s1.substring(i, i + len).equals(s2.substring(j, j + len))) {
            return true;
        }

        // If the result is already calculated
        if (dp[i][j][len] != null) {
            return dp[i][j][len];
        }

        // Check whether both substrings contain same characters
        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int x : count) {
            if (x != 0) {
                return dp[i][j][len] = false;
            }
        }

        // Try every possible splitting position
        for (int k = 1; k < len; k++) {

            // Case 1: No swapping
            boolean withoutSwap =
                check(s1, s2, i, j, k, dp) &&
                check(s1, s2, i + k, j + k, len - k, dp);

            if (withoutSwap) {
                return dp[i][j][len] = true;
            }

            // Case 2: Swapping
            boolean withSwap =
                check(s1, s2, i, j + len - k, k, dp) &&
                check(s1, s2, i + k, j, len - k, dp);

            if (withSwap) {
                return dp[i][j][len] = true;
            }
        }

        return dp[i][j][len] = false;
    }
}
