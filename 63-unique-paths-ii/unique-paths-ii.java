
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] dp = new int[n];

        // If the starting cell is an obstacle, no path is possible
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        // Starting position has one way
        dp[0] = 1;

        // Traverse each row
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // If there is an obstacle, no path can pass through it
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                }

                // Otherwise, add paths from left and top
                else if (j > 0) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return dp[n - 1];
    }
}
