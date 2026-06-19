class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> duplicate = new ArrayList<>();
        if(nums.length <= 1) return duplicate;
        for(int i = 0 ; i < nums.length-1 ; i++){
            if(nums[i] == nums[i+1]){
                if(duplicate.isEmpty() || duplicate.get(duplicate.size() - 1) != nums[i]){
                    duplicate.add(nums[i]);
                }
            }
        }
        return duplicate;
    }
}