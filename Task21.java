import java.util.Stack;

class StockSpanner {
    // We use a stack to store pairs: [price, span]
    // int[0] = price, int[1] = span
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        
        // While stack is not empty and the previous price is <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the previous price to the current span
            span += stack.pop()[1];
        }
        
        // Push the current price and its cumulative span onto the stack
        stack.push(new int[]{price, span});
        
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
