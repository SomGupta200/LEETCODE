class Solution {
    public int maxProfit(int[] prices, int fee) {
        int aheadNotBuy , aheadBuy , curBuy , curNotBuy;
        aheadNotBuy = aheadBuy = 0;
        for(int ind = prices.length - 1 ; ind >= 0 ; ind--){
            // Sell
            curNotBuy = Math.max(prices[ind] + aheadBuy , 0 + aheadNotBuy);

            // Buy
            curBuy = Math.max(-prices[ind] - fee + aheadNotBuy , 0 + aheadBuy);

            aheadBuy = curBuy;
            aheadNotBuy = curNotBuy;
        }
        return aheadBuy;
    }
}