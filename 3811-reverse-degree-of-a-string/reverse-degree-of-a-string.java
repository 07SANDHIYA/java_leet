class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        int i=1;
        if(i<=s.length()){
        for(char ch:s.toCharArray()){
            int res=(122-ch)+1;
            int ans=i*res;
            sum+=ans;
            i++;
            }
        }
        return sum;
    }
}