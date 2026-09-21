class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        // Total characters must be equal
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // No characters from either string
        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= m; j++) {

                // Take current character from s1
                if (i > 0) {
                    if (dp[i - 1][j] &&
                        s1.charAt(i - 1) == s3.charAt(i + j - 1)) {

                        dp[i][j] = true;
                    }
                }

                // Take current character from s2
                if (j > 0) {
                    if (dp[i][j - 1] &&
                        s2.charAt(j - 1) == s3.charAt(i + j - 1)) {

                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[n][m];
    }
}