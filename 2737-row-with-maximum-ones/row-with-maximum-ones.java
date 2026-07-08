class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
      int n = mat.length;        // number of rows
        int m = mat[0].length;     // number of columns

        int maxCount = 0;
        int rowIndex = 0;          // default to 0 as per problem statement

        for (int i = 0; i < n; i++) {
            int countOnes = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    countOnes++;
                }
            }
            // update if this row has more ones
            if (countOnes > maxCount) {
                maxCount = countOnes;
                rowIndex = i;
            }
        }

        return new int[]{rowIndex, maxCount};   
    }
}