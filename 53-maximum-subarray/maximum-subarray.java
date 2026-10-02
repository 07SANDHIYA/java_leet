class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int curSum=0;
        for(var ele:nums){
            curSum+=ele;
            maxSum=Math.max(maxSum,curSum);
            if(curSum<0) curSum=0;
        }
        return maxSum;
    }
}