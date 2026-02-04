class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;  // position for next non-zero element
        
        // move all non-zero elements to the front
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        // fill remaining positions with zero
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
