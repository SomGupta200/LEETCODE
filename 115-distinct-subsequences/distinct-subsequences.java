class Solution {
    Integer[][] dp;
    public int numDistinct(String s, String t) {
         dp = new Integer[s.length()][t.length()];

        return solve(0, 0, s, t);
    }
        private int solve(int i, int j,
                      String s, String t) {

        // formed t successfully
        if (j == t.length()) return 1;

        // s exhausted
        if (i == s.length()) return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int ans = 0;

        // characters match
        if (s.charAt(i) == t.charAt(j)) {

            // take + skip
            ans =
                solve(i + 1, j + 1, s, t)
                +
                solve(i + 1, j, s, t);

        } else {

            // skip only
            ans = solve(i + 1, j, s, t);
        }

        return dp[i][j] = ans;
    }

}