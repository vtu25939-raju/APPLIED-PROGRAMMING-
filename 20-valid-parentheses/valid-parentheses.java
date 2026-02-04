import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '{') stack.push('}');
            else if (c == '[') stack.push(']');
            else {
                // If stack is empty or top is not matching closing bracket
                if (stack.isEmpty() || stack.pop() != c) return false;
            }
        }
        
        return stack.isEmpty();
    }
}
