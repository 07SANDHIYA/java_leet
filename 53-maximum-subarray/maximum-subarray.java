class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE,currSum=0;
        for(var ele:nums){
            currSum+=ele;
             maxSum=Math.max(maxSum,currSum);
             if(currSum<0) currSum=0;
        }
    return maxSum;    
    }
}