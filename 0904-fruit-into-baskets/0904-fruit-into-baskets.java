class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer , Integer> mp = new HashMap<>();
        int start = 0 , end = 0 , maxLen = 0;
        while(end < n){
            int num = fruits[end];
            mp.put(num , mp.getOrDefault(num , 0)+1);
            if(mp.size()>2){
                mp.put(fruits[start] , mp.get(fruits[start])-1);
                if(mp.get(fruits[start]) == 0){
                    mp.remove(fruits[start]);
                }
                start ++;
            }
            maxLen = Math.max(end - start + 1 , maxLen);
            end ++;
        }
        return maxLen;
    }
}