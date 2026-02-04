import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;

            while (!stack.isEmpty() && ast < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -ast) {
                    // top asteroid explodes
                    stack.pop();
                    continue; // keep checking collisions
                } else if (top == -ast) {
                    // both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // current asteroid explodes
                    exploded = true;
                    break;
                }
            }

            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
