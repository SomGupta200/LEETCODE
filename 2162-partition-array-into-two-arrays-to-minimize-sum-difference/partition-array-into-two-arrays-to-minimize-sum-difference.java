class Solution {
    public int minimumDifference(int[] nums) {
         int n = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, 2 * n);

        List<List<Integer>> leftSum = new ArrayList<>();
        List<List<Integer>> rightSum = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            leftSum.add(new ArrayList<>());
            rightSum.add(new ArrayList<>());
        }

        // Generate subset sums
        generate(left, leftSum);
        generate(right, rightSum);

        // Sort right for binary search
        for (int i = 0; i <= n; i++) {
            Collections.sort(rightSum.get(i));
        }

        int total = 0;
        for (int x : nums) total += x;

        int ans = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {

            for (int s1 : leftSum.get(k)) {

                int target = total / 2 - s1;

                List<Integer> list = rightSum.get(n - k);

                int idx = Collections.binarySearch(list, target);

                if (idx < 0) idx = -idx - 1;

                // Check neighbors
                if (idx < list.size()) {
                    int s2 = list.get(idx);
                    int sum = s1 + s2;
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }

                if (idx > 0) {
                    int s2 = list.get(idx - 1);
                    int sum = s1 + s2;
                    ans = Math.min(ans, Math.abs(total - 2 * sum));
                }
            }
        }

        return ans;
    }

    private void generate(int[] arr, List<List<Integer>> res) {
        int n = arr.length;

        for (int mask = 0; mask < (1 << n); mask++) {

            int sum = 0;
            int count = 0;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += arr[i];
                    count++;
                }
            }

            res.get(count).add(sum);
    }
}
}