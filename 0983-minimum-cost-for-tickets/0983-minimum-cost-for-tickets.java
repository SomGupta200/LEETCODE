class Solution {
    
    Integer[] dp;

    public int mincostTickets(int[] days, int[] costs) {

        dp = new Integer[days.length];

        return solve(0, days, costs);
    }
     private int solve(int i, int[] days, int[] costs) {

        if (i >= days.length) return 0;

        if (dp[i] != null) return dp[i];

        // 1-day pass
        int op1 = costs[0] + solve(i + 1, days, costs);

        // 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) {
            j++;
        }

        int op2 = costs[1] + solve(j, days, costs);

        // 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) {
            j++;
        }

        int op3 = costs[2] + solve(j, days, costs);

        return dp[i] = Math.min(op1, Math.min(op2, op3));
    }
}