import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        // Deques to store indices of elements
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // Maintain maxDeque: remove elements smaller than current from the back
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            // Maintain minDeque: remove elements larger than current from the back
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            // If the absolute difference exceeds limit, shrink window from the left
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                // Remove indices that are now outside the window
                if (maxDeque.peekFirst() < left) maxDeque.pollFirst();
                if (minDeque.peekFirst() < left) minDeque.pollFirst();
            }
            
            // Update the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
