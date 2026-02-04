import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>(); // decreasing, max at front
        Deque<Integer> minDeque = new LinkedList<>(); // increasing, min at front
        
        int left = 0;
        int result = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // maintain maxDeque: remove smaller elements from back
            while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(nums[right]);
            
            // maintain minDeque: remove larger elements from back
            while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                minDeque.pollLast();
            }
            minDeque.offerLast(nums[right]);
            
            // shrink window if diff exceeds limit
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() && maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (nums[left] == maxDeque.peekFirst()) maxDeque.pollFirst();
                if (nums[left] == minDeque.peekFirst()) minDeque.pollFirst();
                left++;
            }
            
            result = Math.max(result, right - left + 1);
        }
        
        return result;
    }
}
