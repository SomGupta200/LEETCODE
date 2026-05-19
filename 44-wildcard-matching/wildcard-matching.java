class Solution {
        Boolean[][] dp;

        public boolean isMatch(String s, String p) {

        dp = new Boolean[s.length() + 1][p.length() + 1];

        return solve(0, 0, s, p);
    }
     private boolean solve(int i, int j,String s, String p) {

        // both finished
        if (i == s.length() && j == p.length()) {
            return true;
        }

        // pattern finished
        if (j == p.length()) {
            return false;
        }

        // string finished
        if (i == s.length()) {

            // remaining pattern must all be '*'
            while (j < p.length()) {

                if (p.charAt(j) != '*') {
                    return false;
                }

                j++;
            }

            return true;
        }

        if (dp[i][j] != null)
            return dp[i][j];

        // match or '?'
        if (s.charAt(i) == p.charAt(j)
            || p.charAt(j) == '?') {

            return dp[i][j] =
                solve(i + 1, j + 1, s, p);
        }

        // '*'
        if (p.charAt(j) == '*') {

            boolean empty =
                solve(i, j + 1, s, p);

            boolean consume =
                solve(i + 1, j, s, p);

            return dp[i][j] =
                empty || consume;
        }

        return dp[i][j] = false;
    }
}