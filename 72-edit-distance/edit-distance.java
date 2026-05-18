class Solution {
    Integer[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

          dp = new Integer[n][m];

        return solve(0, 0, word1, word2);
    }
    private int solve(int i, int j,
         String s1, String s2) {

        // word1 finished
        if (i == s1.length()) {
            return s2.length() - j;
        }

        // word2 finished
        if (j == s2.length()) {
            return s1.length() - i;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        // characters match
        if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j] =
                solve(i + 1, j + 1, s1, s2);
        }

        // insert
        int insert =
            1 + solve(i, j + 1, s1, s2);

        // delete
        int delete =
            1 + solve(i + 1, j, s1, s2);

        // replace
        int replace =
            1 + solve(i + 1, j + 1, s1, s2);

        return dp[i][j] =
            Math.min(insert,
            Math.min(delete, replace));
    }
}