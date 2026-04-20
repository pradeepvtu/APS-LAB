import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {
            boolean exploded = false;

            // Collision condition: 
            // Stack top is moving right (+) and current asteroid is moving left (-)
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                if (Math.abs(stack.peek()) < Math.abs(ast)) {
                    // Stack top is smaller, it explodes, continue checking
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(ast)) {
                    // Both are same size, both explode
                    stack.pop();
                    exploded = true;
                    break;
                } else {
                    // Current asteroid is smaller, it explodes
                    exploded = true;
                    break;
                }
            }

            // If the current asteroid didn't explode, add it to stack
            if (!exploded) {
                stack.push(ast);
            }
        }

        // Convert Stack to int array
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}
