class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
         int MOD = 12345;

        int n = grid.length;
        int m = grid[0].length;

        int size = n * m;

        long[] prefix = new long[size];

        // Flatten index:
        // idx = i * m + j

        prefix[0] = 1;

        for (int idx = 1; idx < size; idx++) {

            int prevRow = (idx - 1) / m;
            int prevCol = (idx - 1) % m;

            prefix[idx] =
                (prefix[idx - 1] *
                 grid[prevRow][prevCol]) % MOD;
    }
     int[][] ans = new int[n][m];

        long suffix = 1;

        for (int idx = size - 1; idx >= 0; idx--) {

            int row = idx / m;
            int col = idx % m;

            ans[row][col] =
                (int)((prefix[idx] * suffix) % MOD);

            suffix =
                (suffix * grid[row][col]) % MOD;
        }

        return ans;
}
}