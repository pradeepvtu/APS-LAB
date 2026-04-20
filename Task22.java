import java.util.Stack;

class Solution {
    public int[] finalPrices(int[] prices) {
        // Stack will store the indices of the prices
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < prices.length; i++) {
            // While the current price is less than or equal to the price 
            // at the index stored at the top of the stack
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] -= prices[i]; // Apply the discount
            }
            // Push the current index onto the stack
            stack.push(i);
        }
        
        return prices;
    }
}
