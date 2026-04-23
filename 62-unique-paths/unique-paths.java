class Solution {
    public int uniquePaths(int m, int n) {
        // Create a 1D array to store the number of paths to each column
        int[] dp = new int[n];
        
        // Fill the first row with 1s (only one way to go right)
        for (int j = 0; j < n; j++) {
            dp[j] = 1;
        }
        
        // Iterate through the remaining rows
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // dp[j] is the value from the cell above (from previous i loop)
                // dp[j-1] is the value from the cell to the left (already updated)
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        
        return dp[n - 1];
    }
}