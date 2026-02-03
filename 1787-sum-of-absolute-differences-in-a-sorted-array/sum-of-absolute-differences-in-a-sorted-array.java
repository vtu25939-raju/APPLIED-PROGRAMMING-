public class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int[] result = new int[n];
        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            // sum of elements to the right
            int rightSum = totalSum - leftSum - nums[i];
            
            // count of elements to the left and right
            int leftCount = i;
            int rightCount = n - 1 - i;

            // Calculate absolute differences using the prefix/suffix sums
            int leftTotalDiff = (leftCount * nums[i]) - leftSum;
            int rightTotalDiff = rightSum - (rightCount * nums[i]);

            result[i] = leftTotalDiff + rightTotalDiff;

            // Update leftSum for the next iteration
            leftSum += nums[i];
        }

        return result;
    }
}