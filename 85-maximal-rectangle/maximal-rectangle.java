class Solution {
    public int maximalRectangle(char[][] matrix) {
         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            // Step 1: Update heights
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Step 2: Largest rectangle in histogram
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }
       public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];   // previous smaller index
        int[] right = new int[n];  // next smaller index

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Step 1: Previous Smaller Element (PSE)
        for (int i = 0; i < n; i++) {
            while (!stack1.isEmpty() && heights[stack1.peek()] >= heights[i]) {
                stack1.pop();
            }
            left[i] = stack1.isEmpty() ? -1 : stack1.peek();
            stack1.push(i);
        }

        // Step 2: Next Smaller Element (NSE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && heights[stack2.peek()] >= heights[i]) {
                stack2.pop();
            }
            right[i] = stack2.isEmpty() ? n : stack2.peek();
            stack2.push(i);
        }

        // Step 3: Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
 }
        return maxArea;
    }
}