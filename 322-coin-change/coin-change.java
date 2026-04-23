import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create DP array and fill with a value larger than any possible answer
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // Base case: 0 coins needed to make 0 amount
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    // Min coins for current i is the minimum of 
                    // its current value or (1 + coins needed for i - coin)
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still max, it means the amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}