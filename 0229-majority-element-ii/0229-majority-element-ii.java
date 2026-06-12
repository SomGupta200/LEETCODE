class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();
        int mini = n/3 + 1;
        for(int i = 0 ; i < n ; i++){
            int value = nums[i];
            map.put(value , map.getOrDefault(value , 0) + 1);
            if(map.get(value) == mini) ls.add(value);   
            if(ls.size() == 2) break;
        }
        Collections.sort(ls);
        return ls;
    }
}