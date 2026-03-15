class Solution {
    public int numberOfPermutations(int n, int[][] requirements) {
        int MOD = 1_000_000_007;
        int MAX_INV = 400;

        int[] req = new int[n];
        Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        int[][] dp = new int[n + 1][MAX_INV + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {

            for (int j = 0; j <= MAX_INV; j++) {

                for (int k = 0; k <= Math.min(j, i - 1); k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
                }
            }

            if (req[i - 1] != -1) {
                int need = req[i - 1];
                for (int j = 0; j <= MAX_INV; j++) {
                    if (j != need) dp[i][j] = 0;
                }
            }
        }

        int ans = 0;
        for (int j = 0; j <= MAX_INV; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }

        return ans;

    }
}