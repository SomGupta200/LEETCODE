class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int n = nums.length;

        int[] len = new int[n];
        int[] cnt = new int[n];

        Arrays.fill(len, 1);
        Arrays.fill(cnt, 1);

        int maxi = 1;

        for(int i = 0; i < n; i++) {

            for(int j = 0; j < i; j++) {

                if(nums[j] < nums[i]) {

                    // longer LIS found
                    if(len[j] + 1 > len[i]) {

                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }

                    // another way to get same LIS
                    else if(len[j] + 1 == len[i]) {

                        cnt[i] += cnt[j];
                    }
                }
            }

            maxi = Math.max(maxi, len[i]);
        }

        int ans = 0;

        for(int i = 0; i < n; i++) {

            if(len[i] == maxi) {

                ans += cnt[i];
            }
        }

        return ans;
    }
}