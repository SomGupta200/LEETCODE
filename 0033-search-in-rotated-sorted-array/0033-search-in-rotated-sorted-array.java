class Solution {
    public int minimumIdx(int[] nums , int target ){
        int n = nums.length;
        int l = 0;
        int h = n-1;
        int mid= 0;
        while(l<h){
             mid = l + (h - l)/2;
            if(nums[mid] > nums[h]){
                l = mid+1;
            }else{
                h = mid;
            }
        }
        return l;
    }
    public int BS(int[] arr , int target , int low , int high){
        int n = arr.length;
        int ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
         return ans;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int minIdx = minimumIdx(nums , target);
        int right = BS(nums , target , minIdx , n-1);
        if(right == -1){
            return BS(nums , target , 0 , minIdx - 1);
        }
        return right;
    }
}