class Solution {
    int findMax(int[] arr){
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length ; i ++){
            if(arr[i] > maxi) maxi = arr[i];
        }
        return maxi;
    }

    int findCeil(int[] arr , int value){
        int Ceil = 0;
        for(int i : arr){
            Ceil += Math.ceil((double) i / (double) value);
        }
        return Ceil;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1 , high = findMax(nums) , ans = Integer.MIN_VALUE;
        while(low <= high){
            int mid = (low + high) / 2;
            if(findCeil(nums , mid) <= threshold){
                 ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}