class Solution {
    public int maxProfit(int[] prices) {
       int currentProfit=0,maxProfit=0;
       int minBuyPrice=prices[0];
       for(var currentPrice:prices){
         if(currentPrice<minBuyPrice) minBuyPrice=currentPrice;
         else{
            currentProfit=currentPrice-minBuyPrice;
            maxProfit=Math.max(currentProfit,maxProfit);
         }
       } 
       return maxProfit;
    }
}