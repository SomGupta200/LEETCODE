class Solution {
     // Function to calculate how many days are needed with given capacity
    public int findDays(int[] weights, int cap) {
        int days = 1;
        int load = 0;

        for (int w : weights) {
            if (load + w > cap) {
                days++;
                load = w;
            } else {
                load += w;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;

        // low = max element, high = sum of all weights
        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int requiredDays = findDays(weights, mid);

            if (requiredDays <= days) {
                high = mid - 1;   // try smaller capacity
            } else {
                low = mid + 1;    // need bigger capacity
            }
        }

        return low;

    }
}