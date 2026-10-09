class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        HashMap<Integer , Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.put(i , mp.getOrDefault(i , 0) +1);
            if(mp.get(i) > 2) return false;
        }
        return true;
    }
}