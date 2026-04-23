class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int prev2 = 0; // Represents rob(i-2)
        int prev1 = 0; // Represents rob(i-1)
        
        for (int num : nums) {
            // Calculate max if we rob this house vs skip it
            int current = Math.max(prev2 + num, prev1);
            
            // Move our pointers forward
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
}