import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0; // Pointer for the popped array

        for (int val : pushed) {
            stack.push(val); // Push current element
            
            // Check if the top of the stack matches the current popped element
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++; // Move to the next element to be popped
            }
        }

        // If all elements were successfully matched and popped, stack will be empty
        return stack.isEmpty();
    }
}
