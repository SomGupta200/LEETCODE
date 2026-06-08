class Solution {
    public void reverse(int r , int i , int j , int[][] matrix){
        while(i < j){
            int temp = matrix[r][i];
            matrix[r][i] = matrix[r][j];
            matrix[r][j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        for(int i = 0 ; i < r ; i++){
            for(int j = i ; j < c ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0 ; i < r ; i++){
            reverse(i , 0 , r-1 , matrix);
        }
    }
}