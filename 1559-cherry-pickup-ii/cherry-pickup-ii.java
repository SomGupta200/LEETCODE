class Solution {
    public int cherryPickup(int[][] grid) {
         int r = grid.length, c = grid[0].length;

        int[][] prev = new int[c][c];

        for (int[] row : prev) Arrays.fill(row, -1);

        prev[0][c - 1] = grid[0][0] + grid[0][c - 1];

        for (int i = 1; i < r; i++) {
            int[][] curr = new int[c][c];
            for (int[] row : curr) Arrays.fill(row, -1);

            for (int j1 = 0; j1 < c; j1++) {
                for (int j2 = 0; j2 < c; j2++) {

                    if (prev[j1][j2] == -1) continue;

                    for (int d1 = -1; d1 <= 1; d1++) {
                        for (int d2 = -1; d2 <= 1; d2++) {

                            int nj1 = j1 + d1;
                            int nj2 = j2 + d2;

                            if (nj1 >= 0 && nj1 < c &&
                                nj2 >= 0 && nj2 < c) {

                                int val = prev[j1][j2] + grid[i][nj1];

                                if (nj1 != nj2)
                                    val += grid[i][nj2];

                                curr[nj1][nj2] = Math.max(
                                    curr[nj1][nj2], val);
                            }
                        }
                    }
                }
            }

            prev = curr;
        }

        int ans = 0;
        for (int[] row : prev) {
            for (int val : row) {
                ans = Math.max(ans, val);
            }
        }

        return ans;
    }
}