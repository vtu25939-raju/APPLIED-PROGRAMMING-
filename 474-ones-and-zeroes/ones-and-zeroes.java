class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] = max strings we can include with i zeros and j ones
        int[][] dp = new int[m + 1][n + 1];
        
        for (String s : strs) {
            int[] count = countZerosOnes(s);
            int zeros = count[0];
            int ones = count[1];
            
            // Iterate backwards to reuse the same 2D array (0/1 Knapsack optimization)
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }
    
    private int[] countZerosOnes(String s) {
        int[] count = new int[2];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        return count;
    }
}