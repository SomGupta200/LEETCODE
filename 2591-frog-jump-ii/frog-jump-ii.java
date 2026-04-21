class Solution {
    public int maxJump(int[] stones) {
        int n = stones.length;
        if(n==2){
            return stones[1]-stones[0];
        }
        int maxCost = 0;
        for (int i = 2; i < n; i++) {
            maxCost = Math.max(maxCost, stones[i] - stones[i - 2]);
        }
        return maxCost;
    }
}