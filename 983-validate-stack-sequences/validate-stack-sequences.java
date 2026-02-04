import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for popped

        for (int val : pushed) {
            stack.push(val); // push current value
            // pop from stack while top matches popped[j]
            while (!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // if stack is empty, all pops are valid
        return stack.isEmpty();
    }
}
