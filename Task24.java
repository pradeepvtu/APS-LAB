class Solution {
    public String minRemoveToMakeValid(String s) {
        // Use a set to store indices of parentheses that need to be removed
        Set<Integer> indicesToRemove = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    // This ')' has no matching '('
                    indicesToRemove.add(i);
                } else {
                    // Match found, remove the '(' index from stack
                    stack.pop();
                }
            }
        }
        
        // Anything left in the stack are '(' that never found a ')'
        while (!stack.isEmpty()) {
            indicesToRemove.add(stack.pop());
        }
        
        // Build the result string skipping the invalid indices
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indicesToRemove.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}
