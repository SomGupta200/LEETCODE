class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n-1;
        int idx = n-1;
        while(left <= right){
            int left_square = nums[left] * nums[left];
            int right_square = nums[right] * nums[right];

            if(left_square > right_square){
                ans[idx] = left_square;
                left ++;
            }else{
                ans[idx] = right_square;
                right --;
            }
            idx --;
        }
        return ans;
    }
}