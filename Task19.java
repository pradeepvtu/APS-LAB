import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store: element -> its next greater element
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Iterate through nums2 to find next greater elements
        for (int num : nums2) {
            // While stack is not empty and current num is greater than stack's top
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            // Push current num onto stack to find its next greater later
            stack.push(num);
        }

        // Prepare the result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            // If it exists in map, use it; otherwise, it's -1
            result[i] = nextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return result;
    }
}
