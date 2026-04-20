class Solution {
    public boolean canCross(int[] stones) {
        int n = stones.length;

        // dp[i] = set of jumps that can reach stone i
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            dp.add(new HashSet<>());
        }

        // base case
        dp.get(0).add(0);

        for (int i = 0; i < n; i++) {
            for (int k : dp.get(i)) {

                for (int j = i + 1; j < n; j++) {
                    int gap = stones[j] - stones[i];

                    if (gap < k - 1) continue;
                    if (gap > k + 1) break;

                    dp.get(j).add(gap);
                }
            }
        }

        return !dp.get(n - 1).isEmpty();
    }
}