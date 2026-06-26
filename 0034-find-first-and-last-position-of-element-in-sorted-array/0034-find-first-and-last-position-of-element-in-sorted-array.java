class Solution {
    public int lb(int[] nums , int n){
        int low = 0 , high = nums.length - 1 , s = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == n){
                s = mid;
                high = mid - 1;
            }else if(nums[mid] < n){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return s;
    }
    public int ub(int[] nums , int n){
       int low = 0 , high = nums.length - 1 , e = -1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == n){
                e = mid;
               low = mid + 1;
            }else if(nums[mid] < n){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return e;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = lb(nums , target);
        if(ans[0] == -1){
            return new int[]{-1 , -1};
        }
        ans[1] = ub(nums , target);
        return ans;
    }
}