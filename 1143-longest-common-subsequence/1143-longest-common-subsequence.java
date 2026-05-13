class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new  Integer[n][m];
        return solve(0 , 0 , text1 , text2);
    }
    private int solve(int i, int j, String s1, String s2){
        if(i == s1.length() || j == s2.length()){
            return 0;
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1 + solve(i+1 , j+1 , s1 , s2);
        }
        return dp[i][j] = Math.max(
            solve(i+1 , j , s1 , s2),
            solve(i , j+1 , s1 , s2)
        );
    }
}