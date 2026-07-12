class Solution {
    public int sumFourDivisors(int[] nums) {
         int totalSum = 0;
        for (int n : nums) {
            int sum = 0;
            int count = 0;
            
            // Find divisors up to sqrt(n)
            for (int i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    count++;
                    sum += i;
                    
                    if (i != n / i) { // add the paired divisor
                        count++;
                        sum += n / i;
                    }
                }
                if (count > 4) break; // optimization: stop early
            }
            
            if (count == 4) {
                totalSum += sum;
            }
        }
        return totalSum;
    }
}