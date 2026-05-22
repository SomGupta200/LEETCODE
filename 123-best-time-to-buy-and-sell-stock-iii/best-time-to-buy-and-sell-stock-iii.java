class Solution {
    Integer[][][] dp;
    public int maxProfit(int[] prices) {
         int n = prices.length;

        dp = new Integer[n][2][3];

        return solve(0, 1, 2, prices);
    }
    private int solve(int i, int buy,
                      int cap, int[] prices) {

        // no days or no transactions
        if (i == prices.length || cap == 0) {
            return 0;
        }

        if (dp[i][buy][cap] != null) {
            return dp[i][buy][cap];
        }

        int profit;

        // can buy
        if (buy == 1) {

            int take =
                -prices[i]
                + solve(i + 1, 0, cap, prices);

            int skip =
                solve(i + 1, 1, cap, prices);

            profit = Math.max(take, skip);
        }

        // can sell
        else {

            int sell =
                prices[i]
                + solve(i + 1, 1, cap - 1, prices);

            int hold =
                solve(i + 1, 0, cap, prices);

            profit = Math.max(sell, hold);
        }

        return dp[i][buy][cap] = profit;
    }
}