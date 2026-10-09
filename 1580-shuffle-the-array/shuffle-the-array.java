class Solution {
    public int[] shuffle(int[] nums, int n) {
       int i = 0;
       int j = n;
       int k = 0;
       int[] ans = new int[2*n];
       while(i<n){
        ans[k] = nums[i];
        i++;
        k++;
        ans[k] = nums[j];
        j++;
        k++;
       }
       return ans;
    }
}