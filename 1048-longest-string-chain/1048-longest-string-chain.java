class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words,
            (a, b) -> a.length() - b.length());

        int n = words.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (isPredecessor(words[j],
                                  words[i])) {

                    dp[i] = Math.max(
                        dp[i],
                        1 + dp[j]
                    );
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    private boolean isPredecessor(
            String small,
            String large) {

        // length difference must be 1
        if (large.length() != small.length() + 1)
            return false;

        int i = 0;
        int j = 0;

        while (i < small.length()
            && j < large.length()) {

            if (small.charAt(i)
                == large.charAt(j)) {

                i++;
                j++;

            } else {

                // skip one char in larger string
                j++;
            }
        }

        // all chars of small matched
        return i == small.length();
    }
}