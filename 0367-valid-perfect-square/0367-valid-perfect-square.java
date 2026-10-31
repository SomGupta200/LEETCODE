class Solution {
    public boolean isPerfectSquare(int num) {
        long l = 1;
        long high = num;
        while(l <= high){
             long mid = l + (high-l)/2;
            if(mid*mid == num) return true;
            else if(mid*mid < num){
                l = mid + 1;
            }else {
                high = mid- 1;
            }
        }
        return false;
    }
}