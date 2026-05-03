class Solution {
        public int search(int[] nums, int target) {
                int left = 0;
                        int right = nums.length - 1;

                                while (left <= right) {
                                            // Find the middle index (prevents overflow)
                                                        int mid = left + (right - left) / 2;

                                                                    if (nums[mid] == target) {
                                                                                    return mid; // Target found
                                                                                                } else if (nums[mid] < target) {
                                                                                                                left = mid + 1; // Look in the right half
                                                                                                                            } else {
                                                                                                                                            right = mid - 1; // Look in the left half
                                                                                                                                                        }
                                                                                                                                                                }

                                                                                                                                                                        return -1; // Target not found
                                                                                                                                                                            }
                                                                                                                                                                            }
