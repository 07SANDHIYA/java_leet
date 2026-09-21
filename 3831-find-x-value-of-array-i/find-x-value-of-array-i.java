class Solution {
    public long[] resultArray(int[] nums, int k) {

        long[] answer = new long[k];

        // dp[r] = number of subarrays ending at
        // the previous position with product remainder r
        long[] dp = new long[k];

        for (int num : nums) {

            int value = num % k;

            // Stores subarrays ending at the current position
            long[] newDp = new long[k];

            // Start a new subarray with only this number
            newDp[value]++;

            // Extend previous subarrays
            for (int r = 0; r < k; r++) {

                if (dp[r] == 0) {
                    continue;
                }

                int newRemainder = (r * value) % k;

                newDp[newRemainder] += dp[r];
            }

            // Add current subarrays to answer
            for (int r = 0; r < k; r++) {
                answer[r] += newDp[r];
            }

            // Current dp becomes previous dp
            dp = newDp;
        }

        return answer;
    }
}