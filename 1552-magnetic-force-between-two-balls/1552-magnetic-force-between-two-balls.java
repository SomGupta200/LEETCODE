class Solution {
    boolean wePlace(int[] position , int dist , int balls){
        int cntCows = 1 , last = position[0]; 
        for(int i = 0 ; i < position.length ; i++){
            if(position[i] - last >= dist){
                cntCows ++;
                last = position[i];
            }
            if(cntCows >= balls) return true;
        }
        return false;
    }
    public int maxDistance(int[] position, int m) {
      Arrays.sort(position);
      int n = position.length;
      int low = 0 , high = position[n-1] - position[0];
      while(low <= high){
        int mid = (low + high) / 2;
        if(wePlace(position , mid , m) == true){
            low = mid + 1;
        }else {
          high = mid - 1;
        }
      }
      return high;
    }
}