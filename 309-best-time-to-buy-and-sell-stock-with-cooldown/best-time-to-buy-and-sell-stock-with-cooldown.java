class Solution {
    Integer[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new Integer[n][2];

        return solve(0 , 1 , prices);
    }
    private int solve(int i , int buy , int[] prices){
        // out of bounds
        if(i >= prices.length) return 0;

        if(dp[i][buy] != null)
            return dp[i][buy];
        
        int profit;

        // But state
        if(buy == 1){
            int take = -prices[i]+solve(i + 1 , 0 , prices);

            int skip = solve(i + 1 , 1 , prices);

            profit = Math.max(take , skip);
        }
        // Sell State
        else{
            int sell = prices[i] + solve(i + 2 , 1 , prices);

            int hold = solve(i + 1 , 0 , prices);

            profit = Math.max(sell , hold);
        }
        return dp[i][buy] = profit;
    }
}