class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer , Integer> mp = new HashMap<>();
        int ans = 0;
        for(int i : nums ){
            mp.put(i , mp.getOrDefault(i , 0) + 1);
        }
        for(Map.Entry<Integer , Integer> i : mp.entrySet()){
            if(i.getValue() > n/2){
                 ans = i.getKey();
                break;
            }
        }
        return ans;
    }
}