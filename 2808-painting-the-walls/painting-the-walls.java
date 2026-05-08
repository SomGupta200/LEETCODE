class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;

        int[] dp = new int[n + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < n; i++) {

            int[] next = dp.clone();

            for (int j = 0; j <= n; j++) {

                if (dp[j] == Integer.MAX_VALUE) continue;

                int walls = Math.min(n, j + time[i] + 1);

                next[walls] = Math.min(
                    next[walls],
                    dp[j] + cost[i]
                );
            }

            dp = next;
        }

        return dp[n];
    }
}