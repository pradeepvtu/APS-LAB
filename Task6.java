class Solution {
    public void sortColors(int[] nums) {
        // low tracks the boundary for 0s
        int low = 0;
        // mid is the current element under inspection
        int mid = 0;
        // high tracks the boundary for 2s
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                // If we find a 0, move it to the front (low)
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                // If we find a 1, it's already in the correct relative area
                mid++;
            } else {
                // If we find a 2, move it to the end (high)
                swap(nums, mid, high);
                high--;
                // We do NOT increment mid here because the swapped value 
                // from 'high' needs to be inspected.
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
