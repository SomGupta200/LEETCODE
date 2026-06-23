class Solution {
    int binarySearch(int[] nums , int low , int high , int target){
        int mid = (low + high) / 2;
        if(low > high) return -1;
        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return binarySearch(nums , 0 , mid-1 , target);
        else return binarySearch(nums , mid + 1 , high , target);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums , 0 , nums.length-1 , target);
    }
}