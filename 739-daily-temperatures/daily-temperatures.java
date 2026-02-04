import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices
        
        for (int i = 0; i < n; i++) {
            // Pop indices with smaller temperatures
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                answer[prevIndex] = i - prevIndex; // days to wait
            }
            stack.push(i);
        }
        
        // Remaining indices in stack have no warmer day, so answer[i] = 0 by default
        return answer;
    }
}
