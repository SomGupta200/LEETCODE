class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];
        int prev = -100000; 
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == c){
                prev = i;
            }
            ans[i] = i-prev;
        }
          prev = 100000; 
        for(int i=n-1;i>=0;i--){
            char ch = s.charAt(i);
            if(ch == c){
                prev = i;
            }
            ans[i] = Math.min(ans[i] , Math.abs(i-prev));
        }
        return ans;
    }
}