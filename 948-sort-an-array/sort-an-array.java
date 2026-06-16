class Solution {
    void merge(int[] arr , int low , int mid , int high){
        int[] temp = new int[high+1];
        int left = low;
        int right = mid+1;
        int idx = 0;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp[idx ++] = arr[left];
                left ++;
            }else{
               temp[idx ++] = arr[right];
                right ++;
            }
        }
            while(left <= mid){
                temp[idx ++] = arr[left];
                left ++;
            }
            while(right <= high){
                temp[idx ++] = arr[right];
                right ++;
            }
            for(int i = low ; i <= high ; i++){
                arr[i] = temp[i-low];
            }
        }
    void ms(int[] arr , int low , int high){
        if(low == high) return;
         int mid = (low + high) / 2;
        ms(arr , low , mid);
        ms(arr , mid+1 , high);
        merge(arr , low , mid , high);
    }
    public int[] sortArray(int[] nums) {
    int n = nums.length;
    ms(nums , 0 , n-1);
    return nums;
    }
}