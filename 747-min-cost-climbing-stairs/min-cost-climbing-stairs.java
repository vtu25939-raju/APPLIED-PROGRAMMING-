class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        
        // Start from index 2 because we can naturally start at 0 or 1
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        
        // The "top" is beyond the last index, so we take the min of the last two steps
        return Math.min(first, second);
    }
}