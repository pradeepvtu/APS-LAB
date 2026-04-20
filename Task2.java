import java.util.HashSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // Check if duplicate exists in window
            if (set.contains(nums[i])) {
                return true;
            }

            // Add current element
            set.add(nums[i]);

            // Remove element outside window of size k
            if (i >= k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}
