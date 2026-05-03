class Solution {
        public int[] runningSum(int[] nums) {
                // We can modify the array in-place to save space
                        for (int i = 1; i < nums.length; i++) {
                                    // Each element becomes the sum of itself and the previous element
                                                nums[i] = nums[i] + nums[i - 1];
                                                        }
                                                                return nums;
                                                                    }
                                                                    }
