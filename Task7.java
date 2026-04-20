class Solution {
    public int maxProfit(int[] prices) {
        // Initialize minPrice to the highest possible value
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit to 0
        int maxProfit = 0;
        
        for (int i = 0; i < prices.length; i++) {
            // If we find a new lower price, update minPrice
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // Otherwise, check if selling at the current price gives a better profit
            else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        
        return maxProfit;
    }
}
