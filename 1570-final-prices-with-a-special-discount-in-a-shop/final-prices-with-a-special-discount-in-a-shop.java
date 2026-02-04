import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // store indices

        for (int i = 0; i < n; i++) {
            // Pop indices where prices[i] is the discount
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }

        // Fill remaining indices with no discount
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = prices[idx];
        }

        return answer;
    }
}
